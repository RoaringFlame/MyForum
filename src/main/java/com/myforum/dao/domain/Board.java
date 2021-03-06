package com.myforum.dao.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_board")
public class Board extends BaseBean {

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	private String name;

	private String description;

    @Column(name = "thread_count")
	private int threadCount;

    @Column(name = "reply_count")
	private int replyCount;

	@OneToOne
	@JoinColumn(name = "last_reply_id",unique = true)
	private Reply lastReply;

	@OneToOne
	@JoinColumn(name = "last_thread_id",unique = true)
	private Thread lastThread;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "t_board_administrator", joinColumns = { @JoinColumn(name = "board_id") }, inverseJoinColumns = { @JoinColumn(name = "person_id") })
	private Set<Person> administrators = new HashSet<Person>();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(Set<Person> administrators) {
		this.administrators = administrators;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public Reply getLastReply() {
		return lastReply;
	}

	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}

	public Thread getLastThread() {
		return lastThread;
	}

	public void setLastThread(Thread lastThread) {
		this.lastThread = lastThread;
	}

}
