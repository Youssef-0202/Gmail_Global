package projet.grand.ws.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.grand.bean.email.Email;
import projet.grand.service.facade.EmailService;
import projet.grand.ws.converter.EmailConverter;
import projet.grand.ws.dto.EmailDto;

import java.util.List;

@RestController
@RequestMapping("api/gmail/email/")
public class EmailWs {
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailConverter emailConverter;

    @PostMapping()
    public int save(@RequestBody EmailDto emailDto) {
        Email email=emailConverter.toBean(emailDto);
        return emailService.save(email);
    }

    @GetMapping("ref/{ref}")
    public EmailDto findByRef(@PathVariable String ref) {
        Email email=emailService.findByRef(ref);
        EmailDto emailDto=emailConverter.toDto(email);
        return emailDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return emailService.deleteByRef(ref);
    }

    @GetMapping("email/{email}")
    public List<EmailDto> findByPersonneSourceEmail(@PathVariable String email) {
        List<Email> emails=emailService.findByPersonneSourceEmail(email);
        List<EmailDto> emailDtos=emailConverter.toDto(emails);
        return emailDtos;
    }

    @DeleteMapping("email/{email}")
    public int deleteByPersonneSourceEmail(@PathVariable String email) {
        return emailService.deleteByPersonneSourceEmail(email);
    }

    @GetMapping("name/{name}")
    public List<EmailDto> findByCategoryName(@PathVariable String name) {
        List<Email> emails=emailService.findByCategoryName(name);
        List<EmailDto> emailDtos=emailConverter.toDto(emails);
        return emailDtos;
    }

    @DeleteMapping("name/{name}")
    public int deleteByCategoryName(String name) {
        return emailService.deleteByCategoryName(name);
    }

}
