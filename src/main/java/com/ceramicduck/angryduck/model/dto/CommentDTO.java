package com.ceramicduck.angryduck.model.dto;

import java.util.Date;

public class CommentDTO {
	private int id;
	private int writer_id;
	private int community_id;
	private String content;
	private Date timestamp;
	private String name;
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
	public int getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	
	
}
