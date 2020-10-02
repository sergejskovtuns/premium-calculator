package com.proofit.premiumcalculator.factory;

import com.proofit.premiumcalculator.calculators.premium.PremiumCalculator;
import com.proofit.premiumcalculator.calculators.premium.impl.SimplePremiumCalculator;

import java.util.Currency;

public class PremiumCalculatorFactory {

    public static PremiumCalculator getPremiumCalculator(Currency currency) {
        return new SimplePremiumCalculator(currency);
    }

}
