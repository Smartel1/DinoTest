package ru.smartel.dinotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smartel.dinotest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
