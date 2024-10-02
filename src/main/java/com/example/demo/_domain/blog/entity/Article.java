package com.example.demo._domain.blog.entity;

import com.example.demo.common.errors.Exception400;

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
	
	
	public void update(String title,String content) {
		// 유효성 검사 반드시 진행 해야 함
		// 즉, 데이터가  엔터디에 저장되기 전에 반드시 검증
		if(title== null || title.isEmpty()) {
			throw new Exception400("제목은 null 이거나 빈 문자열일수 없습니다.");
		}
		if(content== null || content.isEmpty()) {
			throw new Exception400("제목은 null 이거나 빈 문자열일수 없습니다.");
		}
		this.title=title;
		this.conetent=content;
	}
	
}
