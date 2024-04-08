package  ma.zs.emailling.ws.converter.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.emailling.ws.converter.email.EmailConverter;
import ma.zs.emailling.ws.converter.commun.TypeContenuConverter;

import ma.zs.emailling.bean.core.email.Email;


import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.email.EmailpieceJoint;
import ma.zs.emailling.ws.dto.email.EmailpieceJointDto;

@Component
public class EmailpieceJointConverter extends AbstractConverter<EmailpieceJoint, EmailpieceJointDto> {

    @Autowired
    private EmailConverter emailConverter ;
    @Autowired
    private TypeContenuConverter typeContenuConverter ;
    private boolean email;
    private boolean typeContenu;

    public  EmailpieceJointConverter() {
        super(EmailpieceJoint.class, EmailpieceJointDto.class);
        init(true);
    }

    @Override
    public EmailpieceJoint toItem(EmailpieceJointDto dto) {
        if (dto == null) {
            return null;
        } else {
        EmailpieceJoint item = new EmailpieceJoint();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPath()))
                item.setPath(dto.getPath());
            if(StringUtil.isNotEmpty(dto.getTaille()))
                item.setTaille(dto.getTaille());
            if(dto.getEmail() != null && dto.getEmail().getId() != null){
                item.setEmail(new Email());
                item.getEmail().setId(dto.getEmail().getId());
                item.getEmail().setRef(dto.getEmail().getRef());
            }

            if(this.typeContenu && dto.getTypeContenu()!=null)
                item.setTypeContenu(typeContenuConverter.toItem(dto.getTypeContenu())) ;




        return item;
        }
    }

    @Override
    public EmailpieceJointDto toDto(EmailpieceJoint item) {
        if (item == null) {
            return null;
        } else {
            EmailpieceJointDto dto = new EmailpieceJointDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPath()))
                dto.setPath(item.getPath());
            if(StringUtil.isNotEmpty(item.getTaille()))
                dto.setTaille(item.getTaille());
            if(this.email && item.getEmail()!=null) {
                dto.setEmail(emailConverter.toDto(item.getEmail())) ;

            }
            if(this.typeContenu && item.getTypeContenu()!=null) {
                dto.setTypeContenu(typeContenuConverter.toDto(item.getTypeContenu())) ;

            }


        return dto;
        }
    }

    public void copy(EmailpieceJointDto dto, EmailpieceJoint t) {
    super.copy(dto, t);
    if (dto.getEmail() != null)
        emailConverter.copy(dto.getEmail(), t.getEmail());
    if (dto.getTypeContenu() != null)
        typeContenuConverter.copy(dto.getTypeContenu(), t.getTypeContenu());
    }



    public void initObject(boolean value) {
        this.email = value;
        this.typeContenu = value;
    }


    public EmailConverter getEmailConverter(){
        return this.emailConverter;
    }
    public void setEmailConverter(EmailConverter emailConverter ){
        this.emailConverter = emailConverter;
    }
    public TypeContenuConverter getTypeContenuConverter(){
        return this.typeContenuConverter;
    }
    public void setTypeContenuConverter(TypeContenuConverter typeContenuConverter ){
        this.typeContenuConverter = typeContenuConverter;
    }
    public boolean  isEmail(){
        return this.email;
    }
    public void  setEmail(boolean email){
        this.email = email;
    }
    public boolean  isTypeContenu(){
        return this.typeContenu;
    }
    public void  setTypeContenu(boolean typeContenu){
        this.typeContenu = typeContenu;
    }
}
