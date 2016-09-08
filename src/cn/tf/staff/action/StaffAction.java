package cn.tf.staff.action;

import cn.tf.staff.domain.CrmStaff;
import cn.tf.staff.service.StaffService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction  extends ActionSupport implements ModelDriven<CrmStaff>{
	
	private CrmStaff crmStaff=new CrmStaff();
	private StaffService staffService;
	
	
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	public String  home(){
		return "home";
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
	
	
	@Override
	public CrmStaff getModel() {
		
		return crmStaff;
	}
	
	//显示登录页面
	public String loginUI(){
		return "loginUI";
	}
	
	
	

}
