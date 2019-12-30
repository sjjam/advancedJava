package jdbc.board.exam;

import java.util.ArrayList;

public interface BoardDAO {
	int insert(BoardDTO board);//게시글등록 - C
	int insert(String id, String title, String content);//게시글등록
	int update(String id, int boardnum);//게시글 수정 - U
	int delete(int boardnum);//게시글 삭제 - D
	ArrayList<BoardDTO> select();//전체 게시글 조회 - L
	BoardDTO read(int boardnum);//게시글 조회 - R
	ArrayList<BoardDTO> findByTitle(String title);//게시글 검색 - L
}
