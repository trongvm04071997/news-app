package com.newsapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "baidang")
public class BaiDang {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tieude")
	private String tieuDe;
	
	@Column(name = "noidung")
	private String noiDung;
	
	@Column(name = "ngaydang")
	private Date ngayDang;
	
	@ManyToOne
	@JoinColumn(name = "idnguoidang", nullable = false)
	private ThongTinNguoiDang idNguoiDang;

}
