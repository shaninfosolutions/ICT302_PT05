import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '@environments/environment';
import { TaskDto } from '@app/_models/task';

@Injectable({ providedIn: 'root' })
export class TasksService {

    public taskDto?: Observable<TaskDto | null>;


    constructor(
        private http: HttpClient
    ) {
       
       
    }

    getAllByUserId(userId: string) {
        debugger;
        return this.http.get<TaskDto[]>(`${environment.apiUrl}/api/v1/dm/tasks/userid/${userId}`);
    }

    getById(taskId: string) {
        debugger;
        return this.http.get<TaskDto>(`${environment.apiUrl}/api/v1/dm/tasks/${taskId}`);
    }

    add(params: any) {
       debugger;
        return this.http.post(`${environment.apiUrl}/api/v1/dm/farmhouse/add`, params);
    }

    

    delete(taskId: string) {
        debugger;
        return this.http.delete(`${environment.apiUrl}/api/v1/dm/farmhouse/delete/${taskId}`);
            
    }

    

}