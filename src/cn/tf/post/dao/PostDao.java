package cn.tf.post.dao;

import java.util.List;

import cn.tf.post.domain.CrmPost;

public interface PostDao {

	public List<CrmPost> findAll(String departmentId);

}
