import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { environment } from '@environments/environment';
import { FarmHouseDto } from '@app/_models/farmhouse';

@Injectable({ providedIn: 'root' })
export class FarmHouseService {

    public farmHouseDto?: Observable<FarmHouseDto | null>;


    constructor(
        private router: Router,
        private http: HttpClient
    ) {
       
       
    }

    getAllByUserId(userId: string) {
        debugger;
        return this.http.get<FarmHouseDto[]>(`${environment.apiUrl}/api/v1/dm/farmhouses/userid/${userId}`);
    }

    getFHNameMapByUserId(userId: string){
        debugger;
        return this.http.get<any>(`${environment.apiUrl}/api/v1/dm/farmhouse/map/${userId}`);
 
    }

    getById(farmhouseid: string) {
        debugger;
        return this.http.get<FarmHouseDto>(`${environment.apiUrl}/api/v1/dm/farmhouse/${farmhouseid}`);
    }

    add(params: any) {
       debugger;
        return this.http.post(`${environment.apiUrl}/api/v1/dm/farmhouse/add`, params);
    }

    

    delete(farmhouseid: string) {
        debugger;
        return this.http.delete(`${environment.apiUrl}/api/v1/dm/farmhouse/delete/${farmhouseid}`);
            
    }

    

}