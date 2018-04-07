package nl.dogma.domain.oracle.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrOracleDb {

    private static BrOracleDb instance;

    private Map<String, BrOracle> oracles = new HashMap<>();

    public static BrOracleDb getInstance() {
        if (instance == null) {
            instance = new BrOracleDb();
        }
        return instance;
    }

    public void addBrOracle(BrOracle oracle) {
        BrOracle brOracle = oracles.get(oracle.getId());
        if (brOracle == null) {
            oracles.put(oracle.getId(), brOracle);
        }
    }

    public BrOracle getOracle(String oracleid) {
        return oracles.get(oracleid);
    }
}
