import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService } from '@app/_services';
import { FarmHouseDto } from '@app/_models/farmhouse';
import { FarmHouseService } from '@app/_services/farmhouse.service';
import { TasksService } from '@app/_services/tasks.service';
import { TaskDto } from '@app/_models/task';


@Component({ templateUrl: 'add-edit.component.html' })
export class AddEditComponent implements OnInit {
    form!: FormGroup;
    farmHouseId?: string;

    farmHouseNameMap?:any;

    taskId?:string;
    title!: string;
    loading = false;
    submitting = false;
    submitted = false;
    farmHouseDto?:FarmHouseDto

    taskDto?:TaskDto;

    user?:any;
   

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private farmHouseService: FarmHouseService,
        private tasksService:TasksService,
        private alertService: AlertService
    ) {  this.user=localStorage.getItem('user');}

    ngOnInit() {
        this.taskId= this.route.snapshot.params['taskId'];
       

        // form with validation rules
        this.form = this.formBuilder.group({
            farmHouseName: ['', Validators.required],
            taskTitle: ['', Validators.required],
            startDate: ['', Validators.required],
            endDate: ['', Validators.required],
            remarks: ['', Validators.required],
        });

        this.title = 'Add New Task';
        if (this.taskId) {
            // edit mode
            this.title = 'Edit Task';
            this.loading = true;
            this.tasksService.getById(this.taskId)
                .pipe(first())
                .subscribe(x => {
                    this.form.patchValue(x);
                    this.loading = false;
                });

            
        }else{

            this.farmHouseService.getFHNameMapByUserId(JSON.parse(this.user).userId)
                .pipe(first())
                .subscribe(x=>{
                    this.form.patchValue({ ...this.form.value,farmHouseNameMap:x})
                })
            
        }
    }

    // convenience getter for easy access to form fields
    get f() { return this.form.controls; }

    onSubmit() {

        this.submitted = true;

        // reset alerts on submit
        this.alertService.clear();

        // stop here if form is invalid
        if (this.form.invalid) {
            return;
        }

        this.loading = true;

        if (this.taskId) {

            const  userId =JSON.parse(this.user).userId;
            const  lastUpdatedBy=JSON.parse(this.user).name;
     
            const updatedFormValue = { ...this.form.value, userId: userId, lastUpdatedBy:lastUpdatedBy,
                farmHouseId:this.farmHouseId};

            this.farmHouseService.add(updatedFormValue)
            .pipe(first())
            .subscribe({
                next: () => {
                    this.alertService.success('Farmhouse Update successful', { keepAfterRouteChange: true });
                    //this.router.navigate(['farmhouses'], { relativeTo: this.route });

                    this.router.navigate(['farmhouses']);
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });

        }else{
       debugger;
       const  userId =JSON.parse(this.user).userId;
       const  createdBy=JSON.parse(this.user).name;
       const  lastUpdatedBy=JSON.parse(this.user).name;

       const updatedFormValue = { ...this.form.value, userId: userId, 
                    createdBy:createdBy,lastUpdatedBy:lastUpdatedBy};

        this.farmHouseService.add(updatedFormValue)
            .pipe(first())
            .subscribe({
                next: () => {
                    this.alertService.success('New Farmhouse Added successful', { keepAfterRouteChange: true });
                    //this.router.navigate(['/'], { relativeTo: this.route });
                    this.router.navigate(['farmhouses']);
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });

        }
        
    }

    private saveUser() {
        
    }
}