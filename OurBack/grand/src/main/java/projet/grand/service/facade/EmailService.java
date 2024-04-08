package projet.grand.service.facade;

import projet.grand.bean.email.Email;

import java.util.List;

public interface EmailService {


    int save(Email email);

    Email findByRef(String ref);

    int deleteByRef(String ref);

    List<Email> findByPersonneSourceEmail(String email);

    int deleteByPersonneSourceEmail(String email);

    List<Email> findByCategoryName(String name);

    int deleteByCategoryName(String name);
}
