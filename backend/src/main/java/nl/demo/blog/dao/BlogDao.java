package nl.demo.blog.dao;

import nl.demo.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by rubengeertsema on 17/04/2017.
 */
public interface BlogDao {

    public Blog get(String id);

    public Blog create(Blog blog);

    public Blog update(Blog blog);

    public Blog delete(String id);

    public Page<Blog> getAll(Pageable pageable);

    public void deleteAll();

}
