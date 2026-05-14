package kr.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.mapper.BoardMapper;
import kr.spring.entity.Board;

@Controller
public class BoardController { // Controller -> POJO
	
	@Autowired // Spring 컨테이너 안에 있는 객체를 연결하는 방법 -> SqlSessionFactoryBean -> upcasting -> BoardMapper
	private BoardMapper mapper;
	
	@RequestMapping("/boardList.do") // controller/boardList.do로 요청이 들어오면 아래 메소드 실행
	public String boardList(Model model) {
		// 게시글 - 번호, 제목, 내용, 작성자, 작성일, 조회수
		// 데이터타입 - Board VO 객체에 담아서 전달
	
		List<Board> list = mapper.getList();
		// Spring에서 필요한 데이터를 전달하기위해 -> Model
		model.addAttribute("list", list);
		
		return "boardList"; // WEB-INF/views/boardList.jsp -> forward 방식으로 이동
	}
	
	@RequestMapping("/boardForm.do")
	public String boardForm() { // 게시글 작성 페이지 이동
		return "boardForm";
	}
	
	@RequestMapping("/boardInsert.do")
	public String boardInsert(Board vo) { // 게시글 등록 기능
		// title, content, writer
		// String title = request.getParameter("title");
		// String content = request.getParameter("content");
		// String writer = request.getParameter("writer");
		
		mapper.boardInsert(vo);
		
		// 게시글 전체 조회로 이동
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("/boardContent.do")
	public String boardContent(int idx, Model model) { // 게시글 상세 페이지 이동
		
		mapper.count(idx); // 게시글 조회수 올리기
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardContent";
	}
	
	@RequestMapping("/boardDelete.do")
	public String boardDelete(int idx) { // 게시글 삭제
		mapper.boardDelete(idx);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("/boardUpdateForm.do")
	public String boardUpdateForm(int idx, Model model) { // 게시글 수정
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardUpdateForm";
	}
	
	@RequestMapping("boardUpdate.do")
	public String boardUpdate(Board vo) { // 게시글 수정 등록 기능
		mapper.boardUpdate(vo);
		return "redirect:/boardList.do";
	}
}
