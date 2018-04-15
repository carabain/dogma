package com.carabain.dogma.web;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import com.carabain.dogma.domain.oracle.domain.BasisRegistratie;
import com.carabain.dogma.domain.oracle.domain.BrOracle;
import com.carabain.dogma.domain.oracle.domain.DataType;
import com.carabain.dogma.domain.oracle.domain.DutchBrOracle;
import com.carabain.dogma.domain.oracle.domain.ObjectType;
import com.carabain.dogma.domain.oracle.domain.OracleContentValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Unittests for {@link DogmaServiceImpl}.
 */
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
