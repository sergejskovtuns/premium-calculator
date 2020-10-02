package com.proofit.premiumcalculator.calculators.risk.impl;

import com.proofit.premiumcalculator.calculators.risk.RiskCalculator;

import java.math.BigDecimal;

public class TheftRiskCalculator implements RiskCalculator {

    private static final BigDecimal DEFAULT_COEFFICIENT = BigDecimal.valueOf(0.11);
    private static final BigDecimal OVER_OR_EQUAL_15_COEFFICIENT = BigDecimal.valueOf(0.05);
    private static final BigDecimal DEFAULT_COEFFICIENT_LIMIT = BigDecimal.valueOf(15);

    private static RiskCalculator instance;

    private TheftRiskCalculator() {
    }

    public static RiskCalculator getInstance() {
        if (instance == null) {
            instance = new TheftRiskCalculator();
        }
        return instance;
    }

    public BigDecimal calculate(BigDecimal sumInsured) {
        BigDecimal coefficient = pickCoefficientBySumInsured(sumInsured);
        return sumInsured.multiply(coefficient);
    }

    private BigDecimal pickCoefficientBySumInsured(BigDecimal sumInsured) {
        return sumInsured.compareTo(DEFAULT_COEFFICIENT_LIMIT) >= 0
                ? OVER_OR_EQUAL_15_COEFFICIENT
                : DEFAULT_COEFFICIENT;
    }

}
