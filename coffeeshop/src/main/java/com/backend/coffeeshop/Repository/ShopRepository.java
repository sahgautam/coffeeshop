package com.backend.coffeeshop.Repository;

import com.backend.coffeeshop.Model.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop,Integer> {
}
