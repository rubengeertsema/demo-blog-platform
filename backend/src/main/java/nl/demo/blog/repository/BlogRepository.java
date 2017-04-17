package nl.demo.blog.repository;

import nl.demo.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by rubengeertsema on 16/04/2017.
 */
public interface BlogRepository extends MongoRepository<Blog, String> {

    public Page<Blog> findAllByOrderByDateDesc(Pageable pageable);

}
