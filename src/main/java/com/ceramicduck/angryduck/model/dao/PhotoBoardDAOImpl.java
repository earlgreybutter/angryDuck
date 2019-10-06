package com.ceramicduck.angryduck.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ceramicduck.angryduck.model.dto.AccountDTO;
import com.ceramicduck.angryduck.model.dto.InstrumentDTO;
import com.ceramicduck.angryduck.model.dto.PhotoBoardDTO;
import com.ceramicduck.angryduck.model.dto.TagDTO;

@Repository
public class PhotoBoardDAOImpl implements PhotoBoardDAO {

final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public int countArticle(String search_option, String keyword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search_option",search_option);
		map.put("keyword",keyword);
		return sqlSession.selectOne("photoBoard.countArticle", map);
	}
	@Override
	public List<PhotoBoardDTO> listAll(int start, int end, 
			String search_option, String keyword){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search_option",search_option);
		map.put("keyword",keyword);
		map.put("start",start);
		map.put("end",end);
		return sqlSession.selectList("photoBoard.listAll",map);
	}
	
	@Override
	public void insert(PhotoBoardDTO dto) {
		sqlSession.insert("photoBoard.insert", dto);
		
	}
	
	@Override
	public PhotoBoardDTO getView(int id) {
		return sqlSession.selectOne("photoBoard.getView",id);
		
	}
	@Override
	public int getId(int writer_id) {
		return sqlSession.selectOne("photoBoard.getId",writer_id);
	}
	@Override
	public void insertConcertInstrument(int concert_id, String[] instrument) {
		for(int i=0; i<instrument.length; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("concert_id",concert_id);
			String inst = instrument[i];
			int instrument_id = sqlSession.selectOne("photoBoard.instrument",inst);
			map.put("instrument_id",instrument_id);
			sqlSession.insert("photoBoard.insert_concert_instrument",map);
		}
	}
	@Override
	public void insertConcertTag(int concert_id, String[] tag) {
		for(int i=0; i<tag.length; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("concert_id",concert_id);
			String t = tag[i];
			int tag_id = sqlSession.selectOne("photoBoard.tag",t);
			map.put("tag_id",tag_id);
			sqlSession.insert("photoBoard.insert_concert_tag",map);
		}
	}
	@Override
	public void increaseViewcnt(int id) {
		sqlSession.update("photoBoard.increaseViewcnt",id);
	}
	@Override
	public List<InstrumentDTO> getConcertInstrument(int id) {
		List<InstrumentDTO> list = new ArrayList<InstrumentDTO>();
		
		list = sqlSession.selectList("photoBoard.get_concert_instrument", id);
		return list;
	}
	@Override
	public List<TagDTO> getConcertTag(int id) {
		List<TagDTO> list = new ArrayList<TagDTO>();
		list = sqlSession.selectList("photoBoard.get_concert_tag", id);
		return list;
	}
	@Override
	public PhotoBoardDTO getNotice(int id) {
		return sqlSession.selectOne("photoBoard.getNotice",id);
	}
	@Override
	public List<Integer> getAllId(int writer_id) {
		return sqlSession.selectList("photoBoard.getAllId",writer_id);
	}
	@Override
	public void insertApply(int account_id, int concert_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("account_id",account_id);
		map.put("concert_id",concert_id);
		sqlSession.insert("photoBoard.insertApply",map);
	}
	@Override
	public void deleteConcert(int concert_id) {
		sqlSession.delete("photoBoard.delete_concert_performer",concert_id);
		sqlSession.delete("photoBoard.delete_concert_instrument",concert_id);
		sqlSession.delete("photoBoard.delete_concert_tag",concert_id);
		sqlSession.delete("photoBoard.delete_concert",concert_id);
	}
	
}
