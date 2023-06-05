package com.lec.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class Board {
	
	@Id @GeneratedValue
	private Long seq;
	
	private String title;
	
	@Column(updatable = false)
	private String writer;
	
	private String content;
	
	@Column(insertable = false, updatable = false, columnDefinition = "date default now()")
	private Date createDate;	
	
	@Column(insertable = false, updatable = false, columnDefinition = "bigint default 0")
	private Long cnt;
	
	private String fileName;
	
	@Transient // 데이터를 전송하고 싶지 않을 경우 사용
	private MultipartFile uploadFile;	
	
}
