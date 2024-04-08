package projet.grand.ws.converter;

import org.springframework.stereotype.Component;
import projet.grand.bean.commun.User;
import projet.grand.bean.email.Email;
import projet.grand.ws.dto.EmailDto;
import projet.grand.ws.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailConverter {

    public Email toBean(EmailDto dto){
        Email bean=new Email();
        bean.setId(dto.getId());
        bean.setRef(dto.getRef());
        bean.setPersonneSource(dto.getPersonneSource());
        bean.setCategory(dto.getCategory());
        bean.setCorps(dto.getCorps());
        bean.setDateEnvoi(dto.getDateEnvoi());
        bean.setHeader(dto.getHeader());
        return bean;
    }

    public EmailDto toDto(Email bean){
        EmailDto dto=new EmailDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setPersonneSource(bean.getPersonneSource());
        dto.setCategory(bean.getCategory());
        dto.setCorps(bean.getCorps());
        dto.setDateEnvoi(bean.getDateEnvoi());
        dto.setHeader(bean.getHeader());
        return dto;
    }

    public List<Email> toBean(List<EmailDto> dtos){
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public List<EmailDto> toDto(List<Email> beans){
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
