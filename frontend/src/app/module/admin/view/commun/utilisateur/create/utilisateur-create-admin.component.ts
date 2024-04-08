import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurCriteria} from 'src/app/shared/criteria/commun/UtilisateurCriteria.model';
@Component({
  selector: 'app-utilisateur-create-admin',
  templateUrl: './utilisateur-create-admin.component.html'
})
export class UtilisateurCreateAdminComponent extends AbstractCreateController<UtilisateurDto, UtilisateurCriteria, UtilisateurAdminService>  implements OnInit {




    constructor( private utilisateurService: UtilisateurAdminService ) {
        super(utilisateurService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}
