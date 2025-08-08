package com.safebit.admin.repository;

import com.safebit.admin.domain.AdminGroup;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminGroupRepository extends JpaRepository<AdminGroup, Long> {

    @Override
    @EntityGraph(attributePaths = "authorities")
    List<AdminGroup> findAll();
}
