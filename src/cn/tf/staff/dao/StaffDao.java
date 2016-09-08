package cn.tf.staff.dao;

import cn.tf.staff.domain.CrmStaff;

public interface StaffDao {

	CrmStaff find(String loginName, String loginPwd);

}
