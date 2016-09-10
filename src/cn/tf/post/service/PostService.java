package cn.tf.post.service;

import java.util.List;

import cn.tf.post.domain.CrmPost;

public interface PostService {

	List<CrmPost> findAllPost(String departmentId);

	List<CrmPost> findAllPost();

}
