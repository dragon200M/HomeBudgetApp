package mm.michalik.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maciej on 11.09.16.
 */
public class  ExpenseDetailContainer {
    private static int numberOfContainer=0;
    private int id;

    private List<ExpenseDetail> expenseDetailList=new ArrayList<>();

    public List<ExpenseDetail> getExpenseDetailList() {
        return expenseDetailList;
    }

    public void setExpenseDetailList(List<ExpenseDetail> expenseDetailList) {
        this.expenseDetailList = expenseDetailList;
    }

    public void addToExpenseDetailsList(ExpenseDetail expenseDetail){
        id=++numberOfContainer;
        expenseDetailList.add(expenseDetail);
    }

    public void  removeFromExpenseDetailsList(ExpenseDetail expenseDetail){
        expenseDetailList.remove(expenseDetail);
    }


    public int getId() {
        return id;
    }
}
