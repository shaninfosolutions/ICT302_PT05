import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { AuthGuard } from './_helpers';
import { AddEditComponent } from './users/add-edit.component';

const accountModule = () => import('./account/account.module').then(x => x.AccountModule);
const usersModule = () => import('./users/users.module').then(x => x.UsersModule);
const ruleModule = () => import('./rulecode/rules.module').then(x => x.RulesModule);
const farmHouseModule = () => import('./farmhouse/farmhouse.module').then(x => x.FarmHouseModule);
const taskModule = () => import('./tasks/tasks.module').then(x => x.TasksModule);
const noteModule = () => import('./notes/notes.module').then(x => x.NotesModule);


const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'users', loadChildren: usersModule, canActivate: [AuthGuard] },
    { path: 'farmhouses', loadChildren: farmHouseModule, canActivate: [AuthGuard] },
    { path: 'tasks', loadChildren: taskModule, canActivate: [AuthGuard] },
    { path: 'notes', loadChildren: noteModule, canActivate: [AuthGuard] },
    { path: 'rules', loadChildren: ruleModule, canActivate: [AuthGuard] },
    
    { path: 'account', loadChildren: accountModule },
    { path: 'user/:userId', component: AddEditComponent, canActivate: [AuthGuard] },
   
    
    //{ path: 'statementpdf/:id', component: DigitalStatementComponent,canActivate:[AuthGaurdService]},

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }