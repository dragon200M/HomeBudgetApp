package mm.michalik.service.springData;

import mm.michalik.domain.Category;
import mm.michalik.repository.CategoryRepository;
import mm.michalik.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maciej on 10.09.16.
 */
@Service
public class CategoryRepositoryImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<?> listAll() {
        List<Category> catlist=new ArrayList<>();

        categoryRepository.findAll().forEach(catlist::add);

        return catlist;
    }

    @Override
    public Category getById(Integer id) {

        return categoryRepository.findOne(id);
    }

    @Override
    public Category saveOrUpdate(Category domainObject) {


        return categoryRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {

        categoryRepository.delete(id);

    }
}
