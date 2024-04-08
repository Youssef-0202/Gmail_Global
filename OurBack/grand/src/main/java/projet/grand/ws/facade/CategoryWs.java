package projet.grand.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.grand.bean.commun.Category;
import projet.grand.service.facade.CategoryService;
import projet.grand.ws.converter.CategoryConverter;
import projet.grand.ws.dto.CategoryDto;

@RestController
@RequestMapping("api/gmail/category/")
public class CategoryWs {

    @GetMapping("name/{name}")
    public Category findByName(@PathVariable String name) {
        return categoryService.findByName(name);
    }

    @PostMapping

    public int save(@RequestBody CategoryDto categoryDto) {
        Category category=categoryConverter.toBean(categoryDto);
        return categoryService.save(category);
    }
    @DeleteMapping("name/{name}")
    public int deleteByName(@PathVariable String name) {
        return categoryService.deleteByName(name);
    }

    @Autowired
    private CategoryService categoryService;
    @Autowired

    private CategoryConverter categoryConverter;
}
