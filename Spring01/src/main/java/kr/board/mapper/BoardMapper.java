package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.spring.entity.Board;

@Mapper
public interface BoardMapper {
	// 우리가 필요한 JDBC 메소도를 작성하는 곳 select, delete, update ...
	
	// 게시글 전체 조회
	public List<Board> getList(); // 추상메소드 구현 -> MyBatis (JDBC)

	// 게시글 입력
	public void boardInsert(Board vo);
	
	// 게시글 상세
	public Board boardContent(int idx);

	// 게시글 삭제
	public void boardDelete(int idx);

	// 게시글 조회수
	public void count(int idx);

	// 게시글 수정
	public void boardUpdate(Board vo);

	
}

