package cn.tf.post.service;

import java.util.List;

import cn.tf.page.bean.PageBean;
import cn.tf.post.domain.CrmPost;

public interface PostService {

	List<CrmPost> findAllPost(String departmentId);

	List<CrmPost> findAllPost();

	PageBean<CrmPost> findAllPage(int pageNum, int pageSize);

	CrmPost findById(String postId);

	void addOrEditPost(CrmPost model);

}
