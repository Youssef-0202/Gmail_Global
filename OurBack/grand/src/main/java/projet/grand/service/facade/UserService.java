package projet.grand.service.facade;

import projet.grand.bean.commun.User;

import java.util.List;

public interface UserService {
    int save(User user);

    User findByEmail(String email);

    int deleteByEmail(String email);

    List<User> findByUsername(String username);
}
