package cn.tf.lessontype.action;


import java.util.List;

import cn.tf.base.BaseAction;
import cn.tf.classes.domain.CrmClass;
import cn.tf.lessontype.domain.CrmLessontype;
import cn.tf.lessontype.service.LessontypeService;
import cn.tf.page.bean.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LessontypeAction  extends BaseAction<CrmLessontype> {

		private CrmLessontype crmLessontype = new CrmLessontype();
		@Override
		public CrmLessontype getModel() {
			return this.crmLessontype;
		}
		//2 service
		private LessontypeService lessontypeService;
		public void setLessontypeService(LessontypeService lessontypeService) {
			this.lessontypeService = lessontypeService;
		}

		//3 分页数据
		private int pageNum;
		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}
		private int pageSize = 5 ;
		
		/**
		 * 查询所有--分页
		 * @return
		 */
		public String findAll(){
			
			PageBean<CrmLessontype> pageBean = this.lessontypeService.findAllPage(pageNum, pageSize);

			this.set("pageBean", pageBean);
			
			return "findAll";			
	  }
		
		
		
		
		
	//打开添加或修改页面
		public String addOrEditUI(){
			
		
		CrmLessontype  findLessontype=this.lessontypeService.findById(this.getModel().getLessonTypeId());
		this.push(findLessontype);
	
	
			return "addOrEditUI";
		}


		public String addOrEdit(){
			this.lessontypeService.addOrEditLessontype(this.getModel());
			return "addOrEdit";
		}

}
