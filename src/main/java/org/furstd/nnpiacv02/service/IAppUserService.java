package org.furstd.nnpiacv02.service;

import org.furstd.nnpiacv02.dto.AppUserDTO;
import org.furstd.nnpiacv02.dto.AuthenticationResponseDTO;
import org.furstd.nnpiacv02.entity.AppUser;

import java.util.Optional;

public interface IAppUserService {
    Optional<AppUser> findUser(int id);

    AuthenticationResponseDTO login(AppUserDTO appUserDTO);

    void createUser(AppUser appUser);

    void updateUser(AppUser appUser);

    void deleteUser(AppUser appUser);
}
