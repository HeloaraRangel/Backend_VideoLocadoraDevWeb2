package com.example.videoLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.videoLocadora.entity.ClasseEntity;

public interface ClasseRepository extends JpaRepository<ClasseEntity,Long> {
	
}
