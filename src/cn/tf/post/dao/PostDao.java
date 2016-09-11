package cn.tf.post.dao;

import java.util.List;

import cn.tf.base.BaseDao;
import cn.tf.department.domain.CrmDepartment;
import cn.tf.post.domain.CrmPost;

public interface PostDao extends  BaseDao<CrmPost>{

	public List<CrmPost> findAll(String departmentId);



	public int getTotalRecode();

}
