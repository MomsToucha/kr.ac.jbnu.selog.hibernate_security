package kr.ac.jbnu.selog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.jbnu.selog.dao.PostDAO;
import kr.ac.jbnu.selog.model.Post;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostDAO postDAO;
	
	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
	
	@Override
	@Transactional
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		this.postDAO.addPost(post);
	}

	@Override
	@Transactional
	public void updatePost(Post post) {
		// TODO Auto-generated method stub
		this.postDAO.updatePost(post);
		
	}

	@Override
	@Transactional
	public List<Post> listPosts() {
		// TODO Auto-generated method stub
		System.out.println("되는거니??");
		return this.postDAO.listPosts();
	}

	@Override
	@Transactional
	public Post getPostById(int id) {
		// TODO Auto-generated method stub
		return this.postDAO.getPostById(id);
	}

	@Override
	@Transactional
	public void removePost(int id) {
		// TODO Auto-generated method stub
		this.postDAO.removePost(id);
	}

}
