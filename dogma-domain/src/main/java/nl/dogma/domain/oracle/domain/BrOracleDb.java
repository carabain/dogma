package nl.dogma.domain.oracle.domain;

import java.util.HashMap;
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
        oracles.put(oracle.getId(), oracle);
    }

    public BrOracle getOracle(String oracleid) {
        return oracles.get(oracleid);
    }

    public void clear() {
        oracles.clear();
    }
}
