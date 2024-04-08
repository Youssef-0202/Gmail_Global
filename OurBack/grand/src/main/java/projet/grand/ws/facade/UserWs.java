package projet.grand.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.grand.bean.commun.User;
import projet.grand.service.facade.UserService;
import projet.grand.ws.converter.UserConverter;
import projet.grand.ws.dto.UserDto;

import java.util.List;

@RestController
@RequestMapping("api/gmail/user/")
public class UserWs {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @PostMapping
    public int save(@RequestBody UserDto userDto) {
        User user=userConverter.toBean(userDto);
        return userService.save(user);
    }

    @GetMapping("email/{email}")
    public UserDto findByEmail(@PathVariable String email) {
        User user=userService.findByEmail(email);
        UserDto userDto=userConverter.toDto(user);
        return userDto;
    }

    @DeleteMapping("email/{email}")
    public int deleteByEmail(@PathVariable String email) {
        return userService.deleteByEmail(email);
    }

    @GetMapping("username/{username}")
    public List<UserDto> findByUsername(@PathVariable String username) {
        List<User> beans=userService.findByUsername(username);
        List<UserDto> dtos=userConverter.toDto(beans);
        return dtos;
    }

}
