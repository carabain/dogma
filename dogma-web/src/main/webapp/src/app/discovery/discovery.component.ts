import { Component, OnInit } from '@angular/core';
import {Oracle} from '../shared/model/oracle.model';
import {OracleService} from '../shared/services/oracle.service';

@Component({
  selector: 'app-discovery',
  templateUrl: './discovery.component.html',
  styleUrls: ['./discovery.component.css']
})
export class DiscoveryComponent implements OnInit {

  cols = [
    { field: 'id', header: '#' },
    { field: 'name', header: 'Name' },
    { field: 'description', header: 'Description' },
    { field: 'url', header: 'Url' },
    { field: 'infoType', header: 'InfoType' },
    { field: 'basisRegistratie', header: 'BasisRegistratie' },
    { field: 'values', header: 'Values' },
  ];

  oracles: Oracle[];

  constructor(private oracleService: OracleService) {
  }

  ngOnInit() {
      this.oracleService.getOracles().subscribe(result => this.oracles = result);
  }

}
