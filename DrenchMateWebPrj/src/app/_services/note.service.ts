import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '@environments/environment';
import { TaskDto } from '@app/_models/task';

@Injectable({ providedIn: 'root' })
export class NotesService {

    public taskDto?: Observable<TaskDto | null>;


    constructor(
        private http: HttpClient
    ) {
       
       
    }

    getAllByUserId(userId: string) {
        debugger;
        return this.http.get<TaskDto[]>(`${environment.apiUrl}/api/v1/dm/notes/userid/${userId}`);
    }

    getById(noteId: string) {
        debugger;
        return this.http.get<TaskDto>(`${environment.apiUrl}/api/v1/dm/notes/${noteId}`);
    }

    add(params: any) {
       debugger;
        return this.http.post(`${environment.apiUrl}/api/v1/dm/note/add`, params);
    }

    

    delete(noteId: string) {
        debugger;
        return this.http.delete(`${environment.apiUrl}/api/v1/dm/note/delete/${noteId}`);
            
    }

    

}