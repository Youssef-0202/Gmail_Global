package projet.grand.ws.converter;

import org.springframework.stereotype.Component;
import projet.grand.bean.commun.User;
import projet.grand.ws.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public User toBean(UserDto dto){
        User bean=new User();
        bean.setId(dto.getId());
        bean.setEmail(dto.getEmail());
        bean.setPassword(dto.getPassword());
        bean.setUsername(dto.getUsername());
        bean.setSignature(dto.getSignature());

        return bean;
    }

    public UserDto toDto(User bean){
        UserDto dto=new UserDto();
        dto.setId(bean.getId());
        dto.setEmail(bean.getEmail());
        dto.setPassword(bean.getPassword());
        dto.setUsername(bean.getUsername());
        dto.setSignature(bean.getSignature());
        return dto;
    }

    public List<User> toBean(List<UserDto> dtos){
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public List<UserDto> toDto(List<User> beans){
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
