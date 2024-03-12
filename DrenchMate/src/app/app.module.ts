import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { LayoutComponent } from './pages/layout/layout.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http'
import { HeaderComponent } from './pages/header/header.component';
import { FooterComponent } from './pages/footer/footer.component';
import { LogoutComponent } from './pages/logout/logout.component';
import { UserprofileComponent } from './pages/userprofile/userprofile.component';
import { FarmhouseComponent } from './pages/farmhouse/farmhouse.component';
import { TaskComponent } from './pages/task/task.component';
import { NoteComponent } from './pages/note/note.component';
import { NotisettingComponent } from './pages/notisetting/notisetting.component';
import { RulesettingComponent } from './pages/rulesetting/rulesetting.component';
import { PartnerComponent } from './pages/partner/partner.component';
import { AnimalComponent } from './pages/animal/animal.component';
import { CustomInterceptor } from './services/custom.interceptor';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LayoutComponent,
    DashboardComponent,
    HeaderComponent,
    FooterComponent,
    LogoutComponent,
    UserprofileComponent,
    FarmhouseComponent,
    TaskComponent,
    NoteComponent,
    NotisettingComponent,
    RulesettingComponent,
    PartnerComponent,
    AnimalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NoopAnimationsModule
  ],
  providers: [
    {
      provide:HTTP_INTERCEPTORS,
      useClass:CustomInterceptor,
      multi:true
    }
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
