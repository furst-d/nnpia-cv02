package org.furstd.nnpiacv02.repository;

import org.furstd.nnpiacv02.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {}
