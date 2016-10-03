package mm.michalik.repository;

import mm.michalik.domain.Expense;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by maciej on 10.09.16.
 */
public interface ExpenseRepository extends CrudRepository<Expense,Integer> {
    List<Expense> findByDateCreated(LocalDate date);

}
