package Question2;

import java.util.Random;

public class HangmanGame {

    private static String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon",
"mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tomato", "ugli", "vanilla",
"watermelon", "xigua", "yam", "zucchini", "apricot", "blueberry", "cantaloupe", "dragonfruit", "eggplant", "fennel",
"grapefruit", "huckleberry", "jellybean", "kumquat", "lime", "melon", "nutmeg", "olive", "peach", "plum",
"pear", "pineapple", "pomegranate", "rhubarb", "soursop", "tangerine", "ugli", "valerian", "wasabi", "xylocarp",
"yellowfruit", "zinnia", "almond", "basil", "carrot", "dandelion", "eucalyptus", "fig", "ginger", "honey",
"iris", "jalapeno", "kiwifruit", "lemon", "mushroom", "nectar", "onion", "parsley", "quinoa", "rhubarb",
"spinach", "thyme", "umbrella", "violet", "wheat", "xanadu", "yarrow", "zucchini", "artichoke", "beet",
"celery", "daikon", "endive", "fennel", "ginger", "horseradish", "iceberg", "jicama", "kale", "lupine"
};
    private String wordToGuess;
    private char[] wordProgress;
    private int attemptsLeft;
    private StringBuilder incorrectGuesses;
    
    public HangmanGame() {
        this.wordToGuess = getRandomWord();
        this.wordProgress = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            wordProgress[i] = '_';
        }
        this.attemptsLeft = 6;
        this.incorrectGuesses = new StringBuilder();
    }

    private static String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }

    public boolean guessLetter(char guess) {
        if (wordToGuess.indexOf(guess) >= 0) {
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    wordProgress[i] = guess;
                }
            }
            return true;
        } else {
            incorrectGuesses.append(guess).append(" ");
            attemptsLeft--;
            return false;
        }
    }

    public boolean isGameWon() {
        return String.valueOf(wordProgress).equals(wordToGuess);
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0 || isGameWon();
    }

    public String getWordProgress() {
        return new String(wordProgress);
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getIncorrectGuesses() {
        return incorrectGuesses.toString();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }
}
