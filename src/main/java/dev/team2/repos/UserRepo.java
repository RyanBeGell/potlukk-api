package dev.team2.repos;

import dev.team2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface UserRepo extends JpaRepository <User, String> {

    List<User> findUsersByUsername(String username);

}
