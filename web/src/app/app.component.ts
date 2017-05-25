import { Component, OnInit } from '@angular/core';
import { MdDialog, MdDialogRef } from '@angular/material';
import { Blog } from './models/blog.model';
import { BlogService } from './providers/blog.service';
import { NewBlogDialog } from './new-blog-dialog/new-blog-dialog';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  selectedOption: string;
  blogs: Blog[];

  constructor(
    private blogService: BlogService,
    public dialog: MdDialog
  ) { }

  ngOnInit(): void {
    this.getBlogs();
  }

  openNewBlogDialog(): void {
    let dialogRef = this.dialog.open(NewBlogDialog);
    dialogRef.afterClosed().subscribe(result => {
      this.selectedOption = result;
    });
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

  deleteBlog(blog: Blog, i: number) {
    this.blogService.deleteBlog(blog)
      .subscribe((blog) => {
        console.log(blog);
        this.blogs.splice(i,1);
    }, error => {
        console.log('Could not delete blog.');
    });
  }

  deleteAll() {
    this.blogService.deleteAll()
      .subscribe(() => {
        this.blogs = [];
    }, error => {
        console.log('Could not delete blog.');
    });
  }
}
