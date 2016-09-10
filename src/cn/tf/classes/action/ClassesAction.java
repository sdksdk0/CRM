package cn.tf.classes.action;

import java.util.List;

import cn.tf.base.BaseAction;
import cn.tf.classes.domain.CrmClass;
import cn.tf.classes.service.ClassesService;
import cn.tf.lessontype.domain.CrmLessontype;
import cn.tf.lessontype.service.LessontypeService;

public class ClassesAction extends BaseAction<CrmClass>{
	
	
	private ClassesService  classesService;
	private LessontypeService  lessontypeService;
	
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}
	
	public void setLessontypeService(LessontypeService lessontypeService) {
		this.lessontypeService = lessontypeService;
	}
	
	
	public String findAll(){
		//查询
		List<CrmClass> allClass=this.classesService.findAllClasses();
		//结果存放起来
		this.set("allClass", allClass);
		return "findAll";
	}
	
	//打开添加或编辑的页面
	public String addOrEditUI(){
		if(this.getModel().getClassId()!=null){
			CrmClass findClass=this.classesService.findById(this.getModel().getClassId());
			this.push(findClass);
		}
		//查询所有的课程类别
		List<CrmLessontype>  allLessontype=this.lessontypeService.findAll();
		this.put("allLessontype", allLessontype);
		return "addOrEditUI";
	}
	
	
	public String addOrEdit(){
		this.classesService.addOrEditClasses(this.getModel());
		
		return "addOrEdit";
	}
	
	

}
