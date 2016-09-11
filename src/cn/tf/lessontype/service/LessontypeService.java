package cn.tf.lessontype.service;


import java.util.List;

import cn.tf.lessontype.domain.CrmLessontype;
import cn.tf.page.bean.PageBean;

public interface  LessontypeService {
	
	PageBean<CrmLessontype>  findAllPage(int pageNum,int pageSize);

	List<CrmLessontype> findAll();

	CrmLessontype findById(String lessonTypeId);

	void addOrEditLessontype(CrmLessontype model);
	
}
