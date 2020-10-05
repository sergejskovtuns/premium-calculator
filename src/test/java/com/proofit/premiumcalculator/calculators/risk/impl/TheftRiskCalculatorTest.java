package com.proofit.premiumcalculator.calculators.risk.impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class TheftRiskCalculatorTest {

    @Test
    void test_SumInsuredIsHigherThan15() {
        var sumInsured = BigDecimal.valueOf(100);
        var expectedResult = BigDecimal.valueOf(5);

        var result = TheftRiskCalculator.getInstance().calculate(sumInsured);

        assertThat(result)
                .as("check theft risk calculation for %s sum insured", sumInsured)
                .isEqualByComparingTo(expectedResult);
    }

    @Test
    void test_SumInsuredIsExactly15() {
        var sumInsured = BigDecimal.valueOf(15);
        var expectedResult = BigDecimal.valueOf(0.75);

        var result = TheftRiskCalculator.getInstance().calculate(sumInsured);

        assertThat(result)
                .as("check theft risk calculation for %s sum insured", sumInsured)
                .isEqualByComparingTo(expectedResult);
    }

    @Test
    void test_SumInsuredIsLowerThan15() {
        var sumInsured = BigDecimal.valueOf(10);
        var expectedResult = BigDecimal.valueOf(1.1);

        var result = TheftRiskCalculator.getInstance().calculate(sumInsured);

        assertThat(result)
                .as("check theft risk calculation for %s sum insured", sumInsured)
                .isEqualByComparingTo(expectedResult);
    }

}
