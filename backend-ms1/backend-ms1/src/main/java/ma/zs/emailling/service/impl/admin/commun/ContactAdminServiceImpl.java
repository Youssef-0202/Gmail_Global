package ma.zs.emailling.service.impl.admin.commun;


import ma.zs.emailling.bean.core.commun.Contact;
import ma.zs.emailling.dao.criteria.core.commun.ContactCriteria;
import ma.zs.emailling.dao.facade.core.commun.ContactDao;
import ma.zs.emailling.dao.specification.core.commun.ContactSpecification;
import ma.zs.emailling.service.facade.admin.commun.ContactAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import ma.zs.emailling.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService ;
import ma.zs.emailling.bean.core.commun.Utilisateur ;

import java.util.List;
@Service
public class ContactAdminServiceImpl extends AbstractServiceImpl<Contact, ContactCriteria, ContactDao> implements ContactAdminService {






    public void findOrSaveAssociatedObject(Contact t){
        if( t != null) {
            t.setPersonneSource(utilisateurService.findOrSave(t.getPersonneSource()));
            t.setPersonneDestination(utilisateurService.findOrSave(t.getPersonneDestination()));
        }
    }

    public List<Contact> findByPersonneSourceId(Long id){
        return dao.findByPersonneSourceId(id);
    }
    public int deleteByPersonneSourceId(Long id){
        return dao.deleteByPersonneSourceId(id);
    }
    public long countByPersonneSourceId(Long id){
        return dao.countByPersonneSourceId(id);
    }
    public List<Contact> findByPersonneDestinationId(Long id){
        return dao.findByPersonneDestinationId(id);
    }
    public int deleteByPersonneDestinationId(Long id){
        return dao.deleteByPersonneDestinationId(id);
    }
    public long countByPersonneDestinationId(Long id){
        return dao.countByPersonneDestinationId(id);
    }






    public void configure() {
        super.configure(Contact.class, ContactSpecification.class);
    }


    @Autowired
    private UtilisateurAdminService utilisateurService ;

    public ContactAdminServiceImpl(ContactDao dao) {
        super(dao);
    }

}
