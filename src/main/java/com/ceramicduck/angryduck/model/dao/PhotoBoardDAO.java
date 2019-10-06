package com.ceramicduck.angryduck.model.dao;

import java.util.List;

import com.ceramicduck.angryduck.model.dto.AccountDTO;
import com.ceramicduck.angryduck.model.dto.InstrumentDTO;
import com.ceramicduck.angryduck.model.dto.PhotoBoardDTO;
import com.ceramicduck.angryduck.model.dto.TagDTO;

public interface PhotoBoardDAO {
	public List<PhotoBoardDTO> listAll(int start, int end,
			String search_option, String keyword);
	public void insert(PhotoBoardDTO dto);
	public PhotoBoardDTO getView(int id);
	public void increaseViewcnt(int id);
	public int countArticle(String search_option, String keyword);
	public int getId(int writer_id);
	public void insertConcertInstrument(int concert_id, String[] instrument);
	public void insertConcertTag(int concert_id, String[] tag);
	public List<InstrumentDTO> getConcertInstrument(int id);
	public List<TagDTO> getConcertTag(int id);
	public PhotoBoardDTO getNotice(int id);
	public List<Integer> getAllId(int writer_id);
	public void insertApply(int account_id, int concert_id);
	void deleteConcert(int concert_id);
}
