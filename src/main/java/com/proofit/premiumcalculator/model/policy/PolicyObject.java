package com.proofit.premiumcalculator.model.policy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PolicyObject {

    private String objectName;
    private List<PolicySubObject> policySubObjects = new ArrayList<>();

    public PolicyObject(Builder builder) {
        this.objectName = builder.objectName;
        this.policySubObjects = builder.policySubObjects;
    }

    public PolicyObject() {
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<PolicySubObject> getPolicySubObjects() {
        return policySubObjects;
    }

    public void setPolicySubObjects(List<PolicySubObject> policySubObjects) {
        this.policySubObjects = policySubObjects;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String objectName;
        private List<PolicySubObject> policySubObjects = new ArrayList<>();

        public PolicyObject build() {
            return new PolicyObject(this);
        }

        public Builder withObjectName(String objectName) {
            this.objectName = objectName;
            return this;
        }

        public Builder withPolicySubObjects(List<PolicySubObject> policySubObjects) {
            this.policySubObjects = policySubObjects;
            return this;
        }

        public Builder withPolicySubObject(PolicySubObject policySubObject) {
            this.policySubObjects.add(policySubObject);
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolicyObject that = (PolicyObject) o;
        return Objects.equals(objectName, that.objectName) &&
                Objects.equals(policySubObjects, that.policySubObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectName, policySubObjects);
    }
}
