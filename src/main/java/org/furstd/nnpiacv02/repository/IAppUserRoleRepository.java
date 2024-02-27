package org.furstd.nnpiacv02.repository;

import org.furstd.nnpiacv02.entity.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRoleRepository extends JpaRepository<AppUserRole, Integer> {}
