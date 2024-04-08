package projet.grand.ws.converter;


import org.springframework.stereotype.Component;
import projet.grand.bean.commun.Category;
import projet.grand.bean.commun.User;
import projet.grand.ws.dto.CategoryDto;
import projet.grand.ws.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter {

    public Category toBean(CategoryDto dto){
        Category bean=new Category();
        bean.setId(dto.getId());
        bean.setName(dto.getName());


        return bean;
    }

    public CategoryDto toDto(Category bean){
        CategoryDto dto=new CategoryDto();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        return dto;
    }

    public List<Category> toBean(List<CategoryDto> dtos){
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public List<CategoryDto> toDto(List<Category> beans){
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
