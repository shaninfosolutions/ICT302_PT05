import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { environment } from '@environments/environment';

import { RuleCodeDto,RuleCodeValueDto } from '@app/_models/rulecode';

@Injectable({ providedIn: 'root' })
export class RuleCodeService {
    //private ruleCodeDtoSubject: BehaviorSubject<RuleCodeDto | null>;
 //   public ruleCodeDto: Observable<RuleCodeDto | null>;

    constructor(
        private router: Router,
        private http: HttpClient
    ) {
   
        //this.ruleCodeDto =this.ruleCodeDtoSubject.asObservable();
    }

   // public get userValue() {
      //  return this.ruleCodeDto?.value;
   // }

   getAll() {
    //debugger;
    return this.http.get<RuleCodeDto[]>(`${environment.apiUrl}/api/v1/dm/users`);
}
}