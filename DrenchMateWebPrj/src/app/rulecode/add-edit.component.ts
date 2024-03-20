import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService } from '@app/_services';
import { FarmHouseDto } from '@app/_models/farmhouse';
import { FarmHouseService } from '@app/_services/farmhouse.service';
import { NotesService } from '@app/_services/note.service';
import { TaskDto } from '@app/_models/task';
import { RuleCodeService } from '@app/_services/rulecode.service';

@Component({ templateUrl: 'add-edit.component.html' })
export class AddEditComponent implements OnInit {
    form!: FormGroup;
    ruleCodeId?:string;
    title!: string;
    loading = false;
    submitting = false;
    submitted = false;
    farmHouseDto?:FarmHouseDto
    //ruleCodeValueList?: any[];
    selectedFarmhouseId: any;

    taskDto?:TaskDto;

    user?:any;
   

    constructor(
        private farmhouseService: FarmHouseService,
        private ruleCodeService:RuleCodeService,
        private notesService:NotesService,
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService
    ) {  this.user=localStorage.getItem('user');}

    ngOnInit() {
        this.ruleCodeId= this.route.snapshot.params['ruleId'];
        // form with validation rules
        debugger;
        this.form = this.formBuilder.group({
           // farmHouseId:['',Validators.required],
            //farmHouseName: ['', Validators.required],
            codeDesc: ['', Validators.required],
            code: ['', Validators.required],
            remarks: ['', Validators.required],
            ruleCodeValueList:[[],Validators.required]
        });

        //this.farmhouseService.getAllByUserId(JSON.parse(this.user).userId)
           // .subscribe(ruleCodes => this.ruleCodes = ruleCodes);
        debugger;
        this.title = 'Add New Rule Code';
        if (this.ruleCodeId) {
            // edit mode
            this.title = 'Edit Rule Code';
            this.loading = true;
            this.ruleCodeService.getById(this.ruleCodeId)
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

        debugger;
        this.submitted = true;

        // reset alerts on submit
        this.alertService.clear();

        // stop here if form is invalid
        if (this.form.invalid) {
            return;
        }

        this.loading = true;

        if (this.ruleCodeId) {
            const  userId =JSON.parse(this.user).userId;
            const  lastUpdatedBy=JSON.parse(this.user).name;
     
            const updatedFormValue = { ...this.form.value, userId: userId,noteId:this.ruleCodeId,
                 lastUpdatedBy:lastUpdatedBy};

            this.ruleCodeService.add(updatedFormValue)
            .pipe(first())
            .subscribe({
                next: () => {
                    this.alertService.success('Rule Code Update successful', { keepAfterRouteChange: true });
                    this.router.navigate(['rules']);
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });

        }else{
       const  userId =JSON.parse(this.user).userId;
       const  createdBy=JSON.parse(this.user).name;
       const  lastUpdatedBy=JSON.parse(this.user).name;

       const updatedFormValue = { ...this.form.value, userId: userId, 
                    createdBy:createdBy,lastUpdatedBy:lastUpdatedBy};
      
        this.notesService.add(updatedFormValue)
            .pipe(first())
            .subscribe({
                next: () => {
                    this.alertService.success('New Rule Code Added successful', { keepAfterRouteChange: true });
                    //this.router.navigate(['/'], { relativeTo: this.route });
                    this.router.navigate(['rules']);
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });

        }
        
    }

    onFarmhouseSelect() {
       // this.farmHouseId=this.form.get('farmHouseId')?.value;
    }

    deleteRule(id: string){

    }
   
    

    private saveUser() {
        
    }
}