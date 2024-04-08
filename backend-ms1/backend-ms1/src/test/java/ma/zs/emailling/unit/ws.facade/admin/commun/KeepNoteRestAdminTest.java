package ma.zs.emailling.unit.ws.facade.admin.commun;

import ma.zs.emailling.bean.core.commun.KeepNote;
import ma.zs.emailling.service.impl.admin.commun.KeepNoteAdminServiceImpl;
import ma.zs.emailling.ws.facade.admin.commun.KeepNoteRestAdmin;
import ma.zs.emailling.ws.converter.commun.KeepNoteConverter;
import ma.zs.emailling.ws.dto.commun.KeepNoteDto;
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
public class KeepNoteRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private KeepNoteAdminServiceImpl service;
    @Mock
    private KeepNoteConverter converter;

    @InjectMocks
    private KeepNoteRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllKeepNoteTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<KeepNoteDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<KeepNoteDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveKeepNoteTest() throws Exception {
        // Mock data
        KeepNoteDto requestDto = new KeepNoteDto();
        KeepNote entity = new KeepNote();
        KeepNote saved = new KeepNote();
        KeepNoteDto savedDto = new KeepNoteDto();

        // Mock the converter to return the keepNote object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved keepNote DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<KeepNoteDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        KeepNoteDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved keepNote DTO
        assertEquals(savedDto.getBody(), responseBody.getBody());
        assertEquals(savedDto.getHeader(), responseBody.getHeader());
        assertEquals(savedDto.getDateKeepNote(), responseBody.getDateKeepNote());
    }

}
