package mm.michalik.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by maciej on 10.09.16.
 */
@Entity
public class ExpenseDetail extends AbstractDomainClass {


    @ManyToOne
    private Expense expense;
    private BigDecimal amount;

    @ManyToOne
    private Category category;


    private String description;


    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
