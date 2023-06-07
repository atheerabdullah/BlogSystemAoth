package com.example.bolg.Repository;


import com.example.bolg.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository <Blog, Integer> {

    Blog findBlogsById(Integer id);


    Blog getBlogByTitle(String title);

    List<Blog> findBlogsByUserId(Integer id);



}
