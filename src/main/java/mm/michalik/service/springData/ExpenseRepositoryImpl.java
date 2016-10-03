package mm.michalik.service.springData;

import mm.michalik.domain.Expense;
import mm.michalik.repository.ExpenseDetailRepository;
import mm.michalik.repository.ExpenseRepository;
import mm.michalik.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maciej on 10.09.16.
 */
@Service
public class ExpenseRepositoryImpl implements ExpenseService {


    private ExpenseRepository expenseRepository;

    @Autowired
    public void setExpenseRepository(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    private ExpenseDetailRepository expenseDetailRepository;

    @Autowired
    public void setExpenseDetailRepository(ExpenseDetailRepository expenseDetailRepository) {
        this.expenseDetailRepository = expenseDetailRepository;
    }

    @Override
    public List<Expense> listAll() {
        List<Expense> ex=new ArrayList<>();

        expenseRepository.findAll().forEach(ex::add);


        return ex;
    }

    @Override
    public Expense getById(Integer id) {


        return expenseRepository.findOne(id);
    }

    @Override
    public Expense saveOrUpdate(Expense domainObject) {


        List<Expense> expenses=expenseRepository.findByDateCreated(LocalDate.now());


        if(expenses.size()>0){
            Expense expenseToSave=domainObject;
            Expense expen=expenses.get(0);
            expen.getExpenseDetails().size();

            expenseToSave.getExpenseDetails().forEach(detail ->detail.setExpense(expen));
            expenseDetailRepository.save(expenseToSave.getExpenseDetails());


            expen.addListToExpensesDetailsList(expenseToSave.getExpenseDetails());
            expen.setSum();


            return expenseRepository.save(expen);
        }else{
            domainObject.setSum();
            return expenseRepository.save(domainObject);

        }
    }

    @Override
    public void delete(Integer id) {

        expenseRepository.delete(id);

    }
}
