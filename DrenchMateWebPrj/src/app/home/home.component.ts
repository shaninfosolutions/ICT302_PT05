import { Component, OnInit } from '@angular/core';

import { User } from '@app/_models';
import { AccountService } from '@app/_services';
import Chart from 'chart.js/auto';
import { first } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';
import { NotificationService } from '@app/_services/notification.service';

import { NotiNoteSeverifyLevelDto } from '@app/_models/notification';

import {  AlertService } from '@app/_services';

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent implements OnInit {
    user: User | null;
    loading = false;
    userId?: string;

    notiNoteSeverifyLevelDto?:NotiNoteSeverifyLevelDto|null;

    public chart: any;

    public chartNotiNote: any;

    public charNotiTask:any;
    
    notiValue?:any[];
    labelNotiValue?:any[];
    backgroundColor?:any[];

    notiValueTask?:any[];
    labelNotiValueTask?:any[];
    backgroundColorTask?:any[];

    notinotesummarys?: any[];

    notitasksummarys?:any[];

    constructor(
      private alertService: AlertService,
      private router: Router,
      private accountService: AccountService,
        private notificationService:NotificationService) {
        this.user = this.accountService.userValue;
    }

    ngOnInit(): void {
        //this.createChart();
        
        if (this.user?.userId) {
          
          // edit mode
          //this.title = 'Edit User';
          this.loading = true;
          debugger;
          this.notificationService.getNotiNoteSeverityLevelByUserId(this.user?.userId)
              .pipe(first())
              .subscribe(x => {
                //console.log("x is " + x)
                if (typeof x === 'object' && x !== null) {
                  debugger;
                  this.notiValue = x["notiValue"]; // Assuming notiValue is an array property
                  this.labelNotiValue =x["labelNotiValue"]; // Assuming labelNotiValue is an array property
                  this.backgroundColor =x["backgroundColor"]; // Assuming backgroundColor is an array property
                  this.createChartNotiNotes();
                } else {
                  console.error('Invalid response format'); // Handle error if response is not in expected format
                }
                  this.loading = false;
              });

              this.notificationService.getNotiTaskSeverityLevelByUserId(this.user?.userId)
              .pipe(first())
              .subscribe(x => {
                //console.log("x is " + x)
                if (typeof x === 'object' && x !== null) {
                  debugger;
                  this.notiValueTask = x["notiValue"]; // Assuming notiValue is an array property
                  this.labelNotiValueTask =x["labelNotiValue"]; // Assuming labelNotiValue is an array property
                  this.backgroundColorTask =x["backgroundColor"]; // Assuming backgroundColor is an array property
                  this.createChartTaskNotes();
                } else {
                  console.error('Invalid response format'); // Handle error if response is not in expected format
                }
                  this.loading = false;
              });


              this.notificationService.getNotiNoteSummaryByUserId(this.user?.userId)
              .subscribe(notinotesummarys => this.notinotesummarys = notinotesummarys);


              this.notificationService.getNotiTasksSummaryByUserId(this.user?.userId)
              .subscribe(notitasksummarys => this.notitasksummarys = notitasksummarys);

      }

     

      }


      createChartNotiNotes(){

        this.chartNotiNote = new Chart("UserNoteNotification", {
        type: 'pie', //this denotes tha type of chart
        data: {// values on X-Axis
        labels: this.labelNotiValue,
        datasets: [{
        label: 'User Note Notification',
        data:  this.notiValue,
        backgroundColor: this.backgroundColor,
        hoverOffset: 4 }], },
          options: {aspectRatio:7.5}
    
        });

        
      }

      createChartTaskNotes(){

        this.charNotiTask = new Chart("TaskNotification", {
        type: 'pie', //this denotes tha type of chart
        data: {// values on X-Axis
        labels: this.labelNotiValueTask,
        datasets: [{
        label: 'Task Notification',
        data:  this.notiValueTask,
        backgroundColor: this.backgroundColorTask,
        hoverOffset: 4 }], },
          options: {aspectRatio:7.5}
    
        });

        
      }

    updateNoti(noti: any) {
        debugger;
        debugger;
      this.notificationService.updateNotiNoteByUserId(noti,this.user?.userId)
            .pipe(first())
            .subscribe({
                next: () => {
                    this.router.navigate(['home']);
                    this.alertService.success('Noti Note Update successful', { keepAfterRouteChange: false })
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });


    }

    updateNotiTask(noti: any) {
      debugger;
      this.notificationService.updateNotiTaskByUserId(noti,this.user?.userId)
            .pipe(first())
            .subscribe({
                next: () => {
                    this.router.navigate(['home']);
                    this.alertService.success('Noti Task Update successful', { keepAfterRouteChange: false })
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });

  }

  getColorForValue(value: string): string {
    switch(value) {
        case 'S1':
            return 'red';
        case 'S2':
            return 'orange';
        case 'S3':
            return 'green';
        // Add more cases as needed for other values
        default:
            return 'black'; // Default color if value doesn't match any case
    }
}

getColorForValueTask(value: string): string {
  switch(value) {
      case 'OVER DUE':
          return 'red';
      case 'ON TIME':
          return 'orange';
      case 'DUE':
          return 'green';
      // Add more cases as needed for other values
      default:
          return 'black'; // Default color if value doesn't match any case
  }
}

}