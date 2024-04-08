import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class UtilisateurCriteria  extends BaseCriteria  {

    public signature: string;
    public signatureLike: string;
    public credentialsNonExpired: null | boolean;
    public enabled: null | boolean;
    public accountNonExpired: null | boolean;
    public accountNonLocked: null | boolean;
    public passwordChanged: null | boolean;
    public username: string;
    public usernameLike: string;
    public password: string;
    public passwordLike: string;

}
