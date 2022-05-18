package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Admin;
import com.simplilearn.repo.AdminRepository;


@Service
public class AdminService {


    @Autowired
    private AdminRepository adminRepository;

    public Admin getAdminbyusername(String username) {
        return adminRepository.findByUsername(username);
    }


    public List<Admin> getallAdmin() {
        return adminRepository.findAll();
    }

}
