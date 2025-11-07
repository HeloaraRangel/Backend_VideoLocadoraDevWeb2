package com.example.videoLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.videoLocadora.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Long>{

}
