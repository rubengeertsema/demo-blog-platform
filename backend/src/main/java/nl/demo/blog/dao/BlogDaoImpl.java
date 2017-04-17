package nl.demo.blog.dao;

import nl.demo.blog.model.Blog;
import nl.demo.blog.repository.BlogRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by rubengeertsema on 17/04/2017.
 */
@Component
public class BlogDaoImpl implements BlogDao {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogDaoImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Page<Blog> getAll(Pageable pageable) {
        return blogRepository.findAllByOrderByDateDesc(pageable);
    }

    @Override
    public Blog get(String id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Blog create(Blog blog) {
        blog.setDate(new Date());
        blogRepository.save(blog);
        return blog;
    }

    @Override
    public Blog update(Blog blog) {
        Blog toBeUpdated = blogRepository.findOne(blog.getId());
        if (toBeUpdated == null) {
            return null;
        }
        toBeUpdated.setTitle(blog.getTitle());
        toBeUpdated.setText(blog.getText());
        toBeUpdated.setDate(new Date());
        return blogRepository.save(toBeUpdated);
    }

    @Override
    public Blog delete(String id) {
        Blog toBeDeleted = blogRepository.findOne(id);
        if (toBeDeleted == null) {
            return null;
        }
        blogRepository.delete(toBeDeleted);
        return toBeDeleted;
    }

    @Override
    public void deleteAll() {
        blogRepository.deleteAll();
    }
}
