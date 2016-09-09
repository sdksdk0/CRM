package cn.tf.staff.service.impl;

import java.util.List;

import cn.tf.staff.dao.StaffDao;
import cn.tf.staff.domain.CrmStaff;
import cn.tf.staff.service.StaffService;
import cn.tf.utils.MD5Util;

public class StaffServiceImpl implements StaffService{

	private StaffDao staffDao;
	
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}


	@Override
	public CrmStaff login(CrmStaff crmStaff) {
		String loginPwd=MD5Util.getMD5Value(crmStaff.getLoginPwd());
		return staffDao.find(crmStaff.getLoginName(),loginPwd);
	}


	//添加员工
	@Override
	public void addStaff(CrmStaff crmStaff) {
		crmStaff.setLoginPwd(MD5Util.getMD5Value(crmStaff.getLoginPwd()));
		staffDao.save(crmStaff);
		
	}


	//根据条件查询所有
	@Override
	public List<CrmStaff> findAllStaff(CrmStaff crmStaff) {
		String condition="";
		Object[] params={};

		return staffDao.findAllStaff(condition,params);
	}

}
