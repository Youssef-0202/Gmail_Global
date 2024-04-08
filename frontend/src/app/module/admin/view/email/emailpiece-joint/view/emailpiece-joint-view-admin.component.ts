import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EmailpieceJointAdminService} from 'src/app/shared/service/admin/email/EmailpieceJointAdmin.service';
import {EmailpieceJointDto} from 'src/app/shared/model/email/EmailpieceJoint.model';
import {EmailpieceJointCriteria} from 'src/app/shared/criteria/email/EmailpieceJointCriteria.model';

import {EmailDto} from 'src/app/shared/model/email/Email.model';
import {EmailAdminService} from 'src/app/shared/service/admin/email/EmailAdmin.service';
import {TypeContenuDto} from 'src/app/shared/model/commun/TypeContenu.model';
import {TypeContenuAdminService} from 'src/app/shared/service/admin/commun/TypeContenuAdmin.service';
@Component({
  selector: 'app-emailpiece-joint-view-admin',
  templateUrl: './emailpiece-joint-view-admin.component.html'
})
export class EmailpieceJointViewAdminComponent extends AbstractViewController<EmailpieceJointDto, EmailpieceJointCriteria, EmailpieceJointAdminService> implements OnInit {


    constructor(private emailpieceJointService: EmailpieceJointAdminService, private emailService: EmailAdminService, private typeContenuService: TypeContenuAdminService){
        super(emailpieceJointService);
    }

    ngOnInit(): void {
    }


    get email(): EmailDto {
       return this.emailService.item;
    }
    set email(value: EmailDto) {
        this.emailService.item = value;
    }
    get emails(): Array<EmailDto> {
       return this.emailService.items;
    }
    set emails(value: Array<EmailDto>) {
        this.emailService.items = value;
    }
    get typeContenu(): TypeContenuDto {
       return this.typeContenuService.item;
    }
    set typeContenu(value: TypeContenuDto) {
        this.typeContenuService.item = value;
    }
    get typeContenus(): Array<TypeContenuDto> {
       return this.typeContenuService.items;
    }
    set typeContenus(value: Array<TypeContenuDto>) {
        this.typeContenuService.items = value;
    }


}
