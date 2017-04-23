import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable'
import { Blog } from '../models/blog.model';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class BlogService {

  baseUrl = 'http://localhost:8080/api/blog';

  constructor(private http: Http) { }

  public getBlogs(): Observable<Blog[]> {
    return this.http.get(this.baseUrl + '?page=0&size=200')
      .map((res: Response) => res.json().content)
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }
}
