package com.newsapp.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsapp.entities.TaiKhoan;
import com.newsapp.repositories.TaiKhoanRepository;
import com.newsapp.service.TaiKhoanService;

@Service
public class TaiKhoanServiceImp implements TaiKhoanService {
	
	@Autowired
	TaiKhoanRepository taiKhoanRepo;

	@Override
	public List<TaiKhoan> getAllTaiKhoan() {
		return taiKhoanRepo.findAll();
	}

	@Override
	public TaiKhoan getTaiKhoan(String email) {
		return taiKhoanRepo.findByEmail(email);
	}

	@Override
	public TaiKhoan saveTaiKhoan(TaiKhoan tk) {
		return taiKhoanRepo.save(tk);
	}

}
