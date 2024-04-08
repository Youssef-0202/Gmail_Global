package projet.grand.service.facade;

import projet.grand.bean.commun.EtatEmail;

public interface EtatEmailService {
    int deleteByEmailRef(String ref);

    EtatEmail findByEmailRef(String ref);
}
