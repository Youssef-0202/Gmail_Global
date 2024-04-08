package projet.grand.dao.commun;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.grand.bean.commun.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByEmail(String email);
    int deleteByEmail(String email);

    List<User> findByUsername(String username);


}
