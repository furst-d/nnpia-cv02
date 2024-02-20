package org.furstd.nnpiacv02.service;

import org.furstd.nnpiacv02.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService {
    private final Map<Integer, User> users = new HashMap<>();

    @Override
    public Collection<User> getUsers() {
        return users.values();
    }

    @Override
    public User getUser(int id) {
        return users.get(id);
    }

    @Override
    public void createUser(User user) {
        users.put(user.getId(), user);
    }
}
