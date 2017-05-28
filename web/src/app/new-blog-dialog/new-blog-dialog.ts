import {Component, OnInit} from '@angular/core';
import {MdInputModule, MdDialogRef} from '@angular/material';
import {BlogService} from '../providers/blog.service';
import {Blog} from '../models/blog.model';

@Component({
  selector: 'new-blog-dialog',
  templateUrl: './new-blog-dialog.html',
  styleUrls: ['./new-blog-dialog.css']
})
export class NewBlogDialog implements OnInit {

  title: string = '';
  text: string = '';

  constructor(public dialogRef: MdDialogRef<NewBlogDialog>,
              private blogService: BlogService) {
  }

  ngOnInit(): void {
  }

  postBlog() {
    let blog = new Blog(null, this.title, this.text, null);
    this.blogService.postBlog(blog).subscribe((result) => {
      console.log(`Posted blog ${result}`);
      this.dialogRef.close(result);
    }, error => {
      console.log(`Could not post blog ${blog}`)
    });
  }

  closeDialog() {
    this.dialogRef.close();
  }
}
