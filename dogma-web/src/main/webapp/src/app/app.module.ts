import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import { NavigationComponent } from './navigation/navigation.component';
import { RegistrationComponent } from './registration/registration.component';
import { DiscoveryComponent } from './discovery/discovery.component';
import { OracleComponent } from './oracle/oracle.component';
import { TestDataComponent } from './test-data/test-data.component';
import { TestChainComponent } from './test-chain/test-chain.component';
import {ROUTES} from './app.routes';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    RegistrationComponent,
    DiscoveryComponent,
    OracleComponent,
    TestDataComponent,
    TestChainComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
