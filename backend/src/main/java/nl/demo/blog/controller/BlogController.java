package nl.demo.blog.controller;

import nl.demo.blog.dao.BlogDaoImpl;
import nl.demo.blog.model.Blog;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by rubengeertsema on 16/04/2017.
 */
//TODO: add swagger annotations
@Controller
@RequestMapping("/api/blog")
public class BlogController {

    private final BlogDaoImpl blogDao;

    @Autowired
    public BlogController(BlogDaoImpl blogDao) {
        this.blogDao = blogDao;
    }

    @GetMapping
    public ResponseEntity getAll(Pageable pageable) {
        return new ResponseEntity<>(blogDao.getAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") String id) {
        Blog blog = blogDao.get(id);

        return (blog == null)
                ? new ResponseEntity<>(String.format("No blog post found for ID [%s].", id), HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogDao.create(blog), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Blog blog) {
        Blog updatedBlog = blogDao.update(blog);

        return (updatedBlog == null)
                ? new ResponseEntity<>(String.format("No blog post found for ID [%s].", blog.getId()), HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(updatedBlog, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        Blog deletedBlog = blogDao.delete(id);

        return (deletedBlog == null)
                ? new ResponseEntity<>(String.format("No blog post found for ID [%s].", id), HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(deletedBlog, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteAll() {
        blogDao.deleteAll();
        return new ResponseEntity<>("Deleted all blog posts.", HttpStatus.OK);
    }
}
