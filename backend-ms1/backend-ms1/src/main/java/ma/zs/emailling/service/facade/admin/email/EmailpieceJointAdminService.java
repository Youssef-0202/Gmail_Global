package ma.zs.emailling.service.facade.admin.email;

import java.util.List;
import ma.zs.emailling.bean.core.email.EmailpieceJoint;
import ma.zs.emailling.dao.criteria.core.email.EmailpieceJointCriteria;
import ma.zs.emailling.zynerator.service.IService;



public interface EmailpieceJointAdminService extends  IService<EmailpieceJoint,EmailpieceJointCriteria>  {

    List<EmailpieceJoint> findByEmailId(Long id);
    int deleteByEmailId(Long id);
    long countByEmailRef(String ref);
    List<EmailpieceJoint> findByTypeContenuId(Long id);
    int deleteByTypeContenuId(Long id);
    long countByTypeContenuCode(String code);




}
