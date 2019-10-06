package com.ceramicduck.angryduck.service.photo_board;

import java.util.List;

import com.ceramicduck.angryduck.model.dto.AccountDTO;
import com.ceramicduck.angryduck.model.dto.PhotoBoardDTO;

public interface PhotoBoardService {
	public List<PhotoBoardDTO> listAll(int start, int end, 
			String search_option, String keyword);
	public void insert(PhotoBoardDTO dto);
	public void increaseViewcnt(int id);
	public PhotoBoardDTO getView(int id);
	public int countArticle(String search_option, String keyword);
	
	public int getId(int writer_id);
	public void insertConcertInstrument(int concert_id, String[] instrument);
	public void insertConcertTag(int concert_id, String[] tag);
	public PhotoBoardDTO getNotice(int id);
	public void insertApply(int account_id, int concert_id);
	public List<AccountDTO> getApplicants(int concert_id);
	public void deleteConcert(int concert_id);
}
