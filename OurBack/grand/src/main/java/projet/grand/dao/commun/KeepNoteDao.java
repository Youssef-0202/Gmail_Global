package projet.grand.dao.commun;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.grand.bean.commun.KeepNote;

import java.util.List;

@Repository
public interface KeepNoteDao extends JpaRepository<KeepNote,Long> {
    //a verifier
    List<KeepNote> findByHeaderOrBody(String header,String body);
    List<KeepNote> findByEmailRef(String ref);
    int deleteByEmailRef(String ref);
    List<KeepNote> findByPersonneEmail(String email);
    int deleteByPersonneEmail(String email);

}
