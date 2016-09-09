package cn.tf.department.service.impl;

import java.util.List;

import cn.tf.department.dao.DepartmentDao;
import cn.tf.department.domain.CrmDepartment;
import cn.tf.department.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	

	@Override
	public List<CrmDepartment> findAllDepartment() {
		return departmentDao.findAllDepartment();
	}

}
