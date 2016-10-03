package mm.michalik.service;

import java.util.List;

/**
 * Created by maciej on 01.09.16.
 */
public interface CrudService<T> {

    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
