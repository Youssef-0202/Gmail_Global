package ma.zs.emailling.dao.facade.core.email;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.email.EmailpieceJoint;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmailpieceJointDao extends AbstractRepository<EmailpieceJoint,Long>  {

    List<EmailpieceJoint> findByEmailId(Long id);
    int deleteByEmailId(Long id);
    long countByEmailRef(String ref);
    List<EmailpieceJoint> findByTypeContenuId(Long id);
    int deleteByTypeContenuId(Long id);
    long countByTypeContenuCode(String code);


}
