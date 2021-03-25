package com.newsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsapp.entities.TaiKhoan;
import com.newsapp.service.TaiKhoanService;


@RestController
@RequestMapping("/dangnhap")
public class DangNhapController {
	@Autowired
	TaiKhoanService taiKhoanSer;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/all")
	public ResponseEntity<List<TaiKhoan>> getAllTaiKhoan( ){
		List<TaiKhoan> list = taiKhoanSer.getAllTaiKhoan();
		if(list.size()==0) {
			return (ResponseEntity<List<TaiKhoan>>) ResponseEntity.notFound();
		}
		return ResponseEntity.ok(list);
	}
	@GetMapping("/taikhoan")
	public ResponseEntity<?> getTaiKhoan(@RequestBody  TaiKhoan tk) {
		TaiKhoan a = taiKhoanSer.getTaiKhoan(tk.getEmail());
		if(a == null) {
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}
		return ResponseEntity.ok("OK");
	}

}
