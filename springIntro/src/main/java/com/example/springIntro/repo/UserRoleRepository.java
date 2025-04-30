package com.example.springIntro.repo;

import com.example.springIntro.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    // চাইলে এখানে custom query method ও বানাতে পারো
}
