package com.example.RegisterNdLogin.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RegisterNdLogin.models.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	//role se related DB operations honge
	//DB mei cheeze save hongi
}