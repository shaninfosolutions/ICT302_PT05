import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


import { LayoutComponent } from './layout.component';
import { ListComponent } from './list.component';
import { AddEditComponent } from './add-edit.component';
import { RulesRoutingModule } from './rules-routing.module';
import { FormsModule } from '@angular/forms'; 

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        RulesRoutingModule,
        FormsModule
    ],
    declarations: [
        LayoutComponent,
        ListComponent,
        AddEditComponent
    ]
})

export class RulesModule{}