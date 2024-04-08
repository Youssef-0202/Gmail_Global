package projet.grand.dao.emailgroup;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.grand.bean.emailgroup.GroupeEmail;

@Repository
public interface GroupEmailDao extends JpaRepository<GroupeEmail,Long> {
    GroupeEmail findByLibelle(String libelle);
    int deleteByLibelle(String libelle);
}
