package org.furstd.nnpiacv02.service;

import org.furstd.nnpiacv02.model.User;

import java.util.Collection;

public interface IUserService {
    Collection<User> getUsers();
    User getUser(int id);
    void createUser(User user);
}
