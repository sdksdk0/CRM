package cn.tf.department.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.tf.base.BaseAction;
import cn.tf.classes.domain.CrmClass;
import cn.tf.department.domain.CrmDepartment;
import cn.tf.department.service.DepartmentService;
import cn.tf.lessontype.domain.CrmLessontype;
import cn.tf.page.bean.PageBean;

public class DepartmentAction extends BaseAction<CrmDepartment>{
	
	private CrmDepartment  crmDepartment;
	private DepartmentService  departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	private int pageNum;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	private int pageSize = 5 ;
	
	
	public String findAll(){
		
		PageBean<CrmDepartment> pageBean = this.departmentService.findAllPage(pageNum, pageSize);

		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findAll";
	}
	
	//增加或修改的页面
	public String addOrEditUI(){
		
		CrmDepartment findDept=this.departmentService.findById(this.getModel().getDepId());
		this.push(findDept);
		
		return "addOrEditUI";
	}
	
	
	public String addOrEdit(){
		
		this.departmentService.addOrEditDepartment(this.getModel());
		
		return "addOrEdit";
	}

}
