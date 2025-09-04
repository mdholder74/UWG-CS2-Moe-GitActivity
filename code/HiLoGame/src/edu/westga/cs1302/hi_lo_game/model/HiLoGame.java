package edu.westga.cs1302.hi_lo_game.model;

/** Manages game state and generates action responses for a HiLoGame
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class HiLoGame {
	public static final String TOO_MANY_GUESSES = "Too many guesses.";
  public static final String TOO_LOW = "Too low.";
  public static final String TOO_HIGH = "Too high.";
  public static final String CORRECT = "Correct.";
  private int guessCount;
	private int targetNumber;
	
	/** Initialize a new HiLoGame
	 * 
	 * @precondition none
	 * @postcondition getGuessCount() == 0 && getTargetNumber() == targetNumber
	 * 
	 * @param targetNumber the number to guess
	 */
	public HiLoGame(int targetNumber) {
		this.guessCount = 0;
		this.targetNumber = targetNumber;
	}
	
	/** Get the number of guesses made so far
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of guesses made so far
	 */
	public int getGuessCount() {
		return this.guessCount;
	}

	/** Get the number to guess
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number to guess
	 */
	public int getTargetNumber() {
		return this.targetNumber;
	}
	
	/** Allow player to make a guess, and generate the appropriate response
	 * 
	 * @precondition none
	 * @postcondition guess count will be updated
	 * 
	 * @param guess the number guessed by the player
	 * 
	 * @return 	"Correct."  		if guess == getTargetNumber()
	 * 			"Too low."  		if guess < getTargetNumber()
	 * 			"Too high." 		if guess == getTargetNumber()
	 * 			"Too many guesses." if getGuessCount() > 3
	 */
	public String makeGuess(int guess) {
		String result = null;
		this.guessCount++;
		if (this.guessCount >= 3) {
			result = TOO_MANY_GUESSES;
		} else if (guess < this.targetNumber) {
			result = TOO_LOW;
		} else if (guess > this.targetNumber) {
			result = TOO_HIGH;
		} else {
			result = CORRECT;
		}
		return result;
	}
}
