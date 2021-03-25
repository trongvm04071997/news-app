package com.newsapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taikhoan")
public class TaiKhoan implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

}
