package com.its.memberboard.repository;

import com.its.memberboard.entity.Boardentity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Boardrepository extends JpaRepository<Boardentity,Long> {
}
