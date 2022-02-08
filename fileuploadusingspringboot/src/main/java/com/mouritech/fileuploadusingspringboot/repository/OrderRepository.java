package com.mouritech.fileuploadusingspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.fileuploadusingspringboot.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>{

}