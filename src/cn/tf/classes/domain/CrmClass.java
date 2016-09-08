package cn.tf.classes.domain;

import java.sql.Timestamp;

import cn.tf.lessontype.domain.CrmLessontype;

/**
 * CrmClass entity. @author MyEclipse Persistence Tools
 */

public class CrmClass implements java.io.Serializable {

	// Fields

	private String classId;
	private CrmLessontype crmLessontype;
	private String name;
	private Timestamp beginTime;
	private Timestamp endTime;
	private String state;
	private Integer totalCount;
	private Integer goCount;
	private Integer leaveCount;
	private String remark;
	private String uploadFileName;
	private String uploadPath;

	// Constructors

	/** default constructor */
	public CrmClass() {
	}

	/** full constructor */
	public CrmClass(CrmLessontype crmLessontype, String name,
			Timestamp beginTime, Timestamp endTime, String state,
			Integer totalCount, Integer goCount, Integer leaveCount,
			String remark, String uploadFileName, String uploadPath) {
		this.crmLessontype = crmLessontype;
		this.name = name;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.state = state;
		this.totalCount = totalCount;
		this.goCount = goCount;
		this.leaveCount = leaveCount;
		this.remark = remark;
		this.uploadFileName = uploadFileName;
		this.uploadPath = uploadPath;
	}

	// Property accessors

	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public CrmLessontype getCrmLessontype() {
		return this.crmLessontype;
	}

	public void setCrmLessontype(CrmLessontype crmLessontype) {
		this.crmLessontype = crmLessontype;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getGoCount() {
		return this.goCount;
	}

	public void setGoCount(Integer goCount) {
		this.goCount = goCount;
	}

	public Integer getLeaveCount() {
		return this.leaveCount;
	}

	public void setLeaveCount(Integer leaveCount) {
		this.leaveCount = leaveCount;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUploadFileName() {
		return this.uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadPath() {
		return this.uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

}