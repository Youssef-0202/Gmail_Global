package  ma.zs.emailling.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.ws.dto.commun.UtilisateurDto;

@Component
public class UtilisateurConverter extends AbstractConverter<Utilisateur, UtilisateurDto> {


    public  UtilisateurConverter() {
        super(Utilisateur.class, UtilisateurDto.class);
    }

    @Override
    public Utilisateur toItem(UtilisateurDto dto) {
        if (dto == null) {
            return null;
        } else {
        Utilisateur item = new Utilisateur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getSignature()))
                item.setSignature(dto.getSignature());
            item.setCredentialsNonExpired(dto.getCredentialsNonExpired());
            item.setEnabled(dto.getEnabled());
            item.setAccountNonExpired(dto.getAccountNonExpired());
            item.setAccountNonLocked(dto.getAccountNonLocked());
            item.setPasswordChanged(dto.getPasswordChanged());
            if(StringUtil.isNotEmpty(dto.getUsername()))
                item.setUsername(dto.getUsername());
            if(StringUtil.isNotEmpty(dto.getPassword()))
                item.setPassword(dto.getPassword());


            //item.setRoles(dto.getRoles());

        return item;
        }
    }

    @Override
    public UtilisateurDto toDto(Utilisateur item) {
        if (item == null) {
            return null;
        } else {
            UtilisateurDto dto = new UtilisateurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getSignature()))
                dto.setSignature(item.getSignature());
            if(StringUtil.isNotEmpty(item.getCredentialsNonExpired()))
                dto.setCredentialsNonExpired(item.getCredentialsNonExpired());
            if(StringUtil.isNotEmpty(item.getEnabled()))
                dto.setEnabled(item.getEnabled());
            if(StringUtil.isNotEmpty(item.getAccountNonExpired()))
                dto.setAccountNonExpired(item.getAccountNonExpired());
            if(StringUtil.isNotEmpty(item.getAccountNonLocked()))
                dto.setAccountNonLocked(item.getAccountNonLocked());
            if(StringUtil.isNotEmpty(item.getPasswordChanged()))
                dto.setPasswordChanged(item.getPasswordChanged());
            if(StringUtil.isNotEmpty(item.getUsername()))
                dto.setUsername(item.getUsername());
            if(StringUtil.isNotEmpty(item.getPassword()))
                dto.setPassword(item.getPassword());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
