package projet.grand.service.facade;

import projet.grand.bean.commun.Category;

public interface CategoryService {
    int save(Category category);

    Category findByName(String name);

    int deleteByName(String name);
}
