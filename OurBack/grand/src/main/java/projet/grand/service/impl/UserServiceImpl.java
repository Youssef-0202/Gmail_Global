package projet.grand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.grand.bean.commun.User;
import projet.grand.dao.commun.UserDao;
import projet.grand.service.facade.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public int save(User user) {
        if (findByEmail(user.getEmail()) != null) {
            return -1;
        } else {
            userDao.save(user);
            return 1;
        }
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Transactional
    @Override
    public int deleteByEmail(String email) {
        return userDao.deleteByEmail(email);
    }

    @Override
    public List<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Autowired
    private UserDao userDao;
}
