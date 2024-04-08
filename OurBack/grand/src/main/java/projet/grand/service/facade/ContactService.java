package projet.grand.service.facade;

import projet.grand.bean.commun.Contact;

public interface ContactService {
    int save(Contact contact);

    Contact findByName(String name);

    int deleteByName(String name);
}
