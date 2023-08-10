package com.backend.coffeeshop.Repository;

import com.backend.coffeeshop.Model.Images;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository  extends CrudRepository<Images,Integer> {

}
