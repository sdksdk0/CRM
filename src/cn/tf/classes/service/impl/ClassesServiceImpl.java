package cn.tf.classes.service.impl;

import java.util.List;

import cn.tf.classes.dao.ClassesDao;
import cn.tf.classes.domain.CrmClass;
import cn.tf.classes.service.ClassesService;

public class ClassesServiceImpl implements ClassesService{
	
	private ClassesDao  classesDao;
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}
	@Override
	public List<CrmClass> findAllClasses() {
		
		return classesDao.findAll();
	}
	@Override
	public void addOrEditClasses(CrmClass crmClass) {
		
		classesDao.SaveOrUpdate(crmClass);
	}
	@Override
	public CrmClass findById(String classId) {
		return classesDao.findById(classId);
	}
	
}
