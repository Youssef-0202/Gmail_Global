package projet.grand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.grand.bean.commun.Category;
import projet.grand.dao.commun.CategoryDao;
import projet.grand.service.facade.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public  int save(Category category){
        if (findByName(category.getName())!=null){
            return -1;
        }
        else {
            categoryDao.save(category);
            return 1;
        }
    }
    @Override
    public Category findByName(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public int deleteByName(String name) {
        return categoryDao.deleteByName(name);
    }

}
