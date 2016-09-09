package cn.tf.department.dao;

import java.util.List;

import cn.tf.department.domain.CrmDepartment;

public interface  DepartmentDao {

	List<CrmDepartment> findAllDepartment();
	

}
