import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LogoutComponent } from './pages/logout/logout.component';
import { HeaderComponent } from './pages/header/header.component';
import { UserprofileComponent } from './pages/userprofile/userprofile.component';
import { FarmhouseComponent } from './pages/farmhouse/farmhouse.component';
import { TaskComponent } from './pages/task/task.component';
import { NotisettingComponent } from './pages/notisetting/notisetting.component';
import { RulesettingComponent } from './pages/rulesetting/rulesetting.component';
import { PartnerComponent } from './pages/partner/partner.component';
import { NoteComponent } from './pages/note/note.component';

const routes: Routes = [
{
  path:'login',component:LoginComponent
},
{ path:'',redirectTo:'login',pathMatch:'full'},
{ path: 'logout', component: LogoutComponent},
{path:'',component:HeaderComponent,children:[
  {path:'dashboard',component:DashboardComponent},
  {path:'userprofile',component:UserprofileComponent },
  {path:'farmhouse',component:FarmhouseComponent },
  {path:'note',component:NoteComponent },
  {path:'task',component:TaskComponent},
  {path:'notisetting',component:NotisettingComponent },
  {path:'rulesetting',component:RulesettingComponent },
  {path:'partner',component:PartnerComponent },
]},

{path:'**',component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
