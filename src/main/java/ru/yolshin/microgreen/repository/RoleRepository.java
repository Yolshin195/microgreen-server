package ru.yolshin.microgreen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yolshin.microgreen.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
