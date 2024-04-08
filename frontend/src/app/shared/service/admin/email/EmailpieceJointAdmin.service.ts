import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {EmailpieceJointDto} from 'src/app/shared/model/email/EmailpieceJoint.model';
import {EmailpieceJointCriteria} from 'src/app/shared/criteria/email/EmailpieceJointCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EmailpieceJointAdminService extends AbstractService<EmailpieceJointDto, EmailpieceJointCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): EmailpieceJointDto {
        return new EmailpieceJointDto();
    }

    public constrcutCriteria(): EmailpieceJointCriteria {
        return new EmailpieceJointCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/emailpieceJoint/';
    }
}
