package com.suxiangyu.cms.domain;

public enum Gender {
	
	MALE("男"),FEMALE("女");
	
	private String disPlay;

	/**
	 * 有参构造方法
	 * @param disPlay
	 */
	private Gender(String disPlay) {
		this.disPlay = disPlay;
	}

	public String getDisPlay() {
		return disPlay;
	}

}
