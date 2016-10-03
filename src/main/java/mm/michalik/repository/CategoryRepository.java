package mm.michalik.repository;

import mm.michalik.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by maciej on 10.09.16.
 */
public interface CategoryRepository extends CrudRepository<Category,Integer> {

}
