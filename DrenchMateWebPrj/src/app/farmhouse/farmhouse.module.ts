import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


import { LayoutComponent } from './layout.component';
import { ListComponent } from './list.component';
import { AddEditComponent } from './add-edit.component';
import { FarmHouseRoutingModule } from './farmhouse-routing.module';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        FarmHouseRoutingModule
    ],
    declarations: [
        LayoutComponent,
        ListComponent,
        AddEditComponent
    ]
})

export class FarmHouseModule{}