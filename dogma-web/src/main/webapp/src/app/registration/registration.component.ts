import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  host;
  netwerkid;
  smartContractAddress;
  smartContractAbi;
  smartContractBin;

  constructor() { }

  ngOnInit() {
  }

  register(){
    console.log('register', this.host, this.netwerkid,this.smartContractAddress, this.smartContractAbi, this.smartContractBin);
  }

}
