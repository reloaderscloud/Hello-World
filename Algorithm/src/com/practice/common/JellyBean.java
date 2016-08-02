package com.practice.common;

public class JellyBean {
	
	public int key = 0;
	public String flavor = "";
	
	public JellyBean(int key, String flavor) {
		this.key = key;
		this.flavor = flavor;
	}
	
	public JellyBean(JellyBean bean) {
		this.key = bean.key;
		this.flavor = bean.flavor;
	}

}
