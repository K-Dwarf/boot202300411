package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor 
@NoArgsConstructor  //파라미터 없는 생성자
public class Dto03 {

	

	private String champ;
	private int level;

}
/*
@Data: @Getter, @Setter, @ToString, @EqualsAndHashCode을 한 번에 적용합니다.
@Getter: 해당 클래스에서 선언된 모든 필드의 getter 메소드를 생성합니다.
@Setter: 해당 클래스에서 선언된 모든 필드의 setter 메소드를 생성합니다.
@ToString: 해당 클래스에서 toString() 메소드를 생성합니다.
@EqualsAndHashCode: 해당 클래스에서 equals()와 hashCode() 메소드를 생성합니다.
@AllArgsConstructor: 해당 클래스에 모든 필드를 파라미터로 받는 생성자를 생성합니다. */