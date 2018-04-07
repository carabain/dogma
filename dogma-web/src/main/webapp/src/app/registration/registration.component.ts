import {Component, OnInit} from '@angular/core';
import {Contract} from '../shared/model/contract.model';
import {Oracle} from '../shared/model/oracle.model';
import {ContractsService} from '../shared/services/contracts.service';
import {OracleService} from '../shared/services/oracle.service';
import {UserService} from '../shared/services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  contract = new Contract();

  oracles: Oracle[];
  indexes: { id: string, checked: boolean }[] = [];
  checkall: false;

  constructor(private contractsService: ContractsService, private oracleService: OracleService, private userService: UserService) {
  }

  ngOnInit() {
    this.oracleService.getOracles().subscribe(result => {
      this.oracles = result;
      for (let i = 0; i < this.oracles.length; i++) {
        this.indexes[i] = {id: this.oracles[i].id, checked: false};
      }
    });
  }

  register() {
    console.log('register', this.contract);
    for (let i = 0; i < this.oracles.length; i++) {
      if (this.indexes[i].checked) {
        this.contract.oracleids.push(this.indexes[i].id);
      }
    }
    this.contract.user = this.userService.username;
    this.contractsService.saveContract(this.contract).subscribe();
  }

  checkAll() {
    for (let i = 0; i < this.oracles.length; i++) {
      this.indexes[i].checked = !this.checkall;
    }
  }

}
