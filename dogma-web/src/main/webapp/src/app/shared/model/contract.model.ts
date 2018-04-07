import {Oracle} from './oracle.model';

export class Contract {
  id: string;
  userid: string;
  description: string;
  host: string;
  netwerkid: string;
  smartcontractAdress: string;
  smartcontractAbi: string;
  smartContractBin: string;
  oracleIds?: string[] = [];
  oracles?: Oracle[] = [];
}
