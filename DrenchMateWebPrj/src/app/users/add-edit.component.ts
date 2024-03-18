import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AccountService, AlertService } from '@app/_services';

@Component({ templateUrl: 'add-edit.component.html' })
export class AddEditComponent implements OnInit {
    form!: FormGroup;
    userId?: string;
    title!: string;
    loading = false;
    submitting = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private accountService: AccountService,
        private alertService: AlertService
    ) { }

    ngOnInit() {
        this.userId= this.route.snapshot.params['userId'];

        // form with validation rules
        this.form = this.formBuilder.group({
            name: ['', Validators.required],
            email: ['', Validators.required],
            displayName: ['', Validators.required],
            // password only required in add mode
            password: ['', [Validators.minLength(6), ...(!this.userId ? [Validators.required] : [])]],
            phoneNo: ['', Validators.required],
            facebookLink: ['', Validators.required],
            twitterLink: ['', Validators.required],
            emailToNotify: ['', Validators.required],
            remarks: ['', Validators.required],
            noofdaysToNoti: ['', Validators.required],
            
        });

       // this.title = 'Add User';
        if (this.userId) {
            // edit mode
            //this.title = 'Edit User';
            this.loading = true;
            this.accountService.getById(this.userId)
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

        this.submitting = true;
        debugger;
        this.saveUser()
            .pipe(first())
            .subscribe({
                next: () => {
                    this.alertService.success('User saved', { keepAfterRouteChange: true });
                    //this.router.navigateByUrl('/');
                  // this.router.navigateByUrl(this.router.url);
                    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
                        this.router.navigate(['/']);
                    });
                   
                },
                error: error => {
                    this.alertService.error(error);
                    this.submitting = false;
                }
            })
    }

    private saveUser() {
        // create or update user based on id param
        debugger;
        return this.accountService.update(this.userId!, this.form.value);
    }
}