package cn.tf.post.action;

import java.util.List;

import cn.tf.post.domain.CrmPost;
import cn.tf.post.service.PostService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost>{

	private CrmPost crmPost=new CrmPost();
	private PostService postService;
	
	public void setPostService(PostService postService) {
		this.postService = postService;
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
}
