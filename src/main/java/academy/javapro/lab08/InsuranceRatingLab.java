package academy.javapro.lab08;

public class InsuranceRatingLab {
        public static void main(String[] args) {
        // Create the rating engine
        InsuranceRatingEngine engine = new InsuranceRatingEngine();

        // Create some sample driver profiles
        DriverProfile youngDriver = new DriverProfile(19, 1, "Student", 0, 0,
                                                    "Honda", "Civic", 2020, false, false, false,
                                                    50, 500, 500, false, false);

        DriverProfile experiencedDriver = new DriverProfile(45, 25, "Engineer", 0, 0,
                                                         "Toyota", "Camry", 2018, false, true, false,
                                                         100, 500, 500, false, false);

        DriverProfile seniorWithAccident = new DriverProfile(70, 50, "Retired", 1, 0,
                                                           "Lexus", "ES", 2019, true, true, true,
                                                           100, 250, 250, true, true);

        DriverProfile riskySportsCarDriver = new DriverProfile(22, 4, "Student", 2, 1,
                                                             "Ford", "Mustang", 2022, false, false, false,
                                                             30, 1000, 1000, false, false);

        // Calculate and display premiums
        calculateAndDisplayPremium("Young Driver", engine, youngDriver);
        calculateAndDisplayPremium("Experienced Driver", engine, experiencedDriver);
        calculateAndDisplayPremium("Senior with Accident", engine, seniorWithAccident);
        calculateAndDisplayPremium("Risky Sports Car Driver", engine, riskySportsCarDriver);
    }

    private static void calculateAndDisplayPremium(String description, InsuranceRatingEngine engine, DriverProfile profile) {
        System.out.println("\n=== " + description + " ===");
        System.out.println("Age: " + profile.getAge());
        System.out.println("Vehicle: " + profile.getVehicleYear() + " " + profile.getVehicleMake() + " " + profile.getVehicleModel());
        System.out.println("Accidents: " + profile.getAccidentsInLastFiveYears());

        Premium premium = engine.calculatePremium(profile);

        System.out.println("\nPremium Calculation:");
        System.out.println(premium.getExplanation());
        System.out.println("------------------------------");
    }
}
