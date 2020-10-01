package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    //Use of @Mapping
    //@Mapping(source = “property”, target=”property_DTO”)
    //ClassDTO classToClassDTO (Class class)

    //@Mapping(source = "id", target = "id") //not necessary because the properties name is the same in both classes
    CategoryDTO categoryToCategoryDTO(Category category);
}
