package ru.sixzr.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.sixzr.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(nativeQuery = true,
            value = "with user_info as (\n" +
            "    select * from access\n" +
            "    left join \"user\" u on u.id = access.user_id\n" +
            ")\n" +
            "select user_id as id, first_name, second_name, email, password, phone, role from\n" +
            "    user_info u_i\n" +
            "    left join role r on u_i.role_id = r.id\n" +
            "where email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findByPhone(String phone);

    boolean existsByPhone(String phone);
}
