package kr.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {
	private int idx;
	private String title;
	private String content;
	private String writer;
	private String indate;
	private int count;
	
	
}
