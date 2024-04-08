package projet.grand.dao.email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.grand.bean.email.EmailPieceJoint;

import java.util.List;

@Repository
public interface EmailPieceJointDao extends JpaRepository<EmailPieceJoint,Long> {

}
