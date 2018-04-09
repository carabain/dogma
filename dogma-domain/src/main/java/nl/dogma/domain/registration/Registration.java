package nl.dogma.domain.registration;

import java.util.ArrayList;
import java.util.List;

import nl.dogma.domain.oracle.domain.BrOracle;

public class Registration {

    private String id;

    private String userid;

    private String host;
    private String netwerkid;
    private String smartcontractAdress;

    private Object smartcontractAbi;
    private Object smartContractBin;

    private List<String> oracleIds = new ArrayList<>();
    private List<BrOracle> oracles = new ArrayList<>();

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BrOracle> getOracles() {
        return oracles;
    }

    public void setOracles(List<BrOracle> oracles) {
        this.oracles = oracles;
    }
}
