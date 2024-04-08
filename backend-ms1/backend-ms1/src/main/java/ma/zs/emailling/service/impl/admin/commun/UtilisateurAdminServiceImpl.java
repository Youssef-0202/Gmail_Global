package ma.zs.emailling.service.impl.admin.commun;


import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.dao.criteria.core.commun.UtilisateurCriteria;
import ma.zs.emailling.dao.facade.core.commun.UtilisateurDao;
import ma.zs.emailling.dao.specification.core.commun.UtilisateurSpecification;
import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import ma.zs.emailling.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import ma.zs.emailling.zynerator.security.service.facade.UserService;
import ma.zs.emailling.zynerator.security.service.facade.RoleService;
import ma.zs.emailling.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;
@Service
public class UtilisateurAdminServiceImpl extends AbstractServiceImpl<Utilisateur, UtilisateurCriteria, UtilisateurDao> implements UtilisateurAdminService {












    @Override
    public Utilisateur create(Utilisateur t) {
        if (findByUsername(t.getUsername()) != null || t.getPassword() == null) return null;
        t.setPassword(userService.cryptPassword(t.getPassword()));
        t.setEnabled(true);
        t.setAccountNonExpired(true);
        t.setAccountNonLocked(true);
        t.setCredentialsNonExpired(true);
        t.setPasswordChanged(false);
        /*if (t.getRoles() != null) {
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : t.getRoles()) {
                roles.add(roleService.save(role));
            }
            t.setRoles(roles);
        }*/
        Utilisateur mySaved = super.create(t);

        return mySaved;
     }

    public Utilisateur findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Utilisateur.class, UtilisateurSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    public UtilisateurAdminServiceImpl(UtilisateurDao dao) {
        super(dao);
    }

}
