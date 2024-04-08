package projet.grand.dao.commun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.grand.bean.commun.TypeContenu;

@Repository
public interface TypeContenuDao extends JpaRepository<TypeContenu,Long> {

    TypeContenu findByLibelle(String libelle);
    int deleteByLibelle(String libelle);

}
