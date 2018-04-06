import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import "rxjs/add/operator/map";

import {environment} from '../../../environments/environment';
import {Oracle} from '../model/oracle.model';

@Injectable()
export class OracleService {

  oraclesUrl = environment.restServiceUrl + 'oracles';

  constructor(private http: HttpClient) {
  }

  getOracles(): Observable<Oracle[]> {
    return this.http.get(this.oraclesUrl).map(result => <Oracle[]>result);
  }

  insertOracle(oracle: Oracle) {
    return this.http.post(this.oraclesUrl, oracle);
  }

}
