package com.carabain.dogma.domain.oracle.domain;

import java.time.LocalDate;

public class DutchBrOracleFactory {

    private static DutchBrOracleFactory instance;

    private DutchBrOracleFactory() {
        super();
    }

    public static DutchBrOracleFactory getInstance() {
        if (instance == null) {
            instance = new DutchBrOracleFactory();
        }
        return instance;
    }

    public DutchBrOracle getDutchBrOracle() {
        BrOracleDb.getInstance().clear();

        BrOracle brOraclepersoon = new BrOracle();
        brOraclepersoon.setEndpoint("endpoint");
        brOraclepersoon.setDescription("Persoonsgegevens ModelA");
        brOraclepersoon.setId("PRSMODA");
        brOraclepersoon.setName("Persoongegevens");
        brOraclepersoon.setBasisRegistratie(BasisRegistratie.BAG);
        brOraclepersoon.setInfoType(ObjectType.PERSON);
        brOraclepersoon.addValue(new OracleContentValue("naam", "naam", DataType.STRING));
        brOraclepersoon.addValue(new OracleContentValue("achternaam", "achternaam", DataType.STRING));
        brOraclepersoon.addValue(new OracleContentValue("gebdat", "geboortedatum", DataType.DATE));
        brOraclepersoon.setCreationDate(LocalDate.now());
        BrOracleDb.getInstance().addBrOracle(brOraclepersoon);

        BrOracle brOraclepersoonAlive = new BrOracle();
        brOraclepersoonAlive.setEndpoint("endpoint");
        brOraclepersoonAlive.setDescription("Persoonsgegevens");
        brOraclepersoonAlive.setId("PRSMODB");
        brOraclepersoonAlive.setName("PersoongegevensAlive");
        brOraclepersoonAlive.setBasisRegistratie(BasisRegistratie.BAG);
        brOraclepersoonAlive.setInfoType(ObjectType.PERSON);
        brOraclepersoonAlive.addValue(new OracleContentValue("aliveid", "Is Person deceased or alive", DataType.BOOLEAN));
        brOraclepersoonAlive.setCreationDate(LocalDate.now());
        BrOracleDb.getInstance().addBrOracle(brOraclepersoonAlive);


        BrOracle brOracleinkomen = new BrOracle();
        brOracleinkomen.setEndpoint("endpoint");
        brOracleinkomen.setDescription("Basisinkomen van een Natuurlijk Persoon");
        brOracleinkomen.setId("BSINK");
        brOracleinkomen.setName("Basisinkomen");
        brOracleinkomen.setBasisRegistratie(BasisRegistratie.BRI);
        brOracleinkomen.setInfoType(ObjectType.INCOME);
        brOracleinkomen.addValue(new OracleContentValue("bsink", "basisinkomen van een natuurlijk persoon", DataType.LONG));
        brOracleinkomen.setCreationDate(LocalDate.now());
        BrOracleDb.getInstance().addBrOracle(brOracleinkomen);

        DutchBrOracle dutchBrOracle = new DutchBrOracle();
        dutchBrOracle.addBrOracle(ObjectType.PERSON, brOraclepersoonAlive);
        dutchBrOracle.addBrOracle(ObjectType.PERSON, brOraclepersoon);
        dutchBrOracle.addBrOracle(ObjectType.INCOME, brOracleinkomen);

        return dutchBrOracle;
    }
}
