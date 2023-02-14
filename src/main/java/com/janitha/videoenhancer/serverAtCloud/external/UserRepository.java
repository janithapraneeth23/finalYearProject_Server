package com.janitha.videoenhancer.serverAtCloud.external;

import com.janitha.videoenhancer.serverAtCloud.formLogin.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    Optional<User> findUserByUsername(String username);
}
