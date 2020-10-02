package com.proofit.premiumcalculator;

import com.proofit.premiumcalculator.calculators.premium.PremiumCalculator;
import com.proofit.premiumcalculator.factory.PremiumCalculatorFactory;
import com.proofit.premiumcalculator.model.*;
import com.proofit.premiumcalculator.model.policy.Policy;
import com.proofit.premiumcalculator.model.policy.PolicyObject;
import com.proofit.premiumcalculator.model.policy.PolicyStatus;
import com.proofit.premiumcalculator.model.policy.PolicySubObject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PremiumCalculatorTest {

    private final PremiumCalculator premiumCalculator = PremiumCalculatorFactory
            .getPremiumCalculator(Currency.getInstance("EUR"));

    @Test
    public void test1() {

        Policy policy = Policy.builder()
                .withPolicyNumber("LV20-02-100000-5")
                .withStatus(PolicyStatus.APPROVED)
                .withPolicyObject(PolicyObject.builder()
                        .withObjectName("A House")
                        .withPolicySubObject(PolicySubObject.builder()
                                .withName("TV")
                                .withRiskType(RiskType.FIRE)
                                .withSumInsured(100.00)
                                .build())
                        .withPolicySubObject(PolicySubObject.builder()
                                .withName("TV")
                                .withRiskType(RiskType.THEFT)
                                .withSumInsured(8.00)
                                .build())
                        .build())
                .build();

        BigDecimal result = premiumCalculator.calculate(policy);

        assertEquals(BigDecimal.valueOf(2.28), result);
    }

    @Test
    public void test2() {

        Policy policy = Policy.builder()
                .withPolicyNumber("LV20-02-100000-5")
                .withStatus(PolicyStatus.APPROVED)
                .withPolicyObject(PolicyObject.builder()
                        .withObjectName("A House")
                        .withPolicySubObject(PolicySubObject.builder()
                                .withName("TV")
                                .withRiskType(RiskType.FIRE)
                                .withSumInsured(500.00)
                                .build())
                        .withPolicySubObject(PolicySubObject.builder()
                                .withName("TV")
                                .withRiskType(RiskType.THEFT)
                                .withSumInsured(102.51)
                                .build())
                        .build())
                .build();

        BigDecimal result = premiumCalculator.calculate(policy);

        assertEquals(BigDecimal.valueOf(17.13), result);
    }

}