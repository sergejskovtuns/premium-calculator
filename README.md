# Premium Calculator

Premium Calculator is a homework project where requirement is to create a calculator that calculates premium for given policy.


#### Prerequisites

 - Java 14
 
## Usage 

Use `PremiumCalculatorFactory` to retrieve `PremiumCalculator` for provided `Currency`.
> `Currency` is needed to set scale for BigDecimal used for currency operations. 
```java
    Currency currency = Currency.getInstance("EUR");
    PremiumCalculator premiumCalculator = PremiumCalculatorFactory.getPremiumCalculator(currency);
```

To calculate premium provide or build `Policy` object and use `PremiumCalculator#calculate(Policy policy)`.

```java
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
    BigDecimal premium = premiumCalculator.calculate(policy);
```

## Implementation

Overall calculation logic is following: 
1) Grouping all policy sub-objects by risk type
2) Summing the sum insured for grouped sub-objects
3) Applying coefficient based on risk type
4) Summing premiums from every risk type

In order to apply this logic calculation is split into two types: policy-based and risk-based calculation.

Policy-based calculation is handled by `PremiumCalculatior` which groups policy sub-objects by risk type, aggregates their sum insured, and applying risk-based logic on it.

Risk-based calculation is handled by `RiskCalculator` that applies a different coefficient based on a given sum insured. 

#### Adding new RiskCalculator

In order to add new `RiskCalculaor` following steps should be done:
1) Create new risk calculator class by implementing `RiskCalculator` interface
2) Add new risk type into `RiskType` enum
3) Add newly created risk calculator to `RiskCalculatorFactory`

> Adding new risk type into `RiskType` enum without adding risk calculator to the factory with trigger compile error.
This will ensure that `RiskCalculator` will be added as well. 
