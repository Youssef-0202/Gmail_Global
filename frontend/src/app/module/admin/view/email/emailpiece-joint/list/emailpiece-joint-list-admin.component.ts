import {Component, OnInit} from '@angular/core';
import {EmailpieceJointAdminService} from 'src/app/shared/service/admin/email/EmailpieceJointAdmin.service';
import {EmailpieceJointDto} from 'src/app/shared/model/email/EmailpieceJoint.model';
import {EmailpieceJointCriteria} from 'src/app/shared/criteria/email/EmailpieceJointCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';


@Component({
  selector: 'app-emailpiece-joint-list-admin',
  templateUrl: './emailpiece-joint-list-admin.component.html'
})
export class EmailpieceJointListAdminComponent extends AbstractListController<EmailpieceJointDto, EmailpieceJointCriteria, EmailpieceJointAdminService>  implements OnInit {

    override fileName = 'EmailpieceJoint';


    emails: Array<EmailDto>;
    typeContenus: Array<TypeContenuDto>;


    constructor( private emailpieceJointService: EmailpieceJointAdminService  , private emailService: EmailAdminService, private typeContenuService: TypeContenuAdminService) {
        super(emailpieceJointService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('EmailpieceJoint').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadEmail();
                this.loadTypeContenu();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'email?.ref', header: 'Email'},
            {field: 'path', header: 'Path'},
            {field: 'taille', header: 'Taille'},
            {field: 'typeContenu?.libelle', header: 'Type contenu'},
        ];
    }


    public async loadEmail(){
       this.emailService.findAllOptimized().subscribe(emails => this.emails = emails, error => console.log(error))
    }
    public async loadTypeContenu(){
       this.typeContenuService.findAllOptimized().subscribe(typeContenus => this.typeContenus = typeContenus, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Email': e.email?.ref ,
                 'Path': e.path ,
                 'Taille': e.taille ,
                'Type contenu': e.typeContenu?.libelle ,
            }
        });

        this.criteriaData = [{
        //'Email': this.criteria.email?.ref ? this.criteria.email?.ref : environment.emptyForExport ,
            'Path': this.criteria.path ? this.criteria.path : environment.emptyForExport ,
            'Taille': this.criteria.taille ? this.criteria.taille : environment.emptyForExport ,
        //'Type contenu': this.criteria.typeContenu?.libelle ? this.criteria.typeContenu?.libelle : environment.emptyForExport ,
        }];
      }
}
