package nl.dogma.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.dogma.domain.oracle.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DogmaServiceImplTest {


    @Test
    public void indienObjectDanJsonFormaat() throws JsonProcessingException {
        BrOracle brOracle = new BrOracle();
        brOracle.setBasisRegistratie(BasisRegistratie.BAG);
        brOracle.setInfoType(ObjectType.PERSON);
        brOracle.addValue(new OracleContentValue("naam", "naam", DataType.STRING));
        brOracle.addValue(new OracleContentValue("naam", "naam", DataType.STRING));
        brOracle.setCreationDate(LocalDate.now());


        DutchBrOracle dutchBrOracle = new DutchBrOracle();
        dutchBrOracle.addBrOracle(ObjectType.INCOME, brOracle);


        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(dutchBrOracle);

        Assert.assertTrue(jsonInString.contains("BAG"));
    }
}
