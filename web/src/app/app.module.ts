import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppComponent} from './app.component';
import {NewBlogDialog} from './new-blog-dialog/new-blog-dialog';
import {BlogService} from './providers/blog.service';
import {TruncatePipe} from './pipes/truncate';
import {
  MdButtonModule,
  MdCardModule,
  MdInputModule,
  MdToolbarModule,
  MdListModule,
  MdMenuModule,
  MdDialog,
  MdIconModule,
  MdDialogModule
} from '@angular/material';
import 'hammerjs';

@NgModule({
  declarations: [
    AppComponent,
    TruncatePipe,
    NewBlogDialog
  ],
  entryComponents: [
    NewBlogDialog
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    BrowserAnimationsModule,
    MdButtonModule,
    MdCardModule,
    MdInputModule,
    MdToolbarModule,
    MdListModule,
    MdMenuModule,
    MdIconModule,
    MdDialogModule
  ],
  providers: [
    MdDialog,
    BlogService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
