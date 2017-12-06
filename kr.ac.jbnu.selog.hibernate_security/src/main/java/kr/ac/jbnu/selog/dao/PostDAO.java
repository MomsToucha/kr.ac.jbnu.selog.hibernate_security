package kr.ac.jbnu.selog.dao;

import java.util.List;

import kr.ac.jbnu.selog.model.Post;


public interface PostDAO {
	
public void addPost(Post post);
	
	public void updatePost(Post post);
	
	public List<Post> listPosts();
	
	public Post getPostById(int id);
	
	public void removePost(int id);

}
