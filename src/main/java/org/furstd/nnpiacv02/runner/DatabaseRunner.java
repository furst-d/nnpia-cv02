package org.furstd.nnpiacv02.runner;

import org.furstd.nnpiacv02.entity.AppUser;
import org.furstd.nnpiacv02.entity.Role;
import org.furstd.nnpiacv02.repository.IAppUserRepository;
import org.furstd.nnpiacv02.repository.IRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DatabaseRunner implements CommandLineRunner {

    private final IAppUserRepository appUserRepository;
    private final IRoleRepository roleRepository;

    public DatabaseRunner(IAppUserRepository appUserRepository, IRoleRepository roleRepository) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        AppUser user1 = new AppUser(1, "user1", "password1", true, new Date(), null);
        AppUser user2 = new AppUser(2, "user2", "password2", false, new Date(), null);
        AppUser user3 = new AppUser(3, "user3", "password3", true, new Date(), null);

        Role adminRole = new Role(1, "admin");
        Role userRole = new Role(2, "user");
        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        user1.addRole(userRole);
        user1.addRole(adminRole);
        user2.addRole(userRole);
        user3.addRole(userRole);

        appUserRepository.save(user1);
        appUserRepository.save(user2);
        appUserRepository.save(user3);

        System.out.println("Active users:");
        List<AppUser> activeUsers = appUserRepository.findByActive(true);
        for (AppUser user : activeUsers) {
            System.out.println(user.getUsername());
        }

        System.out.println("\nUser role:");
        List<AppUser> userRoleUsers = appUserRepository.findByRole("user");
        for (AppUser user : userRoleUsers) {
            System.out.println(user.getUsername());
        }

    }
}
