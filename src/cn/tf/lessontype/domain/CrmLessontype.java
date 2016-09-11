package cn.tf.lessontype.domain;

import java.util.HashSet;
import java.util.Set;

import cn.tf.classes.domain.CrmClass;

/**
 * CrmLessontype entity. @author MyEclipse Persistence Tools
 */

public class CrmLessontype implements java.io.Serializable {

	// Fields

	private String lessonTypeId;
	private Double lessonCost;
	private Integer total;
	private String lessonName;
	private String remark;
	private Set<CrmClass> crmClasses = new HashSet<CrmClass>();
	

	private String startTotal;   //总学时（范围开始）
	private String endTotal;   //总学时（范围结束）

	private String startLessonCost;   //课程费用
	private String endLessonCost;   //课程费用

	
	public CrmLessontype() {
		super();
	}
	
	
	public CrmLessontype(String lessonTypeId, Double lessonCost, Integer total,
			String lessonName, String remark, Set<CrmClass> crmClasses,
			String startTotal, String endTotal, String startLessonCost,
			String endLessonCost) {
		super();
		this.lessonTypeId = lessonTypeId;
		this.lessonCost = lessonCost;
		this.total = total;
		this.lessonName = lessonName;
		this.remark = remark;
		this.crmClasses = crmClasses;
		this.startTotal = startTotal;
		this.endTotal = endTotal;
		this.startLessonCost = startLessonCost;
		this.endLessonCost = endLessonCost;
	}





	public String getStartTotal() {
		return startTotal;
	}
	public void setStartTotal(String startTotal) {
		this.startTotal = startTotal;
	}
	public String getEndTotal() {
		return endTotal;
	}
	public void setEndTotal(String endTotal) {
		this.endTotal = endTotal;
	}
	public String getStartLessonCost() {
		return startLessonCost;
	}
	public void setStartLessonCost(String startLessonCost) {
		this.startLessonCost = startLessonCost;
	}
	public String getEndLessonCost() {
		return endLessonCost;
	}
	public void setEndLessonCost(String endLessonCost) {
		this.endLessonCost = endLessonCost;
	}


	public String getLessonTypeId() {
		return lessonTypeId;
	}
	public void setLessonTypeId(String lessonTypeId) {
		this.lessonTypeId = lessonTypeId;
	}
	public Double getLessonCost() {
		return lessonCost;
	}
	public void setLessonCost(Double lessonCost) {
		this.lessonCost = lessonCost;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<CrmClass> getCrmClasses() {
		return crmClasses;
	}
	public void setCrmClasses(Set<CrmClass> crmClasses) {
		this.crmClasses = crmClasses;
	}

	

}