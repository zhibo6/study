package org.study.common;


/**
 * @description: 接口交互结果模型
 * @author liuzhibo
 * @date 2015年6月11日 上午11:53:51 
 */
public class ResultInfo {
	private String code;
	private String desc;
	private Object content;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
