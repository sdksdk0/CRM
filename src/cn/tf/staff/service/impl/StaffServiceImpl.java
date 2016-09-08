package cn.tf.staff.service.impl;

import cn.tf.staff.dao.StaffDao;
import cn.tf.staff.domain.CrmStaff;
import cn.tf.staff.service.StaffService;

public class StaffServiceImpl implements StaffService{

	private StaffDao staffDao;
	
	
	
	
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}




	@Override
	public CrmStaff login(CrmStaff crmStaff) {
		return staffDao.find(crmStaff.getLoginName(),crmStaff.getLoginPwd());
	}

}
