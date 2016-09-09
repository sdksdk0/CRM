package cn.tf.department.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.tf.department.dao.DepartmentDao;
import cn.tf.department.domain.CrmDepartment;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	@Override
	public List<CrmDepartment> findAllDepartment() {
		
		
		
		return this.getHibernateTemplate().find("from CrmDepartment");
	}

}
