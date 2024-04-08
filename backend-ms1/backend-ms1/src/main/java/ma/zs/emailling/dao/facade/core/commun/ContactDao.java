package ma.zs.emailling.dao.facade.core.commun;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.commun.Contact;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ContactDao extends AbstractRepository<Contact,Long>  {

    List<Contact> findByPersonneSourceId(Long id);
    int deleteByPersonneSourceId(Long id);
    long countByPersonneSourceId(Long id);
    List<Contact> findByPersonneDestinationId(Long id);
    int deleteByPersonneDestinationId(Long id);
    long countByPersonneDestinationId(Long id);


}
