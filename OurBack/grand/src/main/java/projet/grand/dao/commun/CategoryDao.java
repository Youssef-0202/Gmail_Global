package projet.grand.dao.commun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.grand.bean.commun.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {
    Category findByName(String name);
    int deleteByName(String name);

}
