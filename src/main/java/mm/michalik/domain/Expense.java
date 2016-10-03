package mm.michalik.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by maciej on 10.09.16.
 */
@Entity
@Table(name="EXPENSE_HEADER")
public class Expense extends AbstractDomainClass {



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expense", orphanRemoval = true)
    private List<ExpenseDetail> expenseDetails=new ArrayList<>();


    private BigDecimal sum;

    public List<ExpenseDetail> getExpenseDetails() {
        return expenseDetails;
    }


    public void setExpenseDetails(List<ExpenseDetail> expenseDetails) {
        this.expenseDetails = expenseDetails;
    }

    public void addToExpenseDetails(ExpenseDetail expenseDetail){
        expenseDetail.setExpense(this);
        expenseDetails.add(expenseDetail);
    }



     public void removeToExpenseDetails(ExpenseDetail expenseDetail){
        expenseDetail.setExpense(null);
        expenseDetails.remove(expenseDetail);
    }

    public BigDecimal getSum() {
        return sum;
    }


    public void setSum() {

        if(expenseDetails.isEmpty()== false){
            this.sum=expenseDetails.stream()
                    .filter(Objects::nonNull)
                    .filter(c -> c.getAmount() !=null)
                    .map(ExpenseDetail:: getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

        }else{
            this.sum=new BigDecimal(0);

        }


    }

    public void addListToExpensesDetailsList(List<ExpenseDetail> expenseDetailsList){

        this.expenseDetails.addAll(expenseDetailsList);


    }

    @Override
    public String toString() {
        return "Expense{" +super.toString()+
                "sum=" + sum +
                '}';
    }
}
