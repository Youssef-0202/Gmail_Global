package projet.grand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.grand.bean.emailgroup.GroupeEmail;
import projet.grand.dao.emailgroup.GroupEmailDao;
import projet.grand.service.facade.GroupEmailService;

@Service
public class GroupEmailServiceImpl implements GroupEmailService {
    @Autowired
    private GroupEmailDao groupEmailDao;

    @Override
    public int save(GroupeEmail groupeEmail){
        if(findByLibelle(groupeEmail.getLibelle())!=null){
            return -1;
        }
        else{
            groupEmailDao.save(groupeEmail);
            return 1;
        }
    }

    @Override
    public GroupeEmail findByLibelle(String libelle) {
        return groupEmailDao.findByLibelle(libelle);
    }
    @Override
    public int deleteByLibelle(String libelle) {
        return groupEmailDao.deleteByLibelle(libelle);
    }

}
