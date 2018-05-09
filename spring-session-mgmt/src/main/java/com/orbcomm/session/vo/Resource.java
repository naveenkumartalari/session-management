/**
 * 
 */
package com.orbcomm.session.vo;

import java.util.List;

/**
 * @author ntalari
 *
 */
public class Resource {
	
	private String name;
	private String url;
	private String type;
	private String desc;
	private int id;
	private String version;
	private List<String> accessPoints;
	private List<String> tags;
	private int active;
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the accessPoints
	 */
	public List<String> getAccessPoints() {
		return accessPoints;
	}
	/**
	 * @param accessPoints the accessPoints to set
	 */
	public void setAccessPoints(List<String> accessPoints) {
		this.accessPoints = accessPoints;
	}
	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	/**
	 * @return the enable
	 */
	public int getActive() {
		return active;
	}
	/**
	 * @param enable the enable to set
	 */
	public void setActive(int active) {
		this.active = active;
	}

}
