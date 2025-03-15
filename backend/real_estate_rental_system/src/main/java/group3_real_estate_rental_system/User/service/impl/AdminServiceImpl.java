package group3_real_estate_rental_system.User.service.impl;

import group3_real_estate_rental_system.User.entity.Admin;
import group3_real_estate_rental_system.User.entity.PropertyOwner;
import group3_real_estate_rental_system.User.repository.AdminRepository;
import group3_real_estate_rental_system.User.service.AdminService;
import group3_real_estate_rental_system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminRepository adminRepository;


    @Override
    public Admin saveAdmin (Admin admin){
        return adminRepository.save(admin);

    }

    @Override
    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }



    @Override
    public Admin getAdminById(Long id){

        Optional<Admin> admin = adminRepository.findById(id);

        if (admin.isPresent()){
            return admin.get();
        }
        else{
            throw new ResourceNotFoundException("PropertyOwner not found");
        }
    }

    @Override
    public List<Admin> getAdminByFirstName(String firstName){
        return adminRepository.findByFirstName(firstName);
    }

    @Override
    public Admin updateAdmin(Long id, Admin adminDetails){

        Optional<Admin> adminOptional = adminRepository.findById(id);

        if (adminOptional.isPresent()){
            Admin admin = adminOptional.get();

            admin.setFirstName(adminDetails.getFirstName());
            admin.setLastName(adminDetails.getLastName());
            admin.setPassword(adminDetails.getPassword());
            admin.setUserName(adminDetails.getUserName());
            admin.setAddress(adminDetails.getAddress());


            return adminRepository.save(admin);
        }
        else{
            throw new ResourceNotFoundException("Property Owner not found with ID: " + id);

        }
    }

    @Override
    public void deleteAdmin(Long id){

        Optional<Admin> optionalAdmin = adminRepository.findById(id);

        if(optionalAdmin.isPresent()){
            adminRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("Property Owner not found with ID: " + id);
        }
    }
}
