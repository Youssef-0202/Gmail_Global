package projet.grand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.grand.bean.commun.Category;
import projet.grand.bean.commun.User;
import projet.grand.bean.email.Email;
import projet.grand.dao.email.EmailDao;
import projet.grand.service.facade.CategoryService;
import projet.grand.service.facade.EmailService;
import projet.grand.service.facade.UserService;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailDao emailDao;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @Override
    public  int save(Email email){
        if(email.getCategory()!=null){
            Category category=categoryService.findByName(email.getCategory().getName());
            email.setCategory(category);
        }
        if(email.getPersonneSource()!=null){
            User personneSource = userService.findByEmail(email.getPersonneSource().getEmail());
            email.setPersonneSource(personneSource);
        }

        if (findByRef(email.getRef())!=null){
            return -1;
        }
        else {
            emailDao.save(email);
            return 1;
        }
    }

    @Override
    public Email findByRef(String ref) {
        return emailDao.findByRef(ref);
    }
    @Override
    public int deleteByRef(String ref) {
        return emailDao.deleteByRef(ref);
    }
    @Override
    public List<Email> findByPersonneSourceEmail(String email) {
        return emailDao.findByPersonneSourceEmail(email);
    }

    @Override
    public int deleteByPersonneSourceEmail(String email) {
        return emailDao.deleteByPersonneSourceEmail(email);
    }
    @Override
    public List<Email> findByCategoryName(String name) {
        return emailDao.findByCategoryName(name);
    }
    @Override
    public int deleteByCategoryName(String name) {
        return emailDao.deleteByCategoryName(name);
    }

}
