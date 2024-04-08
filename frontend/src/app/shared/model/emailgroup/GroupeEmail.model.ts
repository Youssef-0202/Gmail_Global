import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {GroupeEmailDetailDto} from './GroupeEmailDetail.model';
import {UtilisateurDto} from '../commun/Utilisateur.model';

export class GroupeEmailDto extends BaseDto{

    public libelle: string;

    public adminGroupe: UtilisateurDto ;
     public groupeEmailDetails: Array<GroupeEmailDetailDto>;
    

    constructor() {
        super();

        this.libelle = '';
        this.groupeEmailDetails = new Array<GroupeEmailDetailDto>();

        }

}
