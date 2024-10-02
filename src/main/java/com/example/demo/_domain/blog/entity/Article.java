package com.example.demo._domain.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 반드시 기본 생성자가 있어야 된다.
@Entity(name = "tb_article")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {

	// 특정 생성자에만 빌더 패턴을 추가할 수 있다.
	@Builder
	public Article(String title,String content) {
		this.title=title;
		this.conetent=content;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) // db로 위임
	@Column(name = "id",updatable = false) //updatable 수정
	private Long id;

	@Column(name = "title",nullable =false) // not null
	private String title;
	
	@Column(name = "content",nullable = false)
	private String conetent;
	
}
