package com.proofit.premiumcalculator.calculators.premium;

import com.proofit.premiumcalculator.model.policy.Policy;

import java.math.BigDecimal;

public interface PremiumCalculator {

    BigDecimal calculate(Policy policy);

}
