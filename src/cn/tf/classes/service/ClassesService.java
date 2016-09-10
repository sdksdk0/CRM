package cn.tf.classes.service;

import java.util.List;

import cn.tf.classes.domain.CrmClass;

public interface  ClassesService {
	//查询所有班级
	public List<CrmClass>  findAllClasses();
	
	//添加或编辑
	public void addOrEditClasses(CrmClass crmClass);

	//通过id查询
	public CrmClass findById(String classId);

	//上传课表
	public void addUploadFile(String classId, String filePath,
			String scheduleFileName);

}
