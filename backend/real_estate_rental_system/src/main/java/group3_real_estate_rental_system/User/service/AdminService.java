package group3_real_estate_rental_system.User.service;

import group3_real_estate_rental_system.User.entity.Admin;

import java.util.List;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    List<Admin> getAllAdmins();

    Admin getAdminById(Long id);

    List<Admin> getAdminByFirstName(String firstName);

    Admin updateAdmin(Long id, Admin admin);

    void deleteAdmin(Long id);
}
 