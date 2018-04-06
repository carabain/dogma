package nl.dogma.domain.registration;

import java.util.ArrayList;
import java.util.List;

public class Registration {

    private String userid;
    private String host;
    private String netwerkid;
    private String smartcontractAdress;

    private Object smartcontractAbi;
    private Object smartContractBin;

    private List<String> oracleIds = new ArrayList<String>();

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getNetwerkid() {
        return netwerkid;
    }

    public void setNetwerkid(String netwerkid) {
        this.netwerkid = netwerkid;
    }

    public String getSmartcontractAdress() {
        return smartcontractAdress;
    }

    public void setSmartcontractAdress(String smartcontractAdress) {
        this.smartcontractAdress = smartcontractAdress;
    }

    public Object getSmartcontractAbi() {
        return smartcontractAbi;
    }

    public void setSmartcontractAbi(Object smartcontractAbi) {
        this.smartcontractAbi = smartcontractAbi;
    }

    public Object getSmartContractBin() {
        return smartContractBin;
    }

    public void setSmartContractBin(Object smartContractBin) {
        this.smartContractBin = smartContractBin;
    }

    public List<String> getOracleIds() {
        return oracleIds;
    }

    public void setOracleIds(List<String> oracleIds) {
        this.oracleIds = oracleIds;
    }
}
