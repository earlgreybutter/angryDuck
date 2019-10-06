package com.ceramicduck.angryduck.model.dto;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PhotoBoardDTO {
	private int id; //게시물 번호
	private int writer_id; //작성자 아이디
	private String title; //제목
	private String content; //내용
	private String image; //이미지
	private String region; //지역
	private String datetime; //공연날짜
	private Date timestamp; //작성 날짜
	private String name; //작성자 이름 (account테이블과 join)
	private int viewcnt; //조회수
	private MultipartFile file1; //이미지 파일
	private ArrayList<InstrumentDTO> instruments; //악기
	private ArrayList<TagDTO> tags; //태그
	
	
	public ArrayList<InstrumentDTO> getInstruments() {
		return instruments;
	}
	public void setInstruments(ArrayList<InstrumentDTO> instruments) {
		this.instruments = instruments;
	}
	public ArrayList<TagDTO> getTags() {
		return tags;
	}
	public void setTags(ArrayList<TagDTO> tags) {
		this.tags = tags;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(int writer_id) {
		this.writer_id = writer_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Photo_boardDTO [id=" + id + ", writer_id=" + writer_id + ", title=" + title + ", content=" + content
				+ ", image=" + image + ", region=" + region + ", datetime=" + datetime + ", timestamp=" + timestamp
				+ "]";
	}
}
