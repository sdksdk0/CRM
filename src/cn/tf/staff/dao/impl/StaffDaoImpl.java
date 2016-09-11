package cn.tf.staff.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.tf.staff.dao.StaffDao;
import cn.tf.staff.domain.CrmStaff;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao{

	@Override
	public CrmStaff find(String loginName, String loginPwd) {
		
		List<CrmStaff>  all=this.getHibernateTemplate().find("from CrmStaff c where c.loginName=? and c.loginPwd=? ",loginName,loginPwd);
		if(all.size()>0){
			return all.get(0);
		}
		return null;
	}

	@Override
	public void save(CrmStaff crmStaff) {
		this.getHibernateTemplate().save(crmStaff);
		
	}

	@Override
	public List<CrmStaff> findAllStaff(String condition, Object[] params) {
		String hql="from CrmStaff where 1=1 "+condition;
		
		return this.getHibernateTemplate().find(hql,params);
	}

	@Override
	public CrmStaff findById(String staffId) {
		
		List<CrmStaff>  allT=this.getHibernateTemplate().find(" from CrmStaff  where  id=? ",staffId);
		if(allT !=null && allT.size()==1){
			return allT.get(0);
		}
		return null;
	}

	@Override
	public void update(CrmStaff crmStaff) {
	
		String staffCode=crmStaff.getStaffCode();

		if(staffCode!=null){
			//修改密码
			String loginPwd=crmStaff.getLoginPwd();
			String staffId=crmStaff.getStaffId();
			
			
			String hql1="update CrmStaff c set c.loginPwd=?  where c.staffId=?";
			this.getHibernateTemplate().bulkUpdate(hql1,loginPwd,staffId);
			
		}else{
			String loginName=crmStaff.getLoginName();
			String staffName=crmStaff.getStaffName();
			String gender=crmStaff.getGender();
			String postId=crmStaff.getCrmPost().getPostId();
			Date onDutyDate=crmStaff.getOnDutyDate();
			String staffId=crmStaff.getStaffId();
			
			
			
			String hql="update CrmStaff c  set c.loginName=? ,c.staffName=?,c.gender=?,c.crmPost.postId=?, c.onDutyDate=?   where c.staffId=?   ";
			this.getHibernateTemplate().bulkUpdate(hql, loginName,staffName,gender,postId,onDutyDate,staffId);
			
		}
		
		
		
		
	}

	
	

}
