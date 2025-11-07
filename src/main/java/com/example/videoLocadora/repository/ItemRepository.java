package com.example.videoLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.videoLocadora.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity,Long>{

}
