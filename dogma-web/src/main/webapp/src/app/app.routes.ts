import {Routes} from '@angular/router';
import {RegistrationComponent} from './registration/registration.component';
import {DiscoveryComponent} from './discovery/discovery.component';
import {OracleComponent} from './oracle/oracle.component';
import {TestDataComponent} from './test-data/test-data.component';
import {TestChainComponent} from './test-chain/test-chain.component';

export const ROUTES: Routes = [
  {path: 'registration', component: RegistrationComponent},
  {path: 'discovery', component: DiscoveryComponent},
  {path: 'oracle', component: OracleComponent},
  {path: 'testdata', component: TestDataComponent},
  {path: 'testchain', component: TestChainComponent},
  {path: '', redirectTo: '/registration', pathMatch: 'full'}
];
