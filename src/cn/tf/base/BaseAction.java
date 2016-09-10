package cn.tf.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport  implements ModelDriven<T>{

	public BaseAction(){
		try {
			ParameterizedType  parameterizedType=(ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> crmClass=(Class<T>) parameterizedType.getActualTypeArguments()[0];
			t=crmClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
	private T t;
	
	@Override
	public T getModel() {
		return t;
	}

	//注入使用到service
	
	
	
	//分页数据
	private int pageNum;
	private int pageSize=2;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	//简化值栈操作
	public void set(String key,Object o){
		ActionContext.getContext().getValueStack().set(key,o);
	}
	
	public void push(Object o){
		ActionContext.getContext().getValueStack().push(o);
	}
	
	public void put(String key,Object value){
		ActionContext.getContext().put(key,value);
	}
	
	public void putSession(String key,Object value){
		ActionContext.getContext().getSession().put(key, value);
	}
	
	
}
