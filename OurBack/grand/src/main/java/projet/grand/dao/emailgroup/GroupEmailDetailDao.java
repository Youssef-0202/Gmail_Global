package projet.grand.dao.emailgroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.grand.bean.emailgroup.GroupeEmailDetail;

import java.util.List;

@Repository
public interface GroupEmailDetailDao extends JpaRepository<GroupeEmailDetail,Long> {

    List<GroupeEmailDetail> findByGroupeEmailLibelle(String libelle);

}
