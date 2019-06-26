package psweb.hangman;

import com.sun.xml.internal.ws.client.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("session")
public class HangmanBean {

    //
    // Dados da Página
    //
    private Hangman hangman;

    private String letter;

    private String selectedLevel;

    private WordDictionary wordDictionary = WordDictionary.EASY;

    //
    // Construtor
    //
    public HangmanBean() {
        hangman = new Hangman();
        hangman.reset(wordDictionary);
    }

//    private void configLevel() {
//        wordDictionary = WordDictionary.get(selectedLevel);
//        reset();
//    }

//    public String[] getLevels() {
//        String[] levels = new String[WordDictionary.values().length];
//        int c = 0;
//        for (WordDictionary value : WordDictionary.values()) {
//            levels[c] = value.getName();
//            c++;
//        }
//        return levels;
//    }

    //
    // Operações da Página
    //
    public void guess() {
        char chr = letter.toCharArray()[0];
        if (!hangman.getInputHistory().contains(Character.toUpperCase(chr)) && Character.isLetter(chr)) {
            hangman.input(chr);
        }
        letter = "";
    }

    public void reset() {
        // Por enquanto, tornando a definição de nível aleatória.
        Random random = new Random();
        wordDictionary = WordDictionary.values()[random.nextInt(WordDictionary.values().length)];

        hangman.reset(wordDictionary);
    }

    public boolean isGameOver() {
        return hangman.isComplete() || hangman.getChances() == 0;
    }

    public boolean isGameWin() {
        return hangman.isComplete();
    }

    public boolean isGameLose() {
        return hangman.getChances() == 0;
    }

    public boolean get6() {
        return hangman.getChances() == 6;
    }

    public boolean get5() {
        return hangman.getChances() == 5;
    }

    public boolean get4() {
        return hangman.getChances() == 4;
    }

    public boolean get3() {
        return hangman.getChances() == 3;
    }

    public boolean get2() {
        return hangman.getChances() == 2;
    }

    public boolean get1() {
        return hangman.getChances() == 1;
    }

    public boolean hasLevel() {
        return selectedLevel != null;
    }

    //
    // Métodos de Acesso
    //
    public String getWord() {
        return hangman.getWordAsString();
    }

    public int getChances() {
        return hangman.getChances();
    }

    public String getAttempts() {
        return hangman.getInputHistory().toString();
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getSelectedLevel() {
        return selectedLevel;
    }

    public void setSelectedLevel(String selectedLevel) {
        this.selectedLevel = selectedLevel;
    }
}




















