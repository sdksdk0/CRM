package cn.tf.lessontype.action;


import cn.tf.lessontype.domain.CrmLessontype;
import cn.tf.lessontype.service.LessontypeService;
import cn.tf.page.bean.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LessontypeAction  extends ActionSupport implements ModelDriven<CrmLessontype> {

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
		private int pageSize = 2 ;
		
		/**
		 * 查询所有--分页
		 * @return
		 */
		public String findAll(){
			
			PageBean<CrmLessontype> pageBean = this.lessontypeService.findAllPage(pageNum, pageSize);

			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			
			return "findAll";
					
					
		}

}
