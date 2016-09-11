package cn.tf.post.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.tf.base.impl.BaseDaoImpl;
import cn.tf.department.dao.DepartmentDao;
import cn.tf.department.domain.CrmDepartment;
import cn.tf.post.dao.PostDao;
import cn.tf.post.domain.CrmPost;

public class PostDaoImpl  extends   BaseDaoImpl<CrmPost>  implements PostDao{

	@Override
	public List<CrmPost> findAll(String departmentId) {
		
		return this.getHibernateTemplate().find("from CrmPost c  where  c.crmDepartment.depId=? ",departmentId);
	}

	@Override
	public List<CrmPost> findAll() {
		return this.getHibernateTemplate().find("from CrmPost ");
	}

}
