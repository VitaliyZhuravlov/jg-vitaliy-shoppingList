package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.UserEntity;
import com.javaguru.shoppinglist.repository.UserRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.UserNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserEntity create(UserEntity entity) {
        return repository.save(entity);
    }

    public UserEntity findUserById(Long id)  {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("User not found, id: " + id));
    }

    public UserEntity update(UserEntity entity) {
        UserEntity existingUser = repository.findById(entity.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        existingUser.setUsername(entity.getUsername());
        return repository.save(existingUser);
    }

    public String delete(Long id){
        repository.deleteById(id);
        return "Successfully deleted" + id;
    }

    public UserEntity findUserByName(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
