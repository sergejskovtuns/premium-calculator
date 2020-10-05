package com.proofit.premiumcalculator.calculators.risk.impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class FireRiskCalculatorTest {

    @Test
    void test_SumInsuredIsHigherThan100() {
        var sumInsured = BigDecimal.valueOf(1000);
        var expectedResult = BigDecimal.valueOf(24);

        var result = FireRiskCalculator.getInstance().calculate(sumInsured);

        assertThat(result)
                .as("check fire risk calculation for %s sum insured", sumInsured)
                .isEqualByComparingTo(expectedResult);
    }

    @Test
    void test_SumInsuredIsExactly100() {
        var sumInsured = BigDecimal.valueOf(100);
        var expectedResult = BigDecimal.valueOf(1.4);

        var result = FireRiskCalculator.getInstance().calculate(sumInsured);

        assertThat(result)
                .as("check fire risk calculation for %s sum insured", sumInsured)
                .isEqualByComparingTo(expectedResult);
    }

    @Test
    void test_SumInsuredIsLowerThan100() {
        var sumInsured = BigDecimal.valueOf(10);
        var expectedResult = BigDecimal.valueOf(0.14);

        var result = FireRiskCalculator.getInstance().calculate(sumInsured);

        assertThat(result)
                .as("check fire risk calculation for %s sum insured", sumInsured)
                .isEqualByComparingTo(expectedResult);
    }

}
