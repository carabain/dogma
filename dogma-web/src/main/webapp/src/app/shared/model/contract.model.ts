import {Oracle} from './oracle.model';

export class Contract {
  id: string;
  user: string;
  description: string;
  host: string;
  netwerkid: string;
  smartContractAddress: string;
  smartContractAbi: string;
  smartContractBin: string;
  oracleids?: string[] = [];
  oracles?: Oracle[] = [];
}
