package cn.tf.department.domain;

import java.util.HashSet;
import java.util.Set;

import cn.tf.post.domain.CrmPost;

/**
 * CrmDepartment entity. @author MyEclipse Persistence Tools
 */

public class CrmDepartment implements java.io.Serializable {

	// Fields

	private String depId;
	private String depName;
	private Set<CrmPost> crmPosts = new HashSet<CrmPost>();
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Set<CrmPost> getCrmPosts() {
		return crmPosts;
	}
	public void setCrmPosts(Set<CrmPost> crmPosts) {
		this.crmPosts = crmPosts;
	}
	public CrmDepartment(String depId, String depName, Set<CrmPost> crmPosts) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.crmPosts = crmPosts;
	}
	public CrmDepartment() {
		super();
	}

	

}