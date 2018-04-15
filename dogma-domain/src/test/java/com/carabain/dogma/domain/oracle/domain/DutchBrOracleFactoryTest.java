package com.carabain.dogma.domain.oracle.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Unittests for {@link DutchBrOracleFactory}.
 */
public class DutchBrOracleFactoryTest {

    @Test
    public void indienDutchBrOracleFactoryAangeroepenDanReturnOracles() {
        // given when
        DutchBrOracle dutchBrOracle = DutchBrOracleFactory.getInstance().getDutchBrOracle();
        List<BrOracle> oracles = dutchBrOracle.getOracles();

        // then
        Assert.assertTrue(oracles.size() > 0);
    }
}
