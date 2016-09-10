package cn.tf.staff.action;

import java.util.List;

import cn.tf.classes.domain.CrmClass;
import cn.tf.department.domain.CrmDepartment;
import cn.tf.department.service.DepartmentService;
import cn.tf.post.domain.CrmPost;
import cn.tf.post.service.PostService;
import cn.tf.staff.domain.CrmStaff;
import cn.tf.staff.service.StaffService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction  extends ActionSupport implements ModelDriven<CrmStaff>{
	
	private CrmStaff crmStaff=new CrmStaff();
	private StaffService staffService;
	private DepartmentService  departmentService;
	private PostService postService;
	
	
	
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	public String  home(){
		return "home";
	}
	
	//进入编辑页面
	public String EditUI(){
		CrmStaff  findStaff=this.staffService.findById(this.getModel().getStaffId());
		ActionContext.getContext().getValueStack().push(findStaff);
		
		//查询所有职务
		List<CrmPost>  allPost=postService.findAllPost();
		ActionContext.getContext().put("allPost", allPost);
		//查询所有部门
		List<CrmDepartment>  allDepartment=departmentService.findAllDepartment();
		ActionContext.getContext().getValueStack().set("allDepartment", allDepartment);
		
		return "EditUI";
	}
	
	
	//保存编辑的结果
	public 	String edit(){
		
		if(crmStaff.getCrmPost().getName()=="--请选择--"){
			return ERROR;
		}
		
		this.staffService.updateStaff(crmStaff);
		
		
		
		return "edit";
	}
	
	
	
	
	public String login(){
		CrmStaff loginStaff=this.staffService.login(crmStaff);
		if(loginStaff!=null){
			//登录成功
			ActionContext.getContext().getSession().put("loginStaff", loginStaff);
			return "login_success";
			
		}else{
			this.addFieldError("loginName","用户名和密码不匹配");
			return LOGIN;
		}
		
	}
	
	
	
	//显示添加页面
	public String addUI(){
		//查询所有部门
		List<CrmDepartment>  allDepartment=departmentService.findAllDepartment();
		
		ActionContext.getContext().getValueStack().set("allDepartment", allDepartment);
		
		return "addUI";
	}
	
	
	//添加员工
	public String addOrEdit(){
		
		this.staffService.addStaff(crmStaff);
		
		return "add";
	}
	
	//查询
	public String findAll(){
		//所有部门
		List<CrmDepartment>  allDepartment=this.departmentService.findAllDepartment();
		ActionContext.getContext().put("allDepartment", allDepartment);
		
		//查询指定部门下的所有职务
		if(crmStaff.getCrmPost()!=null){
			if(crmStaff.getCrmPost().getCrmDepartment()!=null){
				String departmentId=crmStaff.getCrmPost().getCrmDepartment().getDepId();
				List<CrmPost>  allPost=this.postService.findAllPost(departmentId);
				//存放到值栈
				ActionContext.getContext().put("allPost", allPost);
			}
		}
		
		
		
		//所有员工
		List<CrmStaff> allStaff=this.staffService.findAllStaff(crmStaff);
		ActionContext.getContext().put("allStaff", allStaff);
		
		return "findAll";
	}
	
	@Override
	public CrmStaff getModel() {
		
		return crmStaff;
	}
	
	//显示登录页面
	public String loginUI(){
		return "loginUI";
	}
	

}
