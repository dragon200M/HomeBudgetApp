package mm.michalik.repository;

import mm.michalik.domain.ExpenseDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by maciej on 12.09.16.
 */
public interface ExpenseDetailRepository extends CrudRepository<ExpenseDetail, Integer> {
}
