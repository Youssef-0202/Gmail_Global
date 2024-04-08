package projet.grand.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.grand.bean.commun.Contact;
import projet.grand.dao.commun.ContactDao;
import projet.grand.service.facade.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public int save(Contact contact){
        if (findByName(contact.getName())!=null){
            return -1;
        }

        else {
            contactDao.save(contact);
            return 1;
        }
    }
    @Override
    public Contact findByName(String name) {
        return contactDao.findByName(name);
    }
    @Override
    public int deleteByName(String name) {
        return contactDao.deleteByName(name);
    }

}
