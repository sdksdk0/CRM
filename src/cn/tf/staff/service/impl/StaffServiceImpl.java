package cn.tf.staff.service.impl;

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

}
