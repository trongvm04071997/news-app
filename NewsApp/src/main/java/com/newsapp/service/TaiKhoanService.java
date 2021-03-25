package com.newsapp.service;

import java.util.List;


import com.newsapp.entities.TaiKhoan;

public interface TaiKhoanService {
	List<TaiKhoan> getAllTaiKhoan();

	TaiKhoan getTaiKhoan(String email);
	
	TaiKhoan saveTaiKhoan(TaiKhoan tk);

}
