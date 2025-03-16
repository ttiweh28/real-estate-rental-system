package group3_real_estate_rental_system.User;

import group3_real_estate_rental_system.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName);

    Optional<User> findByUserName(String userName);
}
