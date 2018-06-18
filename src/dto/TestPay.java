package dto;

import java.io.Serializable;

public class TestPay implements Serializable{

	private String name;
	
	private String code;
	
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "TestPay [name=" + name + ", code=" + code + ", desc=" + desc
				+ "]";
	}
	
	
}
