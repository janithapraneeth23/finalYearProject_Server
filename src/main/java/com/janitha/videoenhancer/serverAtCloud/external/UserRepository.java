package com.janitha.videoenhancer.serverAtCloud.external;

import com.janitha.videoenhancer.serverAtCloud.formLogin.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findUserByUsername(String username);
}
