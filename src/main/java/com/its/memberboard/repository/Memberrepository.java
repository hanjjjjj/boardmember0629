package com.its.memberboard.repository;

import com.its.memberboard.entity.Boardentity;
import com.its.memberboard.entity.Memberentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Memberrepository extends JpaRepository<Memberentity,Long> {
    Optional<Memberentity> findByMemail(String memail);
}
