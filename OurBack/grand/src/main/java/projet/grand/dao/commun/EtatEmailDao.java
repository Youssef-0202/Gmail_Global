package projet.grand.dao.commun;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.grand.bean.commun.EtatEmail;
import projet.grand.bean.email.Email;

@Repository
public interface EtatEmailDao extends JpaRepository<EtatEmail,Long> {
   EtatEmail findByEmailRef(String ref);
   int deleteByEmailRef(String ref);

}
