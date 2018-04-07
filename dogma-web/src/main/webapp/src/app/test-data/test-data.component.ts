import {Component, OnInit} from '@angular/core';
import {Contract} from '../shared/model/contract.model';
import {Oracle} from '../shared/model/oracle.model';
import {ContractsService} from '../shared/services/contracts.service';
import {OracleService} from '../shared/services/oracle.service';

@Component({
  selector: 'app-test-data',
  templateUrl: './test-data.component.html',
  styleUrls: ['./test-data.component.css']
})
export class TestDataComponent implements OnInit {

  cols = [
    {field: 'id', header: '#'},
    {field: 'description', header: 'Description'},
    {field: 'host', header: 'Host'},
    {field: 'netwerkid', header: 'NetwerkId'},
    {field: 'smartContractAddress', header: 'SmartContractAddress'}
  ];

  values = [];

  display = false;
  contracts: Contract[];
  oracles: Oracle[];

  selectedContract: Contract;

  constructor(private contractService: ContractsService, private oracleService: OracleService) {
  }

  ngOnInit() {
    this.contractService.getContracts().subscribe(result => this.contracts = result);
    this.oracleService.getOracles().subscribe(result => this.oracles = result);
  }

  edit(contract) {
    this.selectedContract = contract;
    this.display = true;
  }

  submit() {
    console.log(this.selectedContract);
    this.display = false;
  }

}
