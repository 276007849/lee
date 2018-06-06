package com.smart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;

@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="t_user")
public class Topic {
	/*
	 * 锁定用户对应的状态值
	 */
	private static final int USER_LOCK = 1;
	/*
	 *用户锁定对应的状态值 
	 */
	private static final int  USER_UNLOCK = 0;
	/*
	 * 管理员类型
	 */
	private static final int FORUM_ADMIN = 2;
	/*
	 * 普通用户类型
	 */
	private static final int NORMAL_USER = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_type")
	private int userType = NORMAL_USER;
	@Column(name="last_ip")
	private String lastIp;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
