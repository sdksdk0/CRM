package cn.tf.lessontype.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.tf.lessontype.dao.LessontypeDao;
import cn.tf.lessontype.domain.CrmLessontype;
import cn.tf.lessontype.service.LessontypeService;
import cn.tf.page.bean.PageBean;

public class LessontypeServiceImpl implements LessontypeService {

	private LessontypeDao lessontypeDao;
	public void setLessontypeDao(LessontypeDao lessontypeDao) {
		this.lessontypeDao = lessontypeDao;
	}
	
	@Override
	public PageBean<CrmLessontype> findAllPage(int pageNum, int pageSize) {
		
		//1 查询数据库，获得总记录数
		int totalRecord = lessontypeDao.getTotalRecode();
		//2 分页数据
		PageBean<CrmLessontype> pageBean = new PageBean<CrmLessontype>(pageNum, pageSize, totalRecord);
		
		//3 查询分页结果
		pageBean.setData(lessontypeDao.findAllByPage(pageBean.getStartIndex(), pageSize));
		
		return pageBean;
	}

	@Override
	public List<CrmLessontype> findAll() {
		return lessontypeDao.findAll();
	}

	@Override
	public CrmLessontype findById(String lessonTypeId) {
		
		return lessontypeDao.findById(lessonTypeId);
	}

	@Override
	public void addOrEditLessontype(CrmLessontype model) {
		lessontypeDao.SaveOrUpdate(model);
		
	}


}
