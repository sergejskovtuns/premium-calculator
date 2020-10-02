package com.proofit.premiumcalculator.factory;

import com.proofit.premiumcalculator.calculators.risk.impl.FireRiskCalculator;
import com.proofit.premiumcalculator.calculators.risk.RiskCalculator;
import com.proofit.premiumcalculator.calculators.risk.impl.TheftRiskCalculator;
import com.proofit.premiumcalculator.model.RiskType;

public class RiskCalculatorFactory {

    public static RiskCalculator getRiskCalculator(RiskType riskType) {
        return switch (riskType) {
            case FIRE -> FireRiskCalculator.getInstance();
            case THEFT -> TheftRiskCalculator.getInstance();
        };
    }

}
