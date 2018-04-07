import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {MenuItem} from 'primeng/api';
import {DialogModule} from 'primeng/dialog';
import {TieredMenuModule} from 'primeng/primeng';
import {TableModule} from 'primeng/table';


import {AppComponent} from './app.component';
import {ROUTES} from './app.routes';
import {DiscoveryComponent} from './discovery/discovery.component';
import {LoginComponent} from './login/login.component';
import {NavigationComponent} from './navigation/navigation.component';
import {RegistrationComponent} from './registration/registration.component';
import {ContractsService} from './shared/services/contracts.service';
import {OracleService} from './shared/services/oracle.service';
import {UserGuard} from './shared/services/user.guard';
import {UserService} from './shared/services/user.service';
import {TestDataComponent} from './test-data/test-data.component';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    RegistrationComponent,
    DiscoveryComponent,
    TestDataComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ROUTES, {useHash: true}),
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    /* PrimeNg */
    TableModule,
    DialogModule,
    TieredMenuModule
  ],
  providers: [OracleService, ContractsService, UserService, UserGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
