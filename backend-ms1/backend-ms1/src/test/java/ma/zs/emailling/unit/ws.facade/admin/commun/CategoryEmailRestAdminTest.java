package ma.zs.emailling.unit.ws.facade.admin.commun;

import ma.zs.emailling.bean.core.commun.CategoryEmail;
import ma.zs.emailling.service.impl.admin.commun.CategoryEmailAdminServiceImpl;
import ma.zs.emailling.ws.facade.admin.commun.CategoryEmailRestAdmin;
import ma.zs.emailling.ws.converter.commun.CategoryEmailConverter;
import ma.zs.emailling.ws.dto.commun.CategoryEmailDto;
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
public class CategoryEmailRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private CategoryEmailAdminServiceImpl service;
    @Mock
    private CategoryEmailConverter converter;

    @InjectMocks
    private CategoryEmailRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCategoryEmailTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CategoryEmailDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CategoryEmailDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCategoryEmailTest() throws Exception {
        // Mock data
        CategoryEmailDto requestDto = new CategoryEmailDto();
        CategoryEmail entity = new CategoryEmail();
        CategoryEmail saved = new CategoryEmail();
        CategoryEmailDto savedDto = new CategoryEmailDto();

        // Mock the converter to return the categoryEmail object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved categoryEmail DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CategoryEmailDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CategoryEmailDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved categoryEmail DTO
        assertEquals(savedDto.getName(), responseBody.getName());
        assertEquals(savedDto.getCode(), responseBody.getCode());
    }

}