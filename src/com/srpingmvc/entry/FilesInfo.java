package com.srpingmvc.entry;


/**
 * 文件信息实体
 * @author shitou.li
 * 2014年11月21日 下午3:35:44
 */
public class FilesInfo {
	private String path;//文件上传路径
	private String fileRealName;//文件真实名字
	private String hdName;//文件硬盘存储名字
	private String suffix;//后缀
    private String date;//上传时间
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileRealName() {
		return fileRealName;
	}
	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
	public String getHdName() {
		return hdName;
	}
	public void setHdName(String hdName) {
		this.hdName = hdName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    
    
	
}
