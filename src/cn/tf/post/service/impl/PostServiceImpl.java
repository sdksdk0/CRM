package cn.tf.post.service.impl;

import java.util.List;

import cn.tf.department.domain.CrmDepartment;
import cn.tf.page.bean.PageBean;
import cn.tf.post.dao.PostDao;
import cn.tf.post.domain.CrmPost;
import cn.tf.post.service.PostService;

public class PostServiceImpl implements PostService{

	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	
	@Override
	public List<CrmPost> findAllPost(String departmentId) {
	
		return postDao.findAll(departmentId);
	}


	@Override
	public List<CrmPost> findAllPost() {
		
		return postDao.findAll();
	}


	@Override
	public PageBean<CrmPost> findAllPage(int pageNum, int pageSize) {
		
		//1 查询数据库，获得总记录数
		int totalRecord = postDao.getTotalRecode();
						
		//2 分页数据
		PageBean<CrmPost> pageBean = new PageBean<CrmPost>(pageNum, pageSize, totalRecord);
						
		//3 查询分页结果
		pageBean.setData(postDao.findAllByPage(pageBean.getStartIndex(), pageSize));
						
		return pageBean;
	}


	@Override
	public CrmPost findById(String postId) {
		
		return postDao.findById(postId);
	}


	@Override
	public void addOrEditPost(CrmPost crmPost) {

	 postDao.SaveOrUpdate(crmPost);
	  
	}

}
