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
	@Override
	public void addUploadFile(String classId, String filePath,
			String scheduleFileName) {
		//一级缓存的内容，当修改一级缓存的内容时，当commit的时候，通过快照比较，直接更新
		CrmClass  findClass=this.classesDao.findById(classId);  
		findClass.setUploadPath(filePath);
		findClass.setUploadFileName(scheduleFileName);
	}
	
}
