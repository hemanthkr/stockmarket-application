import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterCompanyComponent } from './admin/register-company/register-company.component';
import { AddStockexchangeComponent } from './admin/add-stockexchange/add-stockexchange.component';
import { AdminComponent } from './admin/admin/admin.component';
import { IpoDetailsComponent } from './admin/ipo-details/ipo-details.component';
import { CompanyListComponent } from './admin/company-list/company-list.component';
import { CompanyUpdateComponent } from './admin/company-update/company-update.component';
import { IpoReviseComponent } from './admin/ipo-revise/ipo-revise.component';
import { StockpriceUploadComponent } from './admin/stockprice-upload/stockprice-upload.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { ChartsComponent } from './profile/charts/charts.component';
import { DetailsComponent } from './profile/details/details.component';
import { HandleIpoComponent } from './profile/handle-ipo/handle-ipo.component';
import { ProfileUpdateComponent } from './profile/profile-update/profile-update.component';
import { ProfileComponent } from './profile/profile/profile.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { CompanyService } from './shared/services/company.service';
import { IpoDetailService } from './shared/services/ipo-detail.service';
import { ProfileService } from './shared/services/profile.service';
import { StockpriceService } from './shared/services/stockprice.service';
import { StockexchangeListComponent } from './admin/stockexchange-list/stockexchange-list.component';


@NgModule({
  declarations: [
    AppComponent,
    RegisterCompanyComponent,
    AddStockexchangeComponent,
    AdminComponent,
    IpoDetailsComponent,
    CompanyListComponent,
    CompanyUpdateComponent,
    IpoReviseComponent,
    StockpriceUploadComponent,
    FooterComponent,
    HeaderComponent,
    LoginComponent,
    ChartsComponent,
    DetailsComponent,
    HandleIpoComponent,
    ProfileUpdateComponent,
    ProfileComponent,
    SignUpComponent,
    StockexchangeListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [CompanyService, IpoDetailService, ProfileService, StockpriceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
