package cn.tf.post.domain;

import java.util.HashSet;
import java.util.Set;

import cn.tf.department.domain.CrmDepartment;
import cn.tf.staff.domain.CrmStaff;

/**
 * CrmPost entity. @author MyEclipse Persistence Tools
 */

public class CrmPost implements java.io.Serializable {

	// Fields

	private String postId;
	private CrmDepartment crmDepartment;
	private String name;
	private Set<CrmStaff> crmStaffs = new HashSet<CrmStaff>();
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public CrmDepartment getCrmDepartment() {
		return crmDepartment;
	}
	public void setCrmDepartment(CrmDepartment crmDepartment) {
		this.crmDepartment = crmDepartment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<CrmStaff> getCrmStaffs() {
		return crmStaffs;
	}
	public void setCrmStaffs(Set<CrmStaff> crmStaffs) {
		this.crmStaffs = crmStaffs;
	}
	public CrmPost(String postId, CrmDepartment crmDepartment, String name,
			Set<CrmStaff> crmStaffs) {
		super();
		this.postId = postId;
		this.crmDepartment = crmDepartment;
		this.name = name;
		this.crmStaffs = crmStaffs;
	}
	public CrmPost() {
		super();
	}

	
	

}