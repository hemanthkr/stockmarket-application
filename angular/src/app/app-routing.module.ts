import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AdminComponent } from './admin/admin/admin.component';
import { StockpriceUploadComponent } from './admin/stockprice-upload/stockprice-upload.component';
import { RegisterCompanyComponent } from './admin/register-company/register-company.component';
import { CompanyUpdateComponent } from './admin/company-update/company-update.component';
import { AddStockexchangeComponent } from './admin/add-stockexchange/add-stockexchange.component';
import { CompanyListComponent } from './admin/company-list/company-list.component';
import { IpoReviseComponent } from './admin/ipo-revise/ipo-revise.component';
import { ProfileComponent } from './profile/profile/profile.component';
import { DetailsComponent } from './profile/details/details.component';
import { ProfileUpdateComponent } from './profile/profile-update/profile-update.component';
import { HandleIpoComponent } from './profile/handle-ipo/handle-ipo.component';
import { StockexchangeListComponent } from './admin/stockexchange-list/stockexchange-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'sign-up', component: SignUpComponent },
  {
    path: 'admin', component: AdminComponent,
    children: [
      { path: '', component: StockpriceUploadComponent },
      { path: 'stockprice-upload', component: StockpriceUploadComponent },
      { path: 'register-company', component: RegisterCompanyComponent },
      { path: 'company-update/:id', component: CompanyUpdateComponent },
      { path: 'add-stockexchange', component: AddStockexchangeComponent },
      { path: 'company-list', component: CompanyListComponent },
      { path: 'ipo-revise', component: IpoReviseComponent },
      { path: 'list-stockexchange', component: StockexchangeListComponent }
    ]
  },
  {
    path: 'profile', component: ProfileComponent,
    children: [
      { path: '', component: DetailsComponent },
      { path: 'details', component: DetailsComponent},
      { path: 'profile-update', component: ProfileUpdateComponent},
      { path: 'handle-ipo', component: HandleIpoComponent},
      { path: 'details', component: DetailsComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
