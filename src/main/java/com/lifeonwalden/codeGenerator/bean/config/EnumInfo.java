package com.lifeonwalden.codeGenerator.bean.config;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias(value = "enumInfo")
public class EnumInfo implements Serializable {
	private static final long serialVersionUID = 6729183562859310073L;

	@XStreamAsAttribute
	private String packageName;

	@XStreamAsAttribute
	private String folderName;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
}
