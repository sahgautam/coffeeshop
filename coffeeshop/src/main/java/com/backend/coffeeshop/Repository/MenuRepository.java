package com.backend.coffeeshop.Repository;

import com.backend.coffeeshop.Model.Menu;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MenuRepository extends CrudRepository<Menu,Integer> {

}
