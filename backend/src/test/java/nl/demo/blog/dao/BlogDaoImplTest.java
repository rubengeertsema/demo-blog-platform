package nl.demo.blog.dao;

import nl.demo.blog.model.Blog;
import nl.demo.blog.repository.BlogRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by rubengeertsema on 18/04/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BlogDaoImplTest {

    @Mock
    private BlogRepository blogRepositoryMock;
    @Mock
    private Page<Blog> page;
    private BlogDaoImpl blogDaoImpl;

    private static final String ID = "1";

    @Before
    public void setUp() throws Exception {
        blogDaoImpl = new BlogDaoImpl(blogRepositoryMock);
    }

    private Blog createBlog(String id) {
        Blog blog = new Blog();
        blog.setId(id);
        blog.setTitle("Title");
        blog.setText("Text");
        return blog;
    }

    @Test
    public void getAll() throws Exception {
        when(blogRepositoryMock.findAllByOrderByDateDesc(Mockito.any(Pageable.class))).thenReturn(page);
        Page<Blog> all = blogDaoImpl.getAll(null);

        verify(blogRepositoryMock, times(1)).findAllByOrderByDateDesc(null);
        assertEquals(page, all);
    }

    @Test
    public void get() throws Exception {
        Blog blog = createBlog(ID);
        blog.setDate(new Date());

        when(blogRepositoryMock.findOne(eq(ID))).thenReturn(blog);
        Blog returned = blogDaoImpl.get(ID);

        verify(blogRepositoryMock, times(1)).findOne(ID);
        assertEquals(blog.getId(), returned.getId());
        assertEquals(blog.getTitle(), returned.getTitle());
        assertEquals(blog.getText(), returned.getText());
        assertEquals(blog.getDate(), returned.getDate());
    }

    @Test
    public void create() throws Exception {
        Blog blog = createBlog(ID);

        when(blogRepositoryMock.save(blog)).thenReturn(blog);
        Blog returned = blogDaoImpl.create(blog);

        assertNotNull(returned.getDate());
        verify(blogRepositoryMock, times(1)).save(blog);
    }

    @Test
    public void update() throws Exception {
        Blog blog = createBlog(ID);

        when(blogRepositoryMock.findOne(eq(ID))).thenReturn(blog);
        when(blogRepositoryMock.save(blog)).thenReturn(blog);
        Blog returned = blogDaoImpl.update(blog);

        verify(blogRepositoryMock, times(1)).findOne(ID);
        verify(blogRepositoryMock, times(1)).save(blog);
        assertEquals(blog.getId(), returned.getId());
        assertEquals(blog.getTitle(), returned.getTitle());
        assertEquals(blog.getText(), returned.getText());
        assertNotNull(returned.getDate());
    }

    @Test
    public void updateNull() throws Exception {
        Blog blog = createBlog(ID);

        when(blogRepositoryMock.findOne(eq(ID))).thenReturn(null);
        Blog returned = blogDaoImpl.update(blog);

        verify(blogRepositoryMock, times(1)).findOne(ID);
        verify(blogRepositoryMock, times(0)).save(blog);
        assertNull(returned);
    }

    @Test
    public void delete() throws Exception {
        Blog blog = createBlog(ID);
        blog.setDate(new Date());

        when(blogRepositoryMock.findOne(eq(ID))).thenReturn(blog);
        Blog returned = blogDaoImpl.delete(ID);

        verify(blogRepositoryMock, times(1)).findOne(ID);
        verify(blogRepositoryMock, times(1)).delete(blog);
        assertEquals(blog.getId(), returned.getId());
        assertEquals(blog.getTitle(), returned.getTitle());
        assertEquals(blog.getText(), returned.getText());
        assertEquals(blog.getDate(), returned.getDate());
    }

    @Test
    public void deleteNull() throws Exception {
        Blog blog = createBlog(ID);
        blog.setDate(new Date());

        when(blogRepositoryMock.findOne(eq(ID))).thenReturn(null);
        Blog returned = blogDaoImpl.delete(ID);

        verify(blogRepositoryMock, times(1)).findOne(ID);
        verify(blogRepositoryMock, times(0)).delete(blog);
        assertNull(returned);
    }

    @Test
    public void deleteAll() throws Exception {
        blogDaoImpl.deleteAll();
        verify(blogRepositoryMock, times(1)).deleteAll();
    }
}
