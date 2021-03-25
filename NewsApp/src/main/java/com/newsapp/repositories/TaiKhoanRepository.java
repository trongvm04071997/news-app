package com.newsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsapp.entities.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan	, Integer> {

	TaiKhoan findByEmail(String email);

}
