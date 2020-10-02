package com.proofit.premiumcalculator.calculators.risk;

import java.math.BigDecimal;

public interface RiskCalculator {

    BigDecimal calculate(BigDecimal sumInsured);

}
