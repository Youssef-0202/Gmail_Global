package ma.zs.emailling.unit.ws.facade.admin.email;

import ma.zs.emailling.bean.core.email.EmailDetail;
import ma.zs.emailling.service.impl.admin.email.EmailDetailAdminServiceImpl;
import ma.zs.emailling.ws.facade.admin.email.EmailDetailRestAdmin;
import ma.zs.emailling.ws.converter.email.EmailDetailConverter;
import ma.zs.emailling.ws.dto.email.EmailDetailDto;
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
public class EmailDetailRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private EmailDetailAdminServiceImpl service;
    @Mock
    private EmailDetailConverter converter;

    @InjectMocks
    private EmailDetailRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllEmailDetailTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<EmailDetailDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<EmailDetailDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveEmailDetailTest() throws Exception {
        // Mock data
        EmailDetailDto requestDto = new EmailDetailDto();
        EmailDetail entity = new EmailDetail();
        EmailDetail saved = new EmailDetail();
        EmailDetailDto savedDto = new EmailDetailDto();

        // Mock the converter to return the emailDetail object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved emailDetail DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<EmailDetailDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        EmailDetailDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved emailDetail DTO
        assertEquals(savedDto.getDateLecture(), responseBody.getDateLecture());
        assertEquals(savedDto.getDateReception(), responseBody.getDateReception());
    }

}
