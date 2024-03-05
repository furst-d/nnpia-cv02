package org.furstd.nnpiacv02.repository;

import org.furstd.nnpiacv02.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {

    List<AppUser> findByActive(boolean active);

    AppUser findByUsername(String username);

    @Query("SELECT au FROM AppUser au JOIN au.roles r WHERE r.name = :roleName")
    List<AppUser> findByRole(@Param("roleName") String roleName);
}
