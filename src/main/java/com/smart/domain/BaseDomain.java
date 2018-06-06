package com.smart.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseDomain implements Serializable {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}
}
