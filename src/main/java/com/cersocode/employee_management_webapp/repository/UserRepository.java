package com.cersocode.employee_management_webapp.repository;

import com.cersocode.employee_management_webapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
