package com.mobile.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
