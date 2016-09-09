package cn.tf.staff.dao;

import java.util.List;

import cn.tf.staff.domain.CrmStaff;

public interface StaffDao {

	CrmStaff find(String loginName, String loginPwd);

	void save(CrmStaff crmStaff);


	List<CrmStaff> findAllStaff(String condition, Object[] params);

}
