import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class CustomInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
   // debugger;
    const token= localStorage.getItem('token');

    if (localStorage.getItem('userid') && localStorage.getItem('token') ) {
       request=request.clone({
        setHeaders:{
          Authorization: `Bearer ${token}`
         }
          
      })
    }
   
    return next.handle(request);
  }
}

