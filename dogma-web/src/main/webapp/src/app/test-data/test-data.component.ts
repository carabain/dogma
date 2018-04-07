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
    {field: 'host', header: 'Host'},
    {field: 'netwerkid', header: 'NetwerkId'},
    {field: 'smartContractAddress', header: 'SmartContractAddress'}
  ];

  values=[];

  display = false;
  contracts: Contract[];
  oracles: Oracle[];

  selectedContract: Contract;
  selectedOracles: Oracle[];

  constructor(private contractService: ContractsService, private oracleService: OracleService) {
  }

  ngOnInit() {
    this.contractService.getContracts().subscribe(result => this.contracts = result);
    this.oracleService.getOracles().subscribe(result => this.oracles = result);
  }

  edit(contract) {
    this.selectedContract = contract;
    this.selectedOracles = [];
    for (let i = 0; i < this.selectedContract.oracleids.length; i++) {
      const oracle = this.findOracle(this.selectedContract.oracleids[i]);
      this.selectedOracles.push(oracle)
    }
    this.display = true;
  }

  private findOracle(id): Oracle {
    for (let i = 0; i < this.oracles.length; i++) {
      if (this.oracles[i].id === id) {
        return this.oracles[i];
      }
    }
    return null;
  }

  submit(values) {
    console.log(values);
    this.display = false;
  }

}
