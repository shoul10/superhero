package com.spring.swagger.superhero.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.swagger.superhero.model.Mission;

@Repository
@Transactional
public interface MissionRepository extends JpaRepository<Mission, Long> {

}
