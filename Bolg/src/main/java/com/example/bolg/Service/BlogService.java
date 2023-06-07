package com.example.bolg.Service;

import com.example.bolg.ApiException.ApiException;
import com.example.bolg.Model.Blog;
import com.example.bolg.Model.MyUser;
import com.example.bolg.Repository.BlogRepository;
import com.example.bolg.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
        private final BlogRepository blogRepository;
        private final MyUserRepository userRepository;

        public List<Blog> getAllUsers(Integer userId) {
            return blogRepository.findBlogsByUserId(userId);
        }
        public void addBlog(Integer userid,Blog blog) {
            MyUser myUser=userRepository.findMyUserById(userid);
            blog.setUser(myUser);
            blogRepository.save(blog);
        }

        public void updateBlog(Integer userid,Blog blog,Integer blogId) {
            Blog  oldBlog = blogRepository.findBlogsById(blogId);
            if (oldBlog == null) {
                throw new ApiException("Blog Not found");
            }

            if (oldBlog.getUser().getId() != userid) {
                throw new ApiException("Error,Unauthorized");
            }
            oldBlog.setBody(blog.getBody());
            oldBlog.setTitle(blog.getTitle());
            blogRepository.save(oldBlog);
        }
        public void deleteBlog(Integer userid,Integer blogId) {
            Blog  blog = blogRepository.findBlogsById(blogId);
            if (blog.getId() == null) {

                throw new ApiException("Blog Not found");
            }
            blogRepository.delete(blog);

            if(blog.getUser().getId()!=userid) {
                throw new ApiException("unAuthorized");
            }
        }
        public void assignUserToBlog(Integer userId,Integer blogid){
            MyUser myUser=userRepository.findMyUserById(userId);
            Blog blog =blogRepository.findBlogsById(blogid);
            if(myUser==null||blog==null)
            {
                throw new ApiException ("User Or Blog are Null");
            }
            blog.setUser(myUser);
            blogRepository.save(blog);
        }


        public Blog getBlogByTitle(String title){
            return blogRepository.getBlogByTitle(title);
        }
}
