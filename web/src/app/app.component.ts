import { Component, OnInit } from '@angular/core';
import { Blog } from './models/blog.model';
import { BlogService } from './providers/blog.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  blogs: Blog[];

  constructor(
    private blogService: BlogService,
  ) { }

  ngOnInit(): void {
    this.getBlogs();
  }

  getBlogs(): void {
    this.blogService.getBlogs()
      .subscribe((blogs) => {
        console.log(blogs);
        this.blogs = blogs;
      }, error => {
        console.log('Could not load blogs.');
      });
  }
}
