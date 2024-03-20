import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '@environments/environment';
import { TaskDto } from '@app/_models/task';

@Injectable({ providedIn: 'root' })
export class RuleCodeService {

    public taskDto?: Observable<TaskDto | null>;


    constructor(
        private http: HttpClient
    ) {
       
       
    }

    getAllByUserId(userId: string) {
        debugger;
        return this.http.get<TaskDto[]>(`${environment.apiUrl}/api/v1/dm/rules/userid/${userId}`);
    }

    getAll() {
        debugger;
        return this.http.get<TaskDto[]>(`${environment.apiUrl}/api/v1/dm/rules`);
    }

    getById(ruleCodeId: string) {
        debugger;
        return this.http.get<any>(`${environment.apiUrl}/api/v1/dm/rules/${ruleCodeId}`);
    }

    add(params: any) {
       debugger;
        return this.http.post(`${environment.apiUrl}/api/v1/dm/rules/add`, params);
    }

    getByRuleCode(ruleCode: string) {
        debugger;
        return this.http.get<any>(`${environment.apiUrl}/api/v1/dm/rule/codevalue/${ruleCode}`);
    }

    delete(ruleId: string) {
        debugger;
        return this.http.delete(`${environment.apiUrl}/api/v1/dm/rules/delete/${ruleId}`);
            
    }

    

}