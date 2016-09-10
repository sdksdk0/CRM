package cn.tf.classes.domain;

import java.sql.Timestamp;
import java.util.Date;

import cn.tf.lessontype.domain.CrmLessontype;

/**
 * CrmClass entity. @author MyEclipse Persistence Tools
 */

public class CrmClass implements java.io.Serializable {

	// Fields

	private String classId;
	private CrmLessontype crmLessontype;
	private String name;
	private Date beginTime;
	private Date endTime;
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

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public CrmLessontype getCrmLessontype() {
		return crmLessontype;
	}

	public void setCrmLessontype(CrmLessontype crmLessontype) {
		this.crmLessontype = crmLessontype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getGoCount() {
		return goCount;
	}

	public void setGoCount(Integer goCount) {
		this.goCount = goCount;
	}

	public Integer getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(Integer leaveCount) {
		this.leaveCount = leaveCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public CrmClass(String classId, CrmLessontype crmLessontype, String name,
			Date beginTime, Date endTime, String state, Integer totalCount,
			Integer goCount, Integer leaveCount, String remark,
			String uploadFileName, String uploadPath) {
		super();
		this.classId = classId;
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

	

}