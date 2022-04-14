package ru.sixzr.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sixzr.models.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByRole(String role);
}
