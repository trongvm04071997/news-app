package com.newsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsapp.entities.TaiKhoan;
import com.newsapp.service.TaiKhoanService;
import com.newsapp.serviceImp.TaiKhoanServiceImp;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	TaiKhoanService taiKhoanSer;
	
	@PostMapping("/login")
	public ResponseEntity<TaiKhoan> login(@RequestBody TaiKhoan tk){
		// Bước 2: Get ra những feild từ form gửi lên
		String email = tk.getEmail();
		String password = tk.getPassword();
		if(email.isEmpty() || password.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		// Bước 3:
		// Bước 3.1: 	get tu db
		TaiKhoan taiKhoanGetDb = taiKhoanSer.getTaiKhoan(email);
		// Bước 3.2:
		if(taiKhoanGetDb != null) {
			if(email.equals(taiKhoanGetDb.getEmail()) && password.equals(taiKhoanGetDb.getPassword())) {
				return ResponseEntity.ok(taiKhoanGetDb);
			}
		}
	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping(value = {"/register","/changpassword"})
	public ResponseEntity<TaiKhoan> register(@RequestBody TaiKhoan tk){
		// Bước 2:
		String email = tk.getEmail();
		String password = tk.getPassword();
		if(email.isEmpty() || password.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		// Bước 3: insert DB
		TaiKhoan taiKhoanInsertDb = taiKhoanSer.saveTaiKhoan(tk);
		if(taiKhoanInsertDb != null) {
			return ResponseEntity.ok(taiKhoanInsertDb);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
