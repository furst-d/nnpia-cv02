package org.furstd.nnpiacv02.service;

import org.furstd.nnpiacv02.entity.AppUser;

import java.util.Optional;

public interface IAppUserService {
    Optional<AppUser> findUser(int id);

    void createUser(AppUser appUser);

    void updateUser(AppUser appUser);

    void deleteUser(AppUser appUser);
}
