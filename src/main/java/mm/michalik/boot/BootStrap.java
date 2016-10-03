package mm.michalik.boot;

import mm.michalik.commands.UserForm;
import mm.michalik.domain.Category;
import mm.michalik.domain.Expense;
import mm.michalik.domain.ExpenseDetail;
import mm.michalik.service.CategoryService;
import mm.michalik.service.ExpenseService;
import mm.michalik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by maciej on 01.09.16.
 */
@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent> {



    private UserService userService;
    private CategoryService categoryService;
    private ExpenseService expenseService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setExpenseService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initUser();

        initCat();
        initExpense();
    }


    public void initUser(){
        UserForm usr1=new UserForm();

        usr1.setUserName("maciej");
        usr1.setPasswordText("maciej");
        usr1.setFirstName("Maciej");
        usr1.setLastName("Michalik");


        UserForm usr2=new UserForm();

        usr2.setUserName("dragon");
        usr2.setPasswordText("maciej");
        usr2.setFirstName("Maciej");
        usr2.setLastName("Michalik");

        userService.saveOrUpdateUserForm(usr1);
        userService.saveOrUpdateUserForm(usr2);




    }
    public void initCat(){

        Category a=new Category();
        a.setCategoryName("Słodycze");
        Category b=new Category();
        b.setCategoryName("Chemia");

        Category c=new Category();
        c.setCategoryName("Paliwo");
        categoryService.saveOrUpdate(a);
        categoryService.saveOrUpdate(b);
        categoryService.saveOrUpdate(c);
    }

    public void initExpense(){
        Expense e=new Expense();

        ExpenseDetail a1=new ExpenseDetail();
        a1.setCategory(categoryService.getById(3));
        a1.setAmount(new BigDecimal(10));
        a1.setExpense(e);

        ExpenseDetail a2=new ExpenseDetail();
       a2.setCategory(categoryService.getById(4));
        a2.setAmount(new BigDecimal(10));
        a2.setExpense(e);

        e.addToExpenseDetails(a1);
        e.addToExpenseDetails(a2);

       // e.setSum();





        ExpenseDetail a1a=new ExpenseDetail();
       a1a.setCategory(categoryService.getById(3));
        a1a.setAmount(new BigDecimal(10));
        a1a.setExpense(e);

        ExpenseDetail a2a=new ExpenseDetail();
       a2a.setCategory(categoryService.getById(4));
        a2a.setAmount(new BigDecimal(10));
        a2a.setExpense(e);

        e.addToExpenseDetails(a1a);
        e.addToExpenseDetails(a2a);


        e.setDateCreated(LocalDate.of(2016,9,11));
        expenseService.saveOrUpdate(e);



    }


}
