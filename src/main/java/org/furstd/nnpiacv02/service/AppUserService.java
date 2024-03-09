package org.furstd.nnpiacv02.service;

import lombok.RequiredArgsConstructor;
import org.furstd.nnpiacv02.dto.AppUserDTO;
import org.furstd.nnpiacv02.dto.AuthenticationResponseDTO;
import org.furstd.nnpiacv02.entity.AppUser;
import org.furstd.nnpiacv02.exceptions.NotFoundException;
import org.furstd.nnpiacv02.repository.IAppUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserService implements IAppUserService {
    private final IAppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public Optional<AppUser> findUser(int id) {
        return appUserRepository.findById(id);
    }

    @Override
    public AuthenticationResponseDTO login(AppUserDTO appUserDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(appUserDTO.getUsername(), appUserDTO.getPassword())
        );

        AppUser appUser = appUserRepository.findByUsername(appUserDTO.getUsername())
                .orElseThrow(() -> new NotFoundException("User not found"));

        return AuthenticationResponseDTO
                .builder()
                .token(jwtService.generateToken(appUser))
                .user(appUser)
                .build();
    }

    @Override
    public void createUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
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
