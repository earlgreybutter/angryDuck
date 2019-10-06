package com.ceramicduck.angryduck.service.board;

import java.util.List;

import com.ceramicduck.angryduck.model.dto.BoardDTO;
import com.ceramicduck.angryduck.model.dto.CommentDTO;

public interface BoardService {
	public List<BoardDTO> listAll(int start, int end, 
			String search_option, String keyword);
	public void insert(BoardDTO dto);
	public BoardDTO getView(int id);
	public int countArticle(String search_option, String keyword);
	public void increaseViewcnt(int id);
	public void insertComment(CommentDTO dto);
	public List<CommentDTO> getComments(int community_id);
	public BoardDTO getNotice(int id);
	public void deleteCommunity(int id);
}
