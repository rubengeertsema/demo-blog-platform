import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable'
import {Blog} from '../models/blog.model';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class BlogService {

  baseUrl = 'http://localhost:8080/api/blog';

  constructor(private http: Http) {
  }

  public getBlogs(): Observable<Blog[]> {
    return this.http.get(this.baseUrl + '?page=0&size=200')
      .map((res: Response) => res.json().content)
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  public postBlog(blog: Blog): Observable<Blog[]> {
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});

    return this.http.post(this.baseUrl, blog, options)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  public deleteBlog(blog: Blog): Observable<Blog[]> {
    return this.http.delete(this.baseUrl + '/' + blog.id)
      .map((res: Response) => res.json().content)
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  public deleteAll(): Observable<string> {
    return this.http.delete(this.baseUrl)
      .map((res: Response) => res)
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }
}
