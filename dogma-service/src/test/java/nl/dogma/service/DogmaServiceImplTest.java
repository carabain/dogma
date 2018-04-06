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
        brOracle.addValue(new OracleContentValue("basisink", "BasisInkomen", DataType.LONG));
        brOracle.setCreationDate(LocalDate.now());

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(brOracle);

        System.out.println(jsonInString);
        //JSON from file to Object
        //Staff obj = mapper.readValue(new File("c:\\file.json"), Staff.class);

        //JSON from URL to Object
        //Staff obj = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), Staff.class);

        //JSON from String to Object
        //Staff obj = mapper.readValue(jsonInString, Staff.class);

        Assert.assertTrue(true);
    }
}
