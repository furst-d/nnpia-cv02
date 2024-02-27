package org.furstd.nnpiacv02.repository;

import org.furstd.nnpiacv02.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {}
