package kr.ac.jbnu.selog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.jbnu.selog.model.Post;
import kr.ac.jbnu.selog.service.PostService;

@Controller
public class PostController {

	private PostService postService;
	
	@RequestMapping(value = "/posts", method = {RequestMethod.GET, RequestMethod.POST})
	public String listPosts(Model model) {
		model.addAttribute("post", new Post());
		model.addAttribute("listPosts", this.postService.listPosts());
		System.out.println("====================================");
		System.out.println("포스트 리스트 불러옴");
		System.out.println("====================================");
		return "post";
	}
	
	//For add and update person both
	@RequestMapping(value= "/post/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String addPost(@ModelAttribute("post") Post p){
		
		if(p.getPost_key() == 0){
			//new member, add it
			this.postService.addPost(p);
		}else{
			//existing member, call update
			this.postService.updatePost(p);
		}
		
		return "redirect:/posts";
		
	}
	
	
	@RequestMapping(value= "/remove_post/{post_key}", method = {RequestMethod.GET, RequestMethod.POST})
    public String removePost(@PathVariable("post_key") int postkey){
		
        this.postService.removePost(postkey);
        return "redirect:/posts";
    }
 
    @RequestMapping(value= "/edit_post/{post_key}", method = {RequestMethod.GET, RequestMethod.POST})
    public String editPerson(@PathVariable("post_key") int postkey, Model model){
        model.addAttribute("post", this.postService.getPostById(postkey));
        model.addAttribute("listPosts", this.postService.listPosts());
        return "post";
    }
}
