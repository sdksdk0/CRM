package cn.tf.department.dao;

import java.util.List;

import cn.tf.base.BaseDao;
import cn.tf.classes.domain.CrmClass;
import cn.tf.department.domain.CrmDepartment;

public interface  DepartmentDao extends  BaseDao<CrmDepartment>{

	List<CrmDepartment> findAllDepartment();

	int getTotalRecode();

	List<CrmDepartment> findAllByPage(int startIndex, int pageSize);
	

}
