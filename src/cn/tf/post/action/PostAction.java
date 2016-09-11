package cn.tf.post.action;

import java.util.List;

import cn.tf.base.BaseAction;
import cn.tf.classes.domain.CrmClass;
import cn.tf.department.domain.CrmDepartment;
import cn.tf.department.service.DepartmentService;
import cn.tf.lessontype.domain.CrmLessontype;
import cn.tf.page.bean.PageBean;
import cn.tf.post.domain.CrmPost;
import cn.tf.post.service.PostService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends BaseAction<CrmPost>{

	private CrmPost crmPost=new CrmPost();
	private PostService postService;
	private DepartmentService  departmentService;
	
	
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	
	@Override
	public CrmPost getModel() {
		return crmPost;
	}
	
	public String ajaxGetAllPost(){
		
		String departmentId = crmPost.getCrmDepartment().getDepId();
		List<CrmPost> allPost = postService.findAllPost(departmentId);
		System.out.println(allPost.size());
		ActionContext.getContext().getValueStack().set("allPost", allPost);
		return "ajaxGetAllPost";
	}
	
	private int pageNum;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	private int pageSize = 5 ;
	public String findAll(){
		PageBean<CrmPost> pageBean = this.postService.findAllPage(pageNum, pageSize);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//打开添加或修改页面
	public String addOrEditUI(){
		
		if(this.getModel().getPostId()!=null){
			CrmPost findPost=this.postService.findById(this.getModel().getPostId());
			this.push(findPost);
		}
		//查询所有的课程类别
		List<CrmDepartment>  allDept=this.departmentService.findAllDepartment();
		this.put("allDept", allDept);
		return "addOrEditUI";
	}
	
	//添加或修改
	public String addOrEdit(){
		this.postService.addOrEditPost(this.getModel());
		
		return "addOrEdit";
	}
	
	
	
}
