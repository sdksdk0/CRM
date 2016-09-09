package cn.tf.staff.service;

import java.util.List;

import cn.tf.staff.domain.CrmStaff;

public interface StaffService {

	public CrmStaff login(CrmStaff crmStaff);

	public void addStaff(CrmStaff crmStaff);

	public List<CrmStaff> findAllStaff(CrmStaff crmStaff);

}
