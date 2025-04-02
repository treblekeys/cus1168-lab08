package academy.javapro.lab08;

import java.util.HashMap;
import java.util.Map;

public class Premium {
    private double baseRate;
    private Map<String, Double> adjustments = new HashMap<>();
    private Map<String, String> explanations = new HashMap<>();

    public void addAdjustment(String reason, double amount, String explanation) {
        adjustments.put(reason, amount);
        explanations.put(reason, explanation);
    }

    public double calculateTotalPremium() {
        double total = baseRate;
        for (double adjustment : adjustments.values()) {
            total += adjustment;
        }
        return total;
    }

    public String getExplanation() {
        StringBuilder explanation = new StringBuilder();
        explanation.append("Base rate: $").append(String.format("%.2f", baseRate)).append("\n");

        for (String reason : adjustments.keySet()) {
            double amount = adjustments.get(reason);
            explanation.append(reason).append(": ");
            if (amount >= 0) {
                explanation.append("+");
            }
            explanation.append("$").append(String.format("%.2f", amount));
            explanation.append(" (").append(explanations.get(reason)).append(")\n");
        }

        explanation.append("Total premium: $")
                  .append(String.format("%.2f", calculateTotalPremium()));

        return explanation.toString();
    }

    public Premium() {
    }

    public Premium(double baseRate, Map<String, Double> adjustments, Map<String, String> explanations) {
        this.baseRate = baseRate;
        this.adjustments = adjustments;
        this.explanations = explanations;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    public Map<String, Double> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(Map<String, Double> adjustments) {
        this.adjustments = adjustments;
    }

    public Map<String, String> getExplanations() {
        return explanations;
    }

    public void setExplanations(Map<String, String> explanations) {
        this.explanations = explanations;
    }
}

