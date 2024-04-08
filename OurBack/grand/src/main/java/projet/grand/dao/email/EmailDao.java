package projet.grand.dao.email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.grand.bean.email.Email;

import java.util.List;

@Repository
public interface EmailDao extends JpaRepository<Email,Long>{
    Email findByRef(String ref);
    int deleteByRef(String ref);
    List<Email> findByPersonneSourceEmail(String email);
    int deleteByPersonneSourceEmail(String email);
    List<Email> findByCategoryName(String name);
    int deleteByCategoryName(String name);

}
