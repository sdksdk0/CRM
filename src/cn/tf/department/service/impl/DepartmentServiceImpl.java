package cn.tf.department.service.impl;

import java.util.List;

import cn.tf.department.dao.DepartmentDao;
import cn.tf.department.domain.CrmDepartment;
import cn.tf.department.service.DepartmentService;
import cn.tf.lessontype.domain.CrmLessontype;
import cn.tf.page.bean.PageBean;

public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	

	@Override
	public List<CrmDepartment> findAllDepartment() {
		return departmentDao.findAllDepartment();
	}


	@Override
	public PageBean<CrmDepartment> findAllPage(int pageNum, int pageSize) {
		//1 查询数据库，获得总记录数
		int totalRecord = departmentDao.getTotalRecode();
				
				//2 分页数据
		PageBean<CrmDepartment> pageBean = new PageBean<CrmDepartment>(pageNum, pageSize, totalRecord);
				
				//3 查询分页结果
		pageBean.setData(departmentDao.findAllByPage(pageBean.getStartIndex(), pageSize));
				
		return pageBean;
	}


	@Override
	public CrmDepartment findById(String depId) {
	
		return departmentDao.findById(depId);
	}


	@Override
	public void addOrEditDepartment(CrmDepartment model) {
		departmentDao.SaveOrUpdate(model);
		
	}

}
