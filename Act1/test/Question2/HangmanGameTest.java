package Question2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HangmanGameTest {

    private HangmanGame game;

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() {
        game = new HangmanGame();
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testInitialState() {
        assertNotNull(game.getWordToGuess());
        assertEquals(game.getWordToGuess().length(), game.getWordProgress().length());
        assertEquals(6, game.getAttemptsLeft());
        assertTrue(game.getWordProgress().contains("_"));
    }

    @Test
    public void testCorrectGuess() {
        String wordToGuess = game.getWordToGuess();
        char correctLetter = wordToGuess.charAt(0);
        game.guessLetter(correctLetter);
        assertTrue(game.getWordProgress().contains(String.valueOf(correctLetter)));
        assertEquals(6, game.getAttemptsLeft());
    }

    @Test
    public void testIncorrectGuess() {
        char incorrectLetter = 'z';
        game.guessLetter(incorrectLetter);
        assertTrue(game.getIncorrectGuesses().contains(String.valueOf(incorrectLetter)));
        assertEquals(5, game.getAttemptsLeft());
    }

    @Test
    public void testWinCondition() {
        String wordToGuess = game.getWordToGuess();
        for (char c : wordToGuess.toCharArray()) {
            game.guessLetter(c);
        }
        assertTrue(game.isGameWon());
        assertTrue(game.isGameOver());
    }

    @Test
    public void testLoseCondition() {
        HangmanGame testGame = new HangmanGame();
        testGame.guessLetter('x');
        testGame.guessLetter('y');
        testGame.guessLetter('z');
        testGame.guessLetter('a');
        testGame.guessLetter('b');
        testGame.guessLetter('c');
        assertFalse(testGame.isGameWon());
        assertTrue(testGame.isGameOver());
    }

    /**
     * Test of guessLetter method, of class HangmanGame.
     */
    @Test
    public void testGuessLetter() {
        System.out.println("guessLetter");
        char guess = ' ';
        HangmanGame instance = new HangmanGame();
        boolean expResult = false;
        boolean result = instance.guessLetter(guess);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isGameWon method, of class HangmanGame.
     */
    @Test
    public void testIsGameWon() {
        System.out.println("isGameWon");
        HangmanGame instance = new HangmanGame();
        boolean expResult = false;
        boolean result = instance.isGameWon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isGameOver method, of class HangmanGame.
     */
    @Test
    public void testIsGameOver() {
        System.out.println("isGameOver");
        HangmanGame instance = new HangmanGame();
        boolean expResult = false;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWordProgress method, of class HangmanGame.
     */
    @Test
    public void testGetWordProgress() {
        System.out.println("getWordProgress");
        HangmanGame instance = new HangmanGame();
        String expResult = "";
        String result = instance.getWordProgress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAttemptsLeft method, of class HangmanGame.
     */
    @Test
    public void testGetAttemptsLeft() {
        System.out.println("getAttemptsLeft");
        HangmanGame instance = new HangmanGame();
        int expResult = 0;
        int result = instance.getAttemptsLeft();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIncorrectGuesses method, of class HangmanGame.
     */
    @Test
    public void testGetIncorrectGuesses() {
        System.out.println("getIncorrectGuesses");
        HangmanGame instance = new HangmanGame();
        String expResult = "";
        String result = instance.getIncorrectGuesses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWordToGuess method, of class HangmanGame.
     */
    @Test
    public void testGetWordToGuess() {
        System.out.println("getWordToGuess");
        HangmanGame instance = new HangmanGame();
        String expResult = "";
        String result = instance.getWordToGuess();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
