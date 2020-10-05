package com.proofit.premiumcalculator.calculators.risk.impl;

import com.proofit.premiumcalculator.calculators.risk.RiskCalculator;

import java.math.BigDecimal;

public class FireRiskCalculator implements RiskCalculator {

    private static final BigDecimal DEFAULT_COEFFICIENT = BigDecimal.valueOf(0.014);
    private static final BigDecimal OVER_100_COEFFICIENT = BigDecimal.valueOf(0.024);
    private static final BigDecimal DEFAULT_COEFFICIENT_LIMIT = BigDecimal.valueOf(100);

    private static RiskCalculator instance;

    private FireRiskCalculator() {
    }

    public static RiskCalculator getInstance() {
        if (instance == null) {
            instance = new FireRiskCalculator();
        }
        return instance;
    }

    public BigDecimal calculate(BigDecimal sumInsured) {
        var coefficient = pickCoefficientBySumInsured(sumInsured);
        return sumInsured.multiply(coefficient);
    }

    private BigDecimal pickCoefficientBySumInsured(BigDecimal sumInsured) {
        return sumInsured.compareTo(DEFAULT_COEFFICIENT_LIMIT) > 0
                ? OVER_100_COEFFICIENT
                : DEFAULT_COEFFICIENT;
    }

}
