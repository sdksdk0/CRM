package cn.tf.staff.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.tf.department.domain.CrmDepartment;
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
		
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		
		// 1.1 职务或部门
		if(crmStaff.getCrmPost() != null){
			// 选中职务
			if(StringUtils.isNotBlank(crmStaff.getCrmPost().getPostId())){
				builder.append(" and crmPost = ?");
				paramsList.add(crmStaff.getCrmPost());
			} else {
				//有可能选中部门
				CrmDepartment crmDepartment = crmStaff.getCrmPost().getCrmDepartment();
				if(crmDepartment != null && StringUtils.isNotBlank(crmDepartment.getDepId())){
					builder.append(" and crmPost.crmDepartment = ?");
					paramsList.add(crmDepartment);
				}
			}
		}
		// 1.2 姓名
		if(StringUtils.isNotBlank(crmStaff.getStaffName() )){
			builder.append(" and staffName like ?");
			paramsList.add("%" + crmStaff.getStaffName() + "%");
		}
		
		String condition = builder.toString();
		Object[] params = paramsList.toArray();

		return staffDao.findAllStaff(condition,params);
	}


	@Override
	public CrmStaff findById(String staffId) {
		
		return staffDao.findById(staffId);
	}


	@Override
	public void updateStaff(CrmStaff crmStaff) {
		crmStaff.setLoginPwd(MD5Util.getMD5Value(crmStaff.getLoginPwd()));
		 staffDao.update(crmStaff);
	}

}
