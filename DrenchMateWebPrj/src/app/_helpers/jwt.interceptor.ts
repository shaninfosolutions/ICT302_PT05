import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '@environments/environment';
import { AccountService } from '@app/_services';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private accountService: AccountService) { }

   /* intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add auth header with jwt if user is logged in and request is to the api url
        const user = this.accountService.userValue;
        const isLoggedIn = user && user.token;
        debugger;
        const isApiUrl = request.url.startsWith(environment.apiUrl);
        const token = user?.token;
        console.log("Is API URL " + isApiUrl +":"+token);
        if (isLoggedIn) {
            console.log("Is logged in true");
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${token}`
                }

               
            });
            console.log("request:" + request.headers.get("Authorization"))
        }

        return next.handle(request);
    }
*/

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // Retrieve user and token from AccountService
        const user = this.accountService.userValue;
        
        // Check if user is logged in and if the request is to the API URL
        const isLoggedIn = user && user.token;
        const isApiUrl = request.url.startsWith(environment.apiUrl);
        
        // If user is logged in and request is to the API URL
        if (isLoggedIn && isApiUrl) {
            // Clone the request and set Authorization header with token
            const token = user.token;
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${token}`
                }
            });
        }
    
        // Pass the modified request to the next interceptor or to the HTTP handler
        //console.log("request:" + request.headers.get("Authorization"))
        return next.handle(request);
    }
    
}