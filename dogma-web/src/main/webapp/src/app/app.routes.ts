import {Routes} from '@angular/router';
import {RegistrationComponent} from './registration/registration.component';
import {DiscoveryComponent} from './discovery/discovery.component';
import {TestDataComponent} from './test-data/test-data.component';

export const ROUTES: Routes = [
  {path: 'registration', component: RegistrationComponent},
  {path: 'discovery', component: DiscoveryComponent},
  {path: 'testdata', component: TestDataComponent},
  {path: '', redirectTo: '/registration', pathMatch: 'full'}
];
