package org.example.java1406_Mock.taskiMick;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
}

interface UserRepository {
    void save(User user);

    User findById(int id);
}

class UserRepositoryImpl implements UserRepository {
    List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User findById(int id) {
        return users.get(id);
    }
}

class UserService{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void placeUser(User user){
        userRepository.save(user);
    }

    public User getUser(int id){
        return userRepository.findById(id);
    }
}