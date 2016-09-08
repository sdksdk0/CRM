package cn.tf.Filter;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//登录拦截器
public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		
		Object loginStaff=ActionContext.getContext().getSession().get("loginStaff");
		if(loginStaff==null){
			
			//提示
			Object action=invocation.getAction();
			if(action instanceof ActionSupport){
				ActionSupport  actionSupport=(ActionSupport) action;
				actionSupport.addFieldError("loginName", "请先登录!");
			}
			
			
			//没有登录
			return "login";
		}
		//放行
		
		return invocation.invoke();
	}
	
}
