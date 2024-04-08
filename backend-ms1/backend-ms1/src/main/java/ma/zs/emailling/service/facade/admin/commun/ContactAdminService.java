package ma.zs.emailling.service.facade.admin.commun;

import java.util.List;
import ma.zs.emailling.bean.core.commun.Contact;
import ma.zs.emailling.dao.criteria.core.commun.ContactCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface ContactAdminService extends  IService<Contact,ContactCriteria>  {

    List<Contact> findByPersonneSourceId(Long id);
    int deleteByPersonneSourceId(Long id);
    long countByPersonneSourceId(Long id);
    List<Contact> findByPersonneDestinationId(Long id);
    int deleteByPersonneDestinationId(Long id);
    long countByPersonneDestinationId(Long id);




}
