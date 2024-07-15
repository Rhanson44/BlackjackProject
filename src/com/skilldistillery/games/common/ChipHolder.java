package com.skilldistillery.games.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChipHolder {
	
	public static void main(String[] args) {
		ChipHolder app = new ChipHolder();
		app.createChips(1000);
		app.adjustChips(-500);
		System.out.println(app.toString());
	}
	
    private List<Chip> chips;

    public ChipHolder() {
        this.chips = new ArrayList<>();
    }

    public void createChips(int amount) {
        chips.clear();
        int remainingAmount = amount;

        int[] denominations = { 500, 100, 25, 10, 5, 1 };
        Value[] values = { Value.PURPLE, Value.BLACK, Value.GREEN, Value.BLUE, Value.RED, Value.WHITE };

        for (int i = 0; i < denominations.length; i++) {
            int count = remainingAmount / denominations[i];
            remainingAmount %= denominations[i];
            for (int j = 0; j < count; j++) {
                chips.add(new Chip(values[i]));
            }
        }
    }

    public void replaceChips(int amount) {
        int remainingAmount = amount;

        int[] denominations = { 500, 100, 25, 10, 5, 1 };
        Value[] values = { Value.PURPLE, Value.BLACK, Value.GREEN, Value.BLUE, Value.RED, Value.WHITE };

        for (int i = 0; i < denominations.length; i++) {
            int denomination = denominations[i];
            Value value = values[i];

            while (remainingAmount >= denomination) {
                boolean removed = false;
                for (int j = chips.size() - 1; j >= 0; j--) {
                    Chip chip = chips.get(j);
                    if (chip.getValue() == value) {
                        chips.remove(j);
                        remainingAmount -= denomination;
                        removed = true;
                        break;
                    }
                }
                if (!removed) {
                    break;
                }
            }
        }
    }

    public void adjustChips(int amount) {
        if (amount > 0) {
            addChips(amount);
        } else if (amount < 0) {
            removeChips(amount);
        }
    }

    private void addChips(int amount) {
        int currentTotal = getTotalChipsValue();
        createChips(currentTotal + amount);
    }

    private void removeChips(int amount) {
        replaceChips(-amount);
    }
    
    public void resetChips(int initialAmount) {
        createChips(initialAmount);
    }

    @Override
    public String toString() {
        Map<Value, Integer> chipCounts = countChips();

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Value, Integer> entry : chipCounts.entrySet()) {
            sb.append("Chips: ").append(entry.getValue()).append(" ").append(entry.getKey()).append(", ");
        }
        if (!chips.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" total: ").append(getTotalChipsValue());
        return sb.toString();
    }

    private Map<Value, Integer> countChips() {
        Map<Value, Integer> chipCounts = new HashMap<>();
        for (Chip chip : chips) {
            Value value = chip.getValue();
            chipCounts.put(value, chipCounts.getOrDefault(value, 0) + 1);
        }
        return chipCounts;
    }

    public int getTotalChipsValue() {
        int totalValue = 0;
        for (Chip chip : chips) {
            totalValue += chip.getValue().getValue();
        }
        return totalValue;
    }
}
