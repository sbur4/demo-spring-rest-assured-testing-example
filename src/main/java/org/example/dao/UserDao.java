package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.exception.UserNotFoundException;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.getUserStorage();
    }

    public User findById(long id) {
        return userRepository.getUserStorage().stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
    }

    public User findByEmail(String email) {
        return userRepository.getUserStorage().stream()
                .filter(u -> u.getEmail() == email)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found."));
    }

    public User save(User user) {
        User existedUser = userRepository.getUserStorage().stream()
                .filter(u -> u.getEmail().equals(user.getEmail()))
                .findFirst()
                .orElse(null);
        if (Objects.isNull(existedUser)) {
            userRepository.getUserStorage().add(user);
        }

        return user;
    }

    public void updateByEmail(User updatedUser) {
        User existedUser = userRepository.getUserStorage().stream()
                .filter(u -> u.getEmail().equals(updatedUser.getEmail()))
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(existedUser)) {
            updatedUser.setId(existedUser.getId());
            userRepository.getUserStorage().set((int) updatedUser.getId(), updatedUser);
        }
    }

    public void deleteByEmail(String email) {
        userRepository.getUserStorage()
                .removeIf(u -> Objects.equals(u.getEmail(), email));
    }
}
