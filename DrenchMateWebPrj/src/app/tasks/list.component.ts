﻿import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';

import { FarmHouseService } from '@app/_services/farmhouse.service';
import { TasksService } from '@app/_services/tasks.service';
import { NotesService } from '@app/_services/note.service';
import {  AlertService } from '@app/_services';


@Component({ templateUrl: 'list.component.html' })
export class ListComponent implements OnInit {
    tasks?: any[];
    

    loading = false;
    submitting = false;
    submitted = false;

    user?:any;

    constructor(
        private tasksService: TasksService,
        private alertService: AlertService,
        private route: ActivatedRoute,
        private router: Router,) {
        this.user=localStorage.getItem('user');
        
    }
    
    
    ngOnInit() {
       debugger;
        this.tasksService.getAllByUserId(JSON.parse(this.user).userId)
            .subscribe(tasks => this.tasks = tasks);

        
    }

    deleteFarmhouse(id: string) {
        debugger;
       // const farmhouse = this.farmhouses!.find(x => x.id === id);
       // farmhouse.isDeleting = true;
      //  this.farmhouseService.delete(id)
           // .pipe(first())
            //.subscribe(() => this.farmhouses = this.farmhouses!.filter(x => x.id !== id));

            debugger;
            this.tasksService.delete(id)
            .pipe(first())
            .subscribe({
                next: () => {
                   // this.alertService.success('Farmhouse Deletion successful', { keepAfterRouteChange: false });
                    //this.router.navigate([], { relativeTo: this.route });
                    //this.router.navigateByUrl(this.router.url);
                    // Navigate to a different route and then back to trigger a reload
                    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
                    this.router.navigate(['notes']);
                    this.alertService.success('Note Deletion successful', { keepAfterRouteChange: false });
                    });
                    
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });


    }
}