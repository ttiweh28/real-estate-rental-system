package group3_real_estate_rental_system.User.service;

import group3_real_estate_rental_system.User.entity.Admin;
import group3_real_estate_rental_system.User.entity.PropertyOwner;

import java.util.List;

public interface AdminService {

    public Admin saveAdmin (Admin admin);

    public List<Admin> getAllAdmins();

    public Admin getAdminById(Long id);

    public List<Admin> getAdminByFirstName(String firstName);

    public Admin updateAdmin(Long id, Admin admin);

    public void deleteAdmin(Long id);
}
 