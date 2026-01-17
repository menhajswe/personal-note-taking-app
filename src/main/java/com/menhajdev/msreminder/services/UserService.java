package com.menhajdev.msreminder.services;

import com.menhajdev.msreminder.models.User;
import com.menhajdev.msreminder.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserbyId(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> userByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User deleteById(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return user;
                })
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public void batchDelete(List<User> users) {
        userRepository.deleteAllInBatch(users);
    }

    public void batchSaveUsers(List<User> users) {
        userRepository.saveAll(users);
    }
}
