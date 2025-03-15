package group3_real_estate_rental_system.User.repository;

import group3_real_estate_rental_system.User.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findByFirstName(String firstName);

}
