import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {DialogModule} from 'primeng/dialog';
import {TableModule} from 'primeng/table';


import {AppComponent} from './app.component';
import {ROUTES} from './app.routes';
import {DiscoveryComponent} from './discovery/discovery.component';
import {NavigationComponent} from './navigation/navigation.component';
import {RegistrationComponent} from './registration/registration.component';
import {ContractsService} from './shared/services/contracts.service';
import {OracleService} from './shared/services/oracle.service';
import {TestDataComponent} from './test-data/test-data.component';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    RegistrationComponent,
    DiscoveryComponent,
    TestDataComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ROUTES),
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    /* PrimeNg */
    TableModule,
    DialogModule
  ],
  providers: [OracleService, ContractsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
