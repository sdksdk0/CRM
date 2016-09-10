package cn.tf.classes.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

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
	
	public String uploadUI(){
		//通过id查询班级
		CrmClass findClass=this.classesService.findById(this.getModel().getClassId());
		this.push(findClass);	
		return "uploadUI";
	}
	
	private File schedule;   //文件内容
	private String scheduleFileName;  //文件名称
	private String scheduleContentType;  //文件类型
	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}
	public void setScheduleContentType(String scheduleContentType) {
		this.scheduleContentType = scheduleContentType;
	}
	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}
	
	@InputConfig(resultName="uploadError")
	public String upload(){
		//将文件保存到硬盘中，文件名随机，没有扩展名
		//上传文件的父目录
		try {
			String parentDir=ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
			//保存文件
			String filePath=UUID.randomUUID().toString();
			FileUtils.copyFile(schedule, new File(parentDir,filePath));
			this.classesService.addUploadFile(this.getModel().getClassId(),filePath,scheduleFileName);
			return "upload";
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	private InputStream target;
	private String downloadFileName;
	public InputStream getTarget() {
		return target;
	}
	public String getDownloadFileName() {
		//解决中文乱码
		if(downloadFileName!=null){
			try {
				return new String(downloadFileName.getBytes(),"ISO-8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return downloadFileName;
	}
	
	
	public String download(){
		CrmClass findClass=this.classesService.findById(this.getModel().getClassId());
		
		//读取内容
		InputStream is=ServletActionContext.getServletContext().getResourceAsStream("WEB-INF/upload/"+findClass.getUploadPath());
		if(is!=null){
			target=is;
			downloadFileName=findClass.getUploadFileName();
			return "download";
		}
		this.addFieldError("", "下载的资源不存在");
		return ERROR;

	}

}
