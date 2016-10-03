package mm.michalik.controller;

import mm.michalik.domain.Expense;
import mm.michalik.domain.ExpenseDetail;
import mm.michalik.domain.ExpenseDetailContainer;
import mm.michalik.service.CategoryService;
import mm.michalik.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by maciej on 10.09.16.
 */
@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    private ExpenseService expenseService;
    private ExpenseDetailContainer detailContainer;

    @Autowired
    public void setDetailContainer(ExpenseDetailContainer detailContainer) {
        this.detailContainer = detailContainer;
    }

    @Autowired
    public void setExpenseService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }





    @RequestMapping(value = "/add")
    public String newExpenses(Model model){


        model.addAttribute("category", categoryService.listAll());
        model.addAttribute("container", detailContainer);
        model.addAttribute("date", LocalDate.now());


        return "/expense/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdateList(ExpenseDetailContainer expenseDetailContainer){


        List<ExpenseDetail> exList=expenseDetailContainer.getExpenseDetailList();


        Expense expense=new Expense();

        exList.removeIf(detail -> detail.getAmount()==null || detail.getAmount().compareTo(BigDecimal.ZERO)<=0);
        exList.forEach(detail -> detail.setExpense(expense));

        expense.setExpenseDetails(exList);



        if(expense.getExpenseDetails().size()>0){
            expenseService.saveOrUpdate(expense);
        }



        return "redirect:/";

    }


}


