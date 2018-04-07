import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Rx';

import {environment} from '../../../environments/environment';
import {Oracle} from '../model/oracle.model';

@Injectable()
export class OracleService {

  httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
    })
  };

  oraclesUrl = environment.restServiceUrl + 'oracles';

  constructor(private http: HttpClient) {
  }

  getOracles(): Observable<Oracle[]> {
    return this.http.get(this.oraclesUrl, this.httpOptions).map(result => <Oracle[]>result);
  }

  insertOracle(oracle: Oracle) {
    return this.http.post(this.oraclesUrl, oracle, this.httpOptions);
  }

}
