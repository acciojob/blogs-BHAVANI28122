package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs

        List<Blog> blogList = new ArrayList<>();

        return blogRepository1.saveAll(blogList);

    }

    public void createAndReturnBlog(Integer userId, String title, String content) {


        //create a blog at the current time



        //updating the blog details

        //Updating the userInformation and changing its blogs

    }

    public Blog findBlogById(int blogId){

      return  blogRepository1.findById(blogId).get();
        //find a blog
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
//        Blog blog = new Blog();
//        blog.getId();
//        Image img = new Image();
//        bl
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}