package psweb.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman 
{
	private int chances = 6;
	private Word currentWord;
	private List<Character> history;
	
	public Hangman()
	{
		history = new ArrayList<Character>();
	}
	
	// Sorteia uma nova palavra
	public void reset(WordDictionary wordDictionary)
	{
		// Dentro de um nível específico, sorteando uma palavra.
		Random random = new Random();
		String w = wordDictionary.getWords()[random.nextInt(wordDictionary.words.length)];
		currentWord = new Word(w); // TODO - Buscar de um dicionario
		history.clear();
		chances = 6;
	}
	
	public void reset(String forcedWord)
	{
		currentWord = new Word(forcedWord);
		history.clear();
		chances = 6;
	}
	
	// Faz input de um caractere
	public boolean input(char chr)
	{
		boolean match = currentWord.input(chr);				
		
		// Atualiza o contador de vidas
		if (!match)
			chances--;
		
		// Atualiza o histórico
		history.add(Character.toUpperCase(chr));
		
		return match;
	}
	
	public boolean isComplete()
	{
		return currentWord.isComplete();
	}	
	
	//
	// Métodos de acesso
	//
	public int getChances() {
		return chances;
	}
	
	public String getWordAsString() {
		return currentWord.getWordAsString();
	}
	
	public String getAnswerAsString() {
		return currentWord.getAnswerAsString();
	}
	
	public List<Character> getInputHistory() {
		return history;
	}
}
