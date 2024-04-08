import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {KeepNoteDto} from 'src/app/shared/model/commun/KeepNote.model';
import {KeepNoteCriteria} from 'src/app/shared/criteria/commun/KeepNoteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class KeepNoteAdminService extends AbstractService<KeepNoteDto, KeepNoteCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): KeepNoteDto {
        return new KeepNoteDto();
    }

    public constrcutCriteria(): KeepNoteCriteria {
        return new KeepNoteCriteria();
    }

    get API() {
        return environment.apiUrlEmaillingservice + 'admin/keepNote/';
    }
}
