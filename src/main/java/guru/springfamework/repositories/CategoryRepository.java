package guru.springfamework.repositories;

import guru.springfamework.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 9/24/17.
 */
//JpaRepository extends PagingAndSortingRepository which extends CrudRepository
    //=> give you some extra functions
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
