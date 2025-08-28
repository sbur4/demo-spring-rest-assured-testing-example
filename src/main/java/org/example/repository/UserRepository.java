package org.example.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Getter
@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final List<User> userStorage;
}
