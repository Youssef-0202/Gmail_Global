package projet.grand.service.facade;

import projet.grand.bean.emailgroup.GroupeEmail;

public interface GroupEmailService {
    int save(GroupeEmail groupeEmail);

    GroupeEmail findByLibelle(String libelle);

    int deleteByLibelle(String libelle);
}
