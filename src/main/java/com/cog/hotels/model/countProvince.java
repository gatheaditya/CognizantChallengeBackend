package com.cog.hotels.model;

public class countProvince {
	
	private long count;
	
	private String province;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public countProvince(String province,long count)
	{
		this.setProvince(province);
		this.setCount(count);
	}
	
}
