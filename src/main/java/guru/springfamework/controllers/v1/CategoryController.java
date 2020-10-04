package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CatorgoryListDTO;
import guru.springfamework.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CategoryController.BASE_URL)
//@Controller
//@RequestMapping("/api/v1/categories/")
public class CategoryController {

    public static final String BASE_URL = "/api/v1/categories";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //Using @Controller and use ResponseEntity to create respond body
    // ResponseEntity (extends HttpEntity):
    //Use to represent the whole HTTP response: status code (+ headers) (+ body )

    //@GetMapping
/*    @GetMapping("/api/v1/categories/")
    public ResponseEntity<CatorgoryListDTO> getallCatetories(){

        //Using ResponseEntity to represent body and status code
        return new ResponseEntity<CatorgoryListDTO>(
                new CatorgoryListDTO(categoryService.getAllCategories()), HttpStatus.OK
                //body: new CatorgoryListDTO(categoryService.getAllCategories()) => return a CatorgoryListDTO object
                //status code: HttpStatus.OK
        );
    }

    //@GetMapping("{name}")
    @GetMapping("/api/v1/categories/{name}") //{property}: assign value of the property from
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name){ //@PathVariable: extract values from the URI path

        //Using ResponseEntity to represent body and status code
        return new ResponseEntity<CategoryDTO>(
                categoryService.getCategoryByName(name), HttpStatus.OK
                //body: categoryService.getCategoryByName(name) => return a CategoryDTO object
                //status code: HttpStatus.OK
        );
    }*/

    //Using @RestController
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CatorgoryListDTO getallCatetories(){
        return new CatorgoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
}
