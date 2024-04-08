package ma.zs.emailling.unit.ws.facade.admin.email;

import ma.zs.emailling.bean.core.email.EmailpieceJoint;
import ma.zs.emailling.service.impl.admin.email.EmailpieceJointAdminServiceImpl;
import ma.zs.emailling.ws.facade.admin.email.EmailpieceJointRestAdmin;
import ma.zs.emailling.ws.converter.email.EmailpieceJointConverter;
import ma.zs.emailling.ws.dto.email.EmailpieceJointDto;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmailpieceJointRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private EmailpieceJointAdminServiceImpl service;
    @Mock
    private EmailpieceJointConverter converter;

    @InjectMocks
    private EmailpieceJointRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllEmailpieceJointTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<EmailpieceJointDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<EmailpieceJointDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveEmailpieceJointTest() throws Exception {
        // Mock data
        EmailpieceJointDto requestDto = new EmailpieceJointDto();
        EmailpieceJoint entity = new EmailpieceJoint();
        EmailpieceJoint saved = new EmailpieceJoint();
        EmailpieceJointDto savedDto = new EmailpieceJointDto();

        // Mock the converter to return the emailpieceJoint object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved emailpieceJoint DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<EmailpieceJointDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        EmailpieceJointDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved emailpieceJoint DTO
        assertEquals(savedDto.getPath(), responseBody.getPath());
        assertEquals(savedDto.getTaille(), responseBody.getTaille());
    }

}
