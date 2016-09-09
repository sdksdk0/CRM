package cn.tf.staff.dao.impl;

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

	
	

}
