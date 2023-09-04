package com.example.locationManagementService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseWeatherRepository<T> extends JpaRepository<T, Long> {
}
