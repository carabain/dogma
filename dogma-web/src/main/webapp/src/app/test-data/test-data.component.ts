import {Component, OnInit} from '@angular/core';
import {Contract} from '../shared/model/contract.model';
import {ContractsService} from '../shared/services/contracts.service';

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
    {field: 'smartcontractAdress', header: 'SmartContractAddress'}
  ];

  values = [];

  display = false;
  contracts: Contract[];

  selectedContract: Contract;

  constructor(private contractService: ContractsService) {
  }

  ngOnInit() {
    this.contractService.getContracts().subscribe(result => this.contracts = result);
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
