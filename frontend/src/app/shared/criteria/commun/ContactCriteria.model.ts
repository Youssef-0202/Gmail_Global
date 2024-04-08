import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {UtilisateurCriteria} from './UtilisateurCriteria.model';

export class ContactCriteria  extends BaseCriteria  {

    public id: number;
    public name: string;
    public nameLike: string;
    public dateAjout: Date;
    public dateAjoutFrom: Date;
    public dateAjoutTo: Date;

}
