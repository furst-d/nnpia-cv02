package org.furstd.nnpiacv02.service;

import org.furstd.nnpiacv02.entity.AppUser;
import org.furstd.nnpiacv02.repository.IAppUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements IAppUserService {
    private final IAppUserRepository appUserRepository;

    public AppUserService(IAppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public Optional<AppUser> findUser(int id) {
        return appUserRepository.findById(id);
    }

    @Override
    public void createUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public void updateUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public void deleteUser(AppUser appUser) {
        appUserRepository.deleteById(appUser.getId());
    }
}
