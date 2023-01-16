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
        for(Blog b : blogList){
            b.getId();
        }

        return blogRepository1.saveAll(blogList);

    }

    public void createAndReturnBlog(Integer userId, String title, String content) {


        //create a blog at the current time

        User user = userRepository1.findById(userId).get();


        //updating the blog details

        Blog blog = new Blog();
        blog.setUser(user);
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPublishDate(new Date());
        List<Blog> blogList = user.getBlogList();
        blogList.add(blog);
        user.setBlogList(blogList);
        userRepository1.save(user);


        //Updating the userInformation and changing its blogs

    }

    public Blog findBlogById(int blogId){

      return  blogRepository1.findById(blogId).get();
        //find a blog
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it

        Blog blog = blogRepository1.findById(blogId).get();

        Image img = new Image();
        img.setBlog(blog);
        img.setDescription(description);
        img.setDimensions(dimensions);

        List<Image> imageList =blog.getImageList();
        imageList.add(img);
        blogRepository1.save(blog);


    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}
