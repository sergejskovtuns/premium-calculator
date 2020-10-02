package com.proofit.premiumcalculator.model.policy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Policy {

    private String policyNumber;

    private PolicyStatus status;

    private List<PolicyObject> policyObjects = new ArrayList<>();

    public Policy(Builder builder) {
        policyNumber = builder.policyNumber;
        status = builder.status;
        policyObjects = builder.policyObjects;
    }

    public Policy() {
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public PolicyStatus getStatus() {
        return status;
    }

    public void setStatus(PolicyStatus status) {
        this.status = status;
    }

    public List<PolicyObject> getPolicyObjects() {
        return policyObjects;
    }

    public void setPolicyObjects(List<PolicyObject> policyObjects) {
        this.policyObjects = policyObjects;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String policyNumber;
        private PolicyStatus status;
        private List<PolicyObject> policyObjects = new ArrayList<>();

        public Policy build() {
            return new Policy(this);
        }

        public Builder withPolicyNumber(String policyNumber) {
            this.policyNumber = policyNumber;
            return this;
        }

        public Builder withStatus(PolicyStatus status) {
            this.status = status;
            return this;
        }

        public Builder withPolicyObjects(List<PolicyObject> policyObjects) {
            this.policyObjects = policyObjects;
            return this;
        }

        public Builder withPolicyObject(PolicyObject policyObject) {
            this.policyObjects.add(policyObject);
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber) &&
                status == policy.status &&
                Objects.equals(policyObjects, policy.policyObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber, status, policyObjects);
    }
}
