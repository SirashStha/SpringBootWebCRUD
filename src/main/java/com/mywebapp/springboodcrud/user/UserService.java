package com.mywebapp.springboodcrud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserReporsitory userReporsitory;

    public List<User> listAll() {
        return (List<User>) userReporsitory.findAll();
    }

    public void save(User user) {
        userReporsitory.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = userReporsitory.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find user with ID: "+id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = userReporsitory.countById(id);
        if (count == null || count ==0) {
            throw new UserNotFoundException("Could not find user with ID: "+id);
        }
        userReporsitory.deleteById(id);
    }
}
