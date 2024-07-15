package com.skilldistillery.games.blackjack;

import com.skilldistillery.games.common.Card;
import com.skilldistillery.games.common.ChipHolder;

public class Player {
    
    private BlackjackHand hand;
    private ChipHolder chipHolder;
    
    public Player() {
        this.hand = new BlackjackHand();
    }
    
    public Player(ChipHolder chipHolder) {
        this.hand = new BlackjackHand();
        this.chipHolder = chipHolder;
    }
    
    public void getChips(int amount) {
        chipHolder.createChips(amount);
    }
    
    public void placeBet(int amount) {
        int availableChips = chipHolder.getTotalChipsValue();
        if (amount <= availableChips) {
            chipHolder.adjustChips(-amount);
            System.out.println("Bet placed: " + amount);
        } else {
            System.out.println("Insufficient chips. Placing maximum bet instead.");
            chipHolder.adjustChips(-availableChips);
        }
    }
    
    public void adjustChips(int amount) {
        chipHolder.adjustChips(amount);
    }
    
    public void resetChips(int intialAmount) {
    	chipHolder.resetChips(intialAmount);
    }
    
    public int getChipsValue() {
    	return chipHolder.getTotalChipsValue();
    }
    public boolean isBlackjack() {
        return hand.isBlackjack();
    }
    
    public boolean isBust() {
        return hand.isBust();
    }
    
    public void drawBlackjackCard(Card card) {
        hand.drawCard(card);
    }
        
    public boolean isAce() {
        return hand.isAce();
    }
    
    public Card drawAce(int value) {
        return hand.drawAce(value);
    }
    
    public Card replaceAce(int index, int value) {
        return hand.replaceAce(index, value);
    }
    
    public boolean hasSoftAce() {
        return hand.hasSoftAce();
    }
    
    public int getBlackjackHandValue() {
        return hand.getHandValue();
    }
    
    public String getFirstBlackjackCardValue() {
        return hand.getFirstCardValue();
    }
    
    public String displayHand() {
        return "Hand: " + hand.toString() + " " + hand.getHandValue();
    }
    
    public String displayChips() {
        return "Chips: " + chipHolder.toString();
    }
    
    public void clearHand() {
        hand.clear();
    }
    
    public void bustAdjustChips(int betAmount) {
        chipHolder.adjustChips(-betAmount);
    }
    
    public void dealerBustAdjustChips(int betAmount) {
        chipHolder.adjustChips(betAmount);
    }
}
