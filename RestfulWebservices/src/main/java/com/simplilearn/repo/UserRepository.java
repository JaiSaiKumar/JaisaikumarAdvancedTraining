package com.simplilearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.simplilearn.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);

}
