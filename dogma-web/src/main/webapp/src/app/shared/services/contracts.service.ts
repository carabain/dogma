import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import {environment} from '../../../environments/environment';
import {Contract} from '../model/contract.model';
import {UserService} from './user.service';

@Injectable()
export class ContractsService {

  contractsUrl = environment.restServiceUrl + 'registration';


  constructor(private http: HttpClient, private userService: UserService) {
  }

  getContracts(): Observable<Contract[]> {
    return this.http.get(this.contractsUrl + 's/' + this.userService.username).map(result => <Contract[]>result);
  }

  saveContract(contract: Contract) {
    return this.http.post(this.contractsUrl, contract);
  }

}
