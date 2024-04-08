package ma.zs.emailling.dao.facade.core.commun;

import ma.zs.emailling.zynerator.repository.AbstractRepository;
import ma.zs.emailling.bean.core.commun.Utilisateur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UtilisateurDao extends AbstractRepository<Utilisateur,Long>  {

    Utilisateur findByUsername(String username);


}
