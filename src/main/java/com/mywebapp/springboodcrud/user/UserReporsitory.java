package com.mywebapp.springboodcrud.user;

import org.springframework.data.repository.CrudRepository;

public interface UserReporsitory extends CrudRepository<User, Integer> {

    public Long countById(Integer id);
}
