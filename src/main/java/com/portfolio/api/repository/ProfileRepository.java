package com.portfolio.api.repository;

import com.portfolio.api.entity.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{
}
