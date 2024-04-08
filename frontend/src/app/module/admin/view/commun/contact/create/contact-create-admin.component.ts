import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ContactAdminService} from 'src/app/shared/service/admin/commun/ContactAdmin.service';
import {ContactDto} from 'src/app/shared/model/commun/Contact.model';
import {ContactCriteria} from 'src/app/shared/criteria/commun/ContactCriteria.model';
import {UtilisateurDto} from 'src/app/shared/model/commun/Utilisateur.model';
import {UtilisateurAdminService} from 'src/app/shared/service/admin/commun/UtilisateurAdmin.service';
@Component({
  selector: 'app-contact-create-admin',
  templateUrl: './contact-create-admin.component.html'
})
export class ContactCreateAdminComponent extends AbstractCreateController<ContactDto, ContactCriteria, ContactAdminService>  implements OnInit {




    constructor( private contactService: ContactAdminService , private utilisateurService: UtilisateurAdminService) {
        super(contactService);
    }

    ngOnInit(): void {
        this.personneSource = new UtilisateurDto();
        this.utilisateurService.findAll().subscribe((data) => this.personneSources = data);
        this.personneDestination = new UtilisateurDto();
        this.utilisateurService.findAll().subscribe((data) => this.personneDestinations = data);
    }





    public override setValidation(value: boolean){
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreatePersonneSource(personneSource: string) {
    const isPermistted = await this.roleService.isPermitted('Utilisateur', 'add');
    if(isPermistted) {
         this.personneSource = new UtilisateurDto();
         this.createPersonneSourceDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreatePersonneDestination(personneDestination: string) {
    const isPermistted = await this.roleService.isPermitted('Utilisateur', 'add');
    if(isPermistted) {
         this.personneDestination = new UtilisateurDto();
         this.createPersonneDestinationDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get personneSource(): UtilisateurDto {
        return this.utilisateurService.item;
    }
    set personneSource(value: UtilisateurDto) {
        this.utilisateurService.item = value;
    }
    get personneSources(): Array<UtilisateurDto> {
        return this.utilisateurService.items;
    }
    set personneSources(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
    }
    get createPersonneSourceDialog(): boolean {
       return this.utilisateurService.createDialog;
    }
    set createPersonneSourceDialog(value: boolean) {
        this.utilisateurService.createDialog= value;
    }
    get personneDestination(): UtilisateurDto {
        return this.utilisateurService.item;
    }
    set personneDestination(value: UtilisateurDto) {
        this.utilisateurService.item = value;
    }
    get personneDestinations(): Array<UtilisateurDto> {
        return this.utilisateurService.items;
    }
    set personneDestinations(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
    }
    get createPersonneDestinationDialog(): boolean {
       return this.utilisateurService.createDialog;
    }
    set createPersonneDestinationDialog(value: boolean) {
        this.utilisateurService.createDialog= value;
    }






}
