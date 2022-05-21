package com.example.learningcenter.repository;

import com.example.learningcenter.entity.Payment;
import com.example.learningcenter.entity.Room;
import com.example.learningcenter.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>, BaseRepository {

}
