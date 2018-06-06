package com.smart.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sun.jna.platform.win32.Netapi32Util.User;


@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="t_post")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="post_type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("1")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private int postId;
	@Column(name="post_title")
	private String postTitle;
	@Column(name="post_text")
	private String postText;
	@Column(name="board_id")
	private String boardId;
	@Column(name="create_time")
	private String createTime;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private Topic topic;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
