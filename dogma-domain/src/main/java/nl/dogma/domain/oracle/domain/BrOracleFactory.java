package nl.dogma.domain.oracle.domain;

public class BrOracleFactory {

    private BrOracleFactory() {
        super();
    }

    private static BrOracleFactory instance;

    public static BrOracleFactory getInstance() {
        if (instance == null) {
            instance = new BrOracleFactory();
        }
        return instance;
    }
    
    public BrOracle createBrOracle(String oracleId) {
        final BrOracle oracleTemplate = BrOracleDb.getInstance().getOracle(oracleId);

        BrOracle newOracle = new BrOracle();
        newOracle.setEndpoint(oracleTemplate.getEndpoint());
        newOracle.setDescription(oracleTemplate.getDescription());
        newOracle.setId(oracleTemplate.getId());
        newOracle.setName(oracleTemplate.getName());
        newOracle.setBasisRegistratie(oracleTemplate.getBasisRegistratie());
        newOracle.setInfoType(oracleTemplate.getInfoType());
        for (OracleContentValue val : oracleTemplate.getValues()) {
            newOracle.addValue(new OracleContentValue(val.getId(), val.getDescription(), val.getDatatype()));
        }
        newOracle.setCreationDate(oracleTemplate.getCreationDate());

        return newOracle;
    }
}
