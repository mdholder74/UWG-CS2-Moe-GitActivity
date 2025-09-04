package edu.westga.cs1302.hi_lo_game.test.hi_lo_game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.hi_lo_game.model.HiLoGame;

class TestMakeGuess {

	@Test
	void testFirstGuessIsCorrect() {
		HiLoGame game = new HiLoGame(3);//Create object to test with input number 3
		
		String result = game.makeGuess(3);// Store the result of makeGuess inside of a variable result
		
		assertEquals(result, HiLoGame.CORRECT, "checking resulting text");// Check that the result is "Correct."
		assertEquals(game.getGuessCount(), 1, "checking guess count");// Check that the guess count is 1
	}

	 @Test
	  void testFirstGuessIsTooHigh() {
	    HiLoGame game = new HiLoGame(3);//Create object to test with input number 3
	    
	    String result = game.makeGuess(4);// Store the result of makeGuess inside of a variable result
	    
	    assertEquals(result, HiLoGame.TOO_HIGH, "checking resulting text");
	    assertEquals(game.getGuessCount(), 1, "checking guess count");
	  }
	 
	  @Test
	  void testFirstGuessIsTooLow() {
	    HiLoGame game = new HiLoGame(3);//Create object to test with input number 3
	    
	    String result = game.makeGuess(2);// Store the result of makeGuess inside of a variable result
	    
	    assertEquals(result, HiLoGame.TOO_LOW, "checking resulting text");
	    assertEquals(game.getGuessCount(), 1, "checking guess count");
	  }
	  
	  @Test
    void testLastGuessIsTooHigh() {
      HiLoGame game = new HiLoGame(3);//Create object to test with input number 4
      
      game.makeGuess(4);// Store the result of makeGuess inside of a variable result
      game.makeGuess(4);// Store the result of makeGuess inside of a variable result
      
      String result = game.makeGuess(4);
      
      assertEquals(result, HiLoGame.TOO_MANY_GUESSES, "checking resulting text");
      assertEquals(game.getGuessCount(), 3, "checking guess count");
    }
   
    @Test
    void testLastGuessIsTooLow() {
      HiLoGame game = new HiLoGame(3);//Create object to test with input number 3
      
      game.makeGuess(4);// Store the result of makeGuess inside of a variable result
      game.makeGuess(4);// Store the result of makeGuess inside of a variable result
      
      String result = game.makeGuess(2);// Store the result of makeGuess inside of a variable result
      
      assertEquals(result, HiLoGame.TOO_MANY_GUESSES, "checking resulting text");
      assertEquals(game.getGuessCount(), 3, "checking guess count");
    }
}
