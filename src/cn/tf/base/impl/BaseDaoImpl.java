package cn.tf.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.tf.base.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	private Class daoImplClass;
	public BaseDaoImpl() {
		//运行时，通过反射获得 泛型信息的实际内容
		/// * 运行时，this表示当前运行类（及子类的实例对象）
		//1 获得被参数化类型 ，例如：BaseDaoImpl<CrmPost>
		ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
		//2 获得实例参数
		daoImplClass = (Class) paramType.getActualTypeArguments()[0];
		
	}

	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void SaveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public List<T> findAll() {
		return this.getHibernateTemplate().find("from " + daoImplClass.getName());
	}

	@Override
	public List<T> findAll(String condition, Object... params) {
		String hql = "from " + daoImplClass.getName() + " where 1=1 " + condition;
		return this.getHibernateTemplate().find(hql,params);
	}
	
	public List<T> findAll(DetachedCriteria detachedCriteria) {
		return this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	@Override
	public List<T> findAllByPage(int startIndex, int pageSize) {
		String hql = "from " + daoImplClass.getName();
		return this.getHibernateTemplate().execute(new PageHibernateCallBack(hql, startIndex, pageSize));
	}

	@Override
	public int getTotalRecode() {
		List<Long> list = this.getHibernateTemplate().find("select count(*) from " + daoImplClass.getName());
		return list.get(0).intValue();
	}

	@Override
	public T findById(Serializable oid) {
		List<T>  allT=this.getHibernateTemplate().find(" from "+daoImplClass.getName()+" where  id=? ",oid);
		if(allT !=null && allT.size()==1){
			return allT.get(0);
		}
		return null;
	}

	/**
	 * 通过编写回调实现分页，此实现类为固定内容
	 * @author <a>传智•左慈</a>
	 */
	class PageHibernateCallBack implements HibernateCallback<List<T>> {

		private String hql;			//查询hql语句
		private Object[] params;	//对应实际参数
		private int firstResult;	//分页开始索引
		private int maxResults;		//分页每页显示个数
		
		
		
		
		public PageHibernateCallBack(String hql, 
				int firstResult, int maxResults ,Object... params) {
			super();
			this.hql = hql;
			this.params = params;
			this.firstResult = firstResult;
			this.maxResults = maxResults;
		}




		@Override
		public List<T> doInHibernate(Session session) throws HibernateException,
				SQLException {
			// 1 创建query
			Query queryObject = session.createQuery(hql);
			// 2 封装参数
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					queryObject.setParameter(i, params[i]);
				}
			}
			// 3 分页
			if (firstResult >= 0) {
				queryObject.setFirstResult(firstResult);
			}
			if (maxResults > 0) {
				queryObject.setMaxResults(maxResults);
			}
			//4 查询所有
			return queryObject.list();
		}
		
	}



	
}
