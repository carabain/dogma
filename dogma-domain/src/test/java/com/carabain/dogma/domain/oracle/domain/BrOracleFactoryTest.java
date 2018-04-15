package com.carabain.dogma.domain.oracle.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unittests for {@link BrOracleFactory}.
 */
public class BrOracleFactoryTest {

    @Test
    public void indienTemplatePRSMODABeschikbaarDanMoetFactoryTemplateImageCreeeren() {
        // given
        DutchBrOracleFactory.getInstance().getDutchBrOracle();

        // when
        final BrOracle prsmoda = BrOracleFactory.getInstance().createBrOracle("PRSMODA");

        // then
        Assert.assertEquals(3, prsmoda.getValues().size());
    }

    @Test
    public void indienTemplateBSINKBeschikbaarDanMoetFactoryTemplateImageCreeeren() {
        // given
        DutchBrOracleFactory.getInstance().getDutchBrOracle();

        // when
        final BrOracle prsmoda = BrOracleFactory.getInstance().createBrOracle("BSINK");

        // then
        Assert.assertEquals(1, prsmoda.getValues().size());
    }

}
