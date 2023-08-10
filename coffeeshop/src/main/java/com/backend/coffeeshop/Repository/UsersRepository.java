package com.backend.coffeeshop.Repository;

import com.backend.coffeeshop.Model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users,Integer> {
}
