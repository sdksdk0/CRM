package cn.tf.department.service;

import java.util.List;

import cn.tf.department.domain.CrmDepartment;
import cn.tf.page.bean.PageBean;

public interface DepartmentService {

	List<CrmDepartment> findAllDepartment();

	PageBean<CrmDepartment> findAllPage(int pageNum, int pageSize);

	CrmDepartment findById(String depId);

	void addOrEditDepartment(CrmDepartment model);
	

}
