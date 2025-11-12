package ru.soroko.space_explorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.soroko.space_explorer.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
