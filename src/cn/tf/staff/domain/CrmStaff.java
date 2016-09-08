package cn.tf.staff.domain;

import java.sql.Timestamp;
import java.util.Date;

import cn.tf.post.domain.CrmPost;

/**
 * CrmStaff entity. @author MyEclipse Persistence Tools
 */

public class CrmStaff implements java.io.Serializable {

	// Fields

	private String staffId;
	private CrmPost crmPost;
	private String staffCode;
	private String loginName;
	private String loginPwd;
	private String staffName;
	private String gender;
	private Date birthday;
	private Date onDutyDate;
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public CrmPost getCrmPost() {
		return crmPost;
	}
	public void setCrmPost(CrmPost crmPost) {
		this.crmPost = crmPost;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getOnDutyDate() {
		return onDutyDate;
	}
	public void setOnDutyDate(Date onDutyDate) {
		this.onDutyDate = onDutyDate;
	}
	public CrmStaff(String staffId, CrmPost crmPost, String staffCode,
			String loginName, String loginPwd, String staffName, String gender,
			Date birthday, Date onDutyDate) {
		super();
		this.staffId = staffId;
		this.crmPost = crmPost;
		this.staffCode = staffCode;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.staffName = staffName;
		this.gender = gender;
		this.birthday = birthday;
		this.onDutyDate = onDutyDate;
	}
	public CrmStaff() {
		super();
	}

	

}