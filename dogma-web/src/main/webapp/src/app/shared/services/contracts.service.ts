import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import {environment} from '../../../environments/environment';
import {Contract} from '../model/contract.model';
import {UserService} from './user.service';

@Injectable()
export class ContractsService {

   httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin':  '*',
      'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
    })
  };

  contractsUrl = environment.restServiceUrl + 'registration';


  constructor(private http: HttpClient, private userService: UserService) {
  }

  getContracts(): Observable<Contract[]> {
    return this.http.get(this.contractsUrl + '/' + this.userService.username, this.httpOptions).map(result => <Contract[]>result);
  }

  deleteContract(contract: Contract) {
    return this.http.delete(this.contractsUrl + '/' + this.userService.username + '/' + contract.id, this.httpOptions);
  }

  saveContract(contract: Contract) {
    return this.http.post(this.contractsUrl, contract, this.httpOptions);
  }

}
