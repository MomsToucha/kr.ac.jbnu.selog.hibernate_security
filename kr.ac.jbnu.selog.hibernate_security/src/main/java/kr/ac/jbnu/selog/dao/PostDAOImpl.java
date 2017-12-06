package kr.ac.jbnu.selog.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.selog.model.Post;


@Repository("postDao")
public class PostDAOImpl extends AbstractDao<Integer, Post> implements PostDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PostDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(post);
		logger.info("Post saved successfully, Post Details="+post);
	}

	@Override
	public void updatePost(Post post) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(post);
		logger.info("Post updated successfully, Post Details="+ post);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Post> listPosts() {
		// TODO Auto-generated method stub
/*		Session session = this.sessionFactory.getCurrentSession();
		List<Post> postsList = session.createQuery("from Post").list();
		for(Post post : postsList){
			logger.info("Post List::"+post);
		}*/
		
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Post> postsList = (List<Post>) criteria.list();
		return postsList;
	}

	@Override
	public Post getPostById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		Post post = (Post) session.load(Post.class, new Integer(id));
		logger.info("Post loaded successfully, Post details="+post);
		return post;
	}

	@Override
	public void removePost(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Post post = (Post) session.load(Post.class, new Integer(id));
		if(null != post){
			session.delete(post);
		}
		logger.info("Post deleted successfully, Post details="+post);
	}
}
