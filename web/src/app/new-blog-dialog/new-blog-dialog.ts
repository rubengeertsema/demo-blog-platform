import {Component, OnInit} from '@angular/core';
import {MdInputModule, MdDialogRef} from '@angular/material';

@Component({
  selector: 'new-blog-dialog',
  templateUrl: './new-blog-dialog.html',
  styleUrls: ['./new-blog-dialog.css']
})
export class NewBlogDialog implements OnInit {

  constructor(public dialogRef: MdDialogRef<NewBlogDialog>) {
  }

  ngOnInit(): void {
  }
}
