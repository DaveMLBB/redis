package co.develhope.redis.repositories;

import co.develhope.redis.entities.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserJPA, Long> {
}
