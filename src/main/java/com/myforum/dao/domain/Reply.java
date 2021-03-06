package com.myforum.dao.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.lang.*;

@Entity
@Table(name = "t_reply")
@org.hibernate.annotations.Entity
public class Reply extends BaseBean {

	@ManyToOne
	@JoinColumn(name = "thread_id")
	private Thread thread;

	private String title;

	@Basic(fetch = FetchType.LAZY)
	@Column(columnDefinition="longtext")
	private String content;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Person author;

	private int floor;

	@Column(name = "ip_created")
	private String ipCreated;

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getIpCreated() {
		return ipCreated;
	}

	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
