import {Routes} from '@angular/router';
import {DiscoveryComponent} from './discovery/discovery.component';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {UserGuard} from './shared/services/user.guard';
import {TestDataComponent} from './test-data/test-data.component';

export const ROUTES: Routes = [
  {path: 'registration', component: RegistrationComponent, canActivate: [UserGuard]},
  {path: 'discovery', component: DiscoveryComponent},
  {path: 'testdata', component: TestDataComponent, canActivate: [UserGuard]},
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: '/discovery', pathMatch: 'full'}
];
