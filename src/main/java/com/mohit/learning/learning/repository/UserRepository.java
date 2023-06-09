package com.mohit.learning.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.learning.learning.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

}
