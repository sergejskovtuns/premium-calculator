package com.proofit.premiumcalculator;

import com.proofit.premiumcalculator.calculators.premium.PremiumCalculator;
import com.proofit.premiumcalculator.factory.PremiumCalculatorFactory;
import com.proofit.premiumcalculator.model.RiskType;
import com.proofit.premiumcalculator.model.policy.Policy;
import com.proofit.premiumcalculator.model.policy.PolicyObject;
import com.proofit.premiumcalculator.model.policy.PolicyStatus;
import com.proofit.premiumcalculator.model.policy.PolicySubObject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;

class PremiumCalculatorTest {

    private final PremiumCalculator premiumCalculator = PremiumCalculatorFactory
            .getPremiumCalculator(Currency.getInstance("EUR"));

    @Test
    public void test_100Fire8TheftPolicy() {

        var policy = Policy.builder()
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

        var result = premiumCalculator.calculate(policy);
        var expectedResult = new BigDecimal("2.28");

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void test_500Fire102_51TheftPolicy() {

        var policy = Policy.builder()
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

        var result = premiumCalculator.calculate(policy);
        var expectedResult = new BigDecimal("17.13");

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void test_PremiumForEmptyPolicyShouldReturnZero() {

        var policy = Policy.builder().build();

        var result = premiumCalculator.calculate(policy);
        var expectedResult = new BigDecimal("0.00");

        assertThat(result)
                .as("check that for empty policy we have zero premium")
                .isEqualTo(expectedResult);
    }

}
