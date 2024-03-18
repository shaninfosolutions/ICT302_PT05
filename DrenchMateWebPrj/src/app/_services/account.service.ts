import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { environment } from '@environments/environment';
import { User,UserDto,RegisterUser} from '@app/_models';

@Injectable({ providedIn: 'root' })
export class AccountService {
    private userSubject: BehaviorSubject<User | null>;
    public user: Observable<User | null>;

    AuthRequest: any={
        "email":"",
        "password":""
      }
    

    constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.userSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('user')!));
        this.user = this.userSubject.asObservable();
    }

    public get userValue() {
        return this.userSubject.value;
    }

    login(username: string, password: string) {
        //debugger;
        this.AuthRequest.email=username;
        this.AuthRequest.password=password;
        return this.http.post<User>(`${environment.apiUrl}/api/v1/login`, this.AuthRequest)
            .pipe(map(user => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('user', JSON.stringify(user));
                this.userSubject.next(user);
                return user;
            }));
    }

    logout() {
        // remove user from local storage and set current user to null
        localStorage.removeItem('user');
        this.userSubject.next(null);
        this.router.navigate(['/account/login']);
    }

    register(user: RegisterUser) {
        return this.http.post(`${environment.apiUrl}/api/v1/register`, user);
    }

    getAll() {
        //debugger;
        return this.http.get<UserDto[]>(`${environment.apiUrl}/api/v1/dm/users`);
    }

    getById(userId: string) {
        debugger;
        return this.http.get<UserDto>(`${environment.apiUrl}/api/v1/dm/user/${userId}`);
    }

    update(id: string, params: any) {
        return this.http.post(`${environment.apiUrl}/api/v1/dm/user/update/${id}`, params)
            .pipe(map(x => {
                // update stored user if the logged in user updated their own record
                if (id == this.userValue?.userId) {
                    // update local storage
                    const user = { ...this.userValue, ...params };
                    localStorage.setItem('user', JSON.stringify(user));

                    // publish updated user to subscribers
                    this.userSubject.next(user);
                }
                return x;
            }));
    }

    delete(id: string) {
        return this.http.delete(`${environment.apiUrl}/users/${id}`)
            .pipe(map(x => {
                // auto logout if the logged in user deleted their own record
                if (id == this.userValue?.userId) {
                    this.logout();
                }
                return x;
            }));
    }
}