package cn.tf.post.service.impl;

import java.util.List;

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

}
