package com.ceramicduck.angryduck.service.photo_board;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ceramicduck.angryduck.model.dao.AccountDAO;
import com.ceramicduck.angryduck.model.dao.AccountDAOImpl;
import com.ceramicduck.angryduck.model.dao.PhotoBoardDAO;
import com.ceramicduck.angryduck.model.dto.AccountDTO;
import com.ceramicduck.angryduck.model.dto.InstrumentDTO;
import com.ceramicduck.angryduck.model.dto.PhotoBoardDTO;
import com.ceramicduck.angryduck.model.dto.TagDTO;

@Service
public class PhotoBoardServiceImpl implements PhotoBoardService {
	@Inject
	PhotoBoardDAO photoBoardDao;
	
	@Inject
	AccountDAO accountDao;
	
	final Logger logger = LoggerFactory.getLogger(PhotoBoardServiceImpl.class);
	
	@Override
	public List<PhotoBoardDTO> listAll(int start, int end, 
			String search_option, String keyword){
		return photoBoardDao.listAll(start, end, search_option, keyword);
	}
	@Override
	public void insert(PhotoBoardDTO dto) {
		photoBoardDao.insert(dto);
	}
	
	@Override
	public PhotoBoardDTO getView(int id) {
		PhotoBoardDTO dto = photoBoardDao.getView(id);
		dto.setInstruments((ArrayList<InstrumentDTO>) photoBoardDao.getConcertInstrument(id));
		dto.setTags((ArrayList<TagDTO>) photoBoardDao.getConcertTag(id));
		return dto;
	}
	@Override
	public int countArticle(String search_option, String keyword) {
		return photoBoardDao.countArticle(search_option,keyword);
	}
	@Override
	public int getId(int writer_id) {
		return photoBoardDao.getId(writer_id);
	}
	@Override
	public void insertConcertInstrument(int concert_id, String[] instrument) {
		photoBoardDao.insertConcertInstrument(concert_id, instrument);
		
	}
	@Override
	public void insertConcertTag(int concert_id, String[] tag) {
		photoBoardDao.insertConcertTag(concert_id, tag);
	}
	@Override
	public void increaseViewcnt(int id) {
		photoBoardDao.increaseViewcnt(id);
	}
	@Override
	public PhotoBoardDTO getNotice(int id) {
		return photoBoardDao.getNotice(id);
	}
	@Override
	public void insertApply(int account_id, int concert_id) {
		photoBoardDao.insertApply(account_id,concert_id);
	}
	@Override
	public List<AccountDTO> getApplicants(int concert_id) {
		List<AccountDTO> applicants = accountDao.getApplicants(concert_id);
		for(int i=0; i<applicants.size(); i++) {
			AccountDTO dto = applicants.get(i);
			int accountId = dto.getId();
			dto.setInstruments((ArrayList<InstrumentDTO>) accountDao.getAccountInstrument(accountId));
			dto.setTags((ArrayList<TagDTO>) accountDao.getAccountTag(accountId));
		}
		return applicants;
	}
	@Override
	public void deleteConcert(int concert_id) {
		photoBoardDao.deleteConcert(concert_id);
	}
	
}
