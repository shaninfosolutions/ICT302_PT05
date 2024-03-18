import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import {  AlertService } from '@app/_services';
import { FarmHouseDto } from '@app/_models/farmhouse';
import { FarmHouseService } from '@app/_services/farmhouse.service';


@Component({ templateUrl: 'add-edit.component.html' })
export class AddEditComponent implements OnInit {
    form!: FormGroup;
    farmHouseId?: string;
    title!: string;
    loading = false;
    submitting = false;
    submitted = false;
    farmHouseDto?:FarmHouseDto

    user?:any;
   

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private farmHouseService: FarmHouseService,
        private alertService: AlertService
    ) {  this.user=localStorage.getItem('user');}

    ngOnInit() {
        this.farmHouseId= this.route.snapshot.params['farmHouseId'];
       

        // form with validation rules
        this.form = this.formBuilder.group({
            farmHouseName: ['', Validators.required],
            location: ['', Validators.required],
            capacity: ['', Validators.required],
            remarks: ['', Validators.required],
        });

        this.title = 'Add New Farm House';
        if (this.farmHouseId) {
            // edit mode
            this.title = 'Edit Farm House';
            this.loading = true;
            this.farmHouseService.getById(this.farmHouseId)
                .pipe(first())
                .subscribe(x => {
                    this.form.patchValue(x);
                    this.loading = false;
                });
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

        if (this.farmHouseId) {

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