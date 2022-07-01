package com.its.memberboard.repository;

import com.its.memberboard.entity.Boardentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface Boardrepository extends JpaRepository<Boardentity,Long> {
    @Modifying
    @Transactional
    @Query(value = "update board1_table set Hits = Hits+1 where id = :id ",nativeQuery = true) //조회수
    void re(@Param("id") Long id);
}
