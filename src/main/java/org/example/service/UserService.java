package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<User> getAll() {
        return userDao.findAll();
    }

    public User getById(long id) {
        return userDao.findById(id);
    }

    public User getByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User create(User user) {
        return userDao.save(user);
    }

    public void updateByEmail(String email, String password) {
        userDao.updateByEmail(new User(0, email, password));
    }

    public void remove(String email) {
        userDao.deleteByEmail(email);
    }
}
