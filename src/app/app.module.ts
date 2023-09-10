import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
//root components
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//components created
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { RenewalPageComponent } from './renewal-page/renewal-page.component';
//for reactive and template forms
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
//security
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { authInterceptorProviders } from './services/auth.interceptor';
//for calling server
import { HttpClientModule } from '@angular/common/http';
//for search via pipe
import { FilterPipe } from './filter.pipe';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    PageNotFoundComponent,
    LoginComponent,
    RegisterComponent,
    AboutUsComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    RenewalPageComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule //spring;http client class use kr sakte
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
