package com.practice.common;

public class JellyBean {
	
	public int key = 0;
	public String flavor = "";
	public String comments = "";
	
	public JellyBean(int key, String flavor) {
		this.key = key;
		this.flavor = flavor;
	}
	
	public JellyBean(JellyBean bean) {
		this.key = bean.key;
		this.flavor = bean.flavor;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
