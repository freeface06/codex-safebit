package com.goobit.safebit.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.goobit.safebit.admin.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
