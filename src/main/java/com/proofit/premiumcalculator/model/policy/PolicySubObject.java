package com.proofit.premiumcalculator.model.policy;

import com.proofit.premiumcalculator.model.RiskType;

import java.math.BigDecimal;
import java.util.Objects;

public class PolicySubObject {

    private String subObjectName;
    private BigDecimal sumInsured;
    private RiskType riskType;

    public PolicySubObject(Builder builder) {
        this.subObjectName = builder.subObjectName;
        this.sumInsured = builder.sumInsured;
        this.riskType = builder.riskType;
    }

    public PolicySubObject() {
    }

    public String getSubObjectName() {
        return subObjectName;
    }

    public void setSubObjectName(String subObjectName) {
        this.subObjectName = subObjectName;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String subObjectName;
        private BigDecimal sumInsured;
        private RiskType riskType;

        public PolicySubObject build() {
            return new PolicySubObject(this);
        }

        public Builder withName(String subObjectName) {
            this.subObjectName = subObjectName;
            return this;
        }

        public Builder withSumInsured(BigDecimal sumInsured) {
            this.sumInsured = sumInsured;
            return this;
        }

        public Builder withSumInsured(double sumInsured) {
            return withSumInsured(BigDecimal.valueOf(sumInsured));
        }

        public Builder withRiskType(RiskType riskType) {
            this.riskType = riskType;
            return this;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolicySubObject that = (PolicySubObject) o;
        return Objects.equals(subObjectName, that.subObjectName) &&
                Objects.equals(sumInsured, that.sumInsured) &&
                riskType == that.riskType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subObjectName, sumInsured, riskType);
    }
}
