package com.example.demo.interfaces;

import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface UsersInterface extends JpaRepository<Users, Long> {

     void deleteAll();
}
