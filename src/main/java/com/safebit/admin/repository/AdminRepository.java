package com.safebit.admin.repository;

import com.safebit.admin.domain.Admin;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Override
    @EntityGraph(attributePaths = {"adminGroup", "adminGroup.authorities"})
    List<Admin> findAll();
}
