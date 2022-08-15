package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void removeUserById(long id);

    List<User> findAll();

    User findById(long id);

    void update(User user);
}
