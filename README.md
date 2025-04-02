# Lab: Insurance Rating Engine Lab

### Learning Objectives

* Implement logic rules using Java's functional interfaces
* Apply logic programming concepts in an object-oriented language
* Develop decision-making components for risk assessment
* Create code that explains its reasoning process
* Understand how declarative programming simplifies complex business logic

#### Prerequisites

* Basic understanding of Java syntax and object-oriented programming
* Familiarity with functional interfaces (`Predicate`, `Consumer`)
* Knowledge of collections (`Map`, `List`)
* Understanding of basic insurance concepts
* Experience with conditional statements and control flow

#### Task Description

In this lab, you will implement key components of a rule-based insurance rating engine. The system calculates insurance
premiums based on driver and vehicle characteristics using a knowledge base of insurance rates and a set of rules.
You'll implement specific rules for vehicle classification, age-based risk assessment, and accident history.

#### Detailed Requirements

1. Implement the `determineVehicleCategory` method that:
    * Takes a `DriverProfile` object as input
    * Returns a string categorizing the vehicle as "sedan", "suv", "luxury", or "sports"
    * Uses the vehicle make and model to determine its category

2. Implement the "age factor" rule that:
    * Applies to all driver profiles
    * Adjusts the premium based on the driver's age using factors from the knowledge base
    * Includes appropriate explanations for the adjustments

3. Implement the "accident history" rule that:
    * Only applies to drivers with one or more accidents
    * Adds surcharges based on the number of accidents
    * Includes explanations for why the surcharges are applied

#### Technical Requirements

* Your implementation must handle edge cases appropriately
* Rules must include both condition (when they apply) and action (what they do)
* Each premium adjustment must include an explanation
* Your code must use Java's functional interfaces as shown in the template
* The system should produce correct premium calculations for all test cases

#### Base Rate Rule

In the `InsuranceRatingEngine`, we define a base rate rule that applies a base insurance rate depending on the category of the vehicle.

```java
rules.add(new Rule("base rate",
    profile -> true, // Predicate that always returns true
    (profile, premium) -> {
        // Determine vehicle category from profile
        String vehicleCategory = determineVehicleCategory(profile);
        
        // Get base rate from knowledgeBase
        double baseRate = (double) knowledgeBase.get("baseRate." + vehicleCategory);
        
        // Set base rate in premium
        premium.setBaseRate(baseRate);
    }
));
```

#### How It Works:

- **Predicate**: Always returns `true`, meaning this rule applies to all profiles.

- BiConsumer Logic:
  - Retrieves the vehicle category based on the driver's profile. 
  - Fetches the base rate from the `knowledgeBase` using the vehicle category. 
  - Updates the `premium` object with the base rate.

This rule ensures that each vehicle is assigned an appropriate starting insurance rate before additional factors (age, accident history, etc.) are applied.

#### Project Setup

- Open the project in your IDE
- Locate the starter code in the following files:
    * `DriverProfile.java`: Contains driver and vehicle information
    * `Premium.java`: Stores premium calculation results
    * `InsuranceRatingEngine.java`: Contains the rule engine (you'll modify this)
    * `InsuranceRatingLab.java`: Main class for testing your implementation
- Complete the TODOs in the `InsuranceRatingEngine.java` file
- Do not modify the package structure or class name

#### Testing Your Implementation

Test your implementation with the following driver profiles:

* Young Driver: 19-year-old student with a Honda Civic, no accidents
* Experienced Driver: 45-year-old engineer with a Toyota Camry, no accidents
* Senior with Accident: 70-year-old retiree with a Lexus ES, one accident
* Risky Sports Car Driver: 22-year-old student with a Ford Mustang, two accidents

#### Expected Output

When running your program, it should produce output similar to:

```
=== Young Driver ===
Age: 19
Vehicle: 2020 Honda Civic
Accidents: 0
Premium Calculation:
Base rate: $1000.00
Age factor: +$1000.00 (Drivers under 20 have higher statistical risk)
Total premium: $2000.00
------------------------------

=== Experienced Driver ===
Age: 45
Vehicle: 2018 Toyota Camry
Accidents: 0
Premium Calculation:
Base rate: $1000.00
Total premium: $1000.00
------------------------------

=== Senior with Accident ===
Age: 70
Vehicle: 2019 Lexus ES
Accidents: 1
Premium Calculation:
Base rate: $1500.00
Age factor: +$450.00 (Slight increase for senior drivers)
Accident history: +$300.00 (Surcharge for 1 accident in past 5 years)
Total premium: $2250.00
------------------------------

=== Risky Sports Car Driver ===
Age: 22
Vehicle: 2022 Ford Mustang
Accidents: 2
Premium Calculation:
Base rate: $1800.00
Age factor: +$900.00 (Drivers 20-24 have moderately higher risk)
Accident history: +$600.00 (Major surcharge for 2+ accidents in past 5 years)
Total premium: $3300.00
------------------------------
```