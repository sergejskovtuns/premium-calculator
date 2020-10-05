package com.proofit.premiumcalculator.calculators.premium.impl;

import com.proofit.premiumcalculator.calculators.premium.PremiumCalculator;
import com.proofit.premiumcalculator.factory.RiskCalculatorFactory;
import com.proofit.premiumcalculator.model.RiskType;
import com.proofit.premiumcalculator.model.policy.Policy;
import com.proofit.premiumcalculator.model.policy.PolicySubObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Map;
import java.util.stream.Collectors;

public class SimplePremiumCalculator implements PremiumCalculator {

    private final Currency currency;

    public SimplePremiumCalculator(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal calculate(Policy policy) {
        var sumInsuredGroupedByRiskType = groupByRiskTypeAndReduceSumInsured(policy);

        return sumInsuredGroupedByRiskType.entrySet().stream()
                .map(entry -> calculatePremiumForRiskType(entry.getKey(), entry.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(currency.getDefaultFractionDigits(), RoundingMode.HALF_UP);
    }

    private Map<RiskType, BigDecimal> groupByRiskTypeAndReduceSumInsured(Policy policy) {
        return policy.getPolicyObjects().stream()
                .flatMap(po -> po.getPolicySubObjects().stream())
                .collect(Collectors.groupingBy(PolicySubObject::getRiskType,
                                Collectors.reducing(BigDecimal.ZERO, PolicySubObject::getSumInsured, BigDecimal::add)));

    }

    private BigDecimal calculatePremiumForRiskType(RiskType riskType, BigDecimal sumInsured) {
        return RiskCalculatorFactory.getRiskCalculator(riskType).calculate(sumInsured);
    }

}
