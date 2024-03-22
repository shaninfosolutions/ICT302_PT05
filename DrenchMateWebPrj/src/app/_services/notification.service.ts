import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '@environments/environment';
import { NotiNoteSeverifyLevelDto } from '@app/_models/notification';

@Injectable({ providedIn: 'root' })
export class NotificationService {

    constructor(
        private http: HttpClient
    ) {}

    getNotiNoteSeverityLevelByUserId(userId: string) {
        debugger;
        return this.http.get<any>(`${environment.apiUrl}/api/v1/dm/noti/note/${userId}`);
    }

    getNotiTaskSeverityLevelByUserId(userId: string) {
        debugger;
        return this.http.get<any>(`${environment.apiUrl}/api/v1/dm/noti/task/${userId}`);
    }

    getNotiNoteSummaryByUserId(userId: string) {
        debugger;
        return this.http.get<any>(`${environment.apiUrl}/api/v1/dm/noti/notesummary/${userId}`);
    }


    getNotiTasksSummaryByUserId(userId: string) {
        debugger;
        return this.http.get<any>(`${environment.apiUrl}/api/v1/dm/noti/tasksummary/${userId}`);
    }

    updateNotiTaskByUserId(notiTask:any,userId:any){
        const params = { userId };
        debugger;
        return this.http.post<any>(`${environment.apiUrl}/api/v1/dm/noti/task/addorupdate`,notiTask,{params});
    }

    updateNotiNoteByUserId(notiNote:any,userId:any){
        const params = { userId };
        debugger;
        return this.http.post<any>(`${environment.apiUrl}/api/v1/dm/noti/task/addorupdate`,notiNote,{params});
    }

}