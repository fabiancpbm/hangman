package psweb.hangman;

public enum WordDictionary {
    EASY("Fácil", new String[]{"ARTE", "BOLA", "CARRO", "DADO", "EMA", "FACA"}),
    MEDIUM("Médio", new String[]{"AMADOR", "BASQUETE", "CUNHADO", "DIVISAO", "ESPERTO", "FELICIDADE"}),
    HARD("Difícil", new String[]{"ANTIGUIDADE", "BIBLIOTECA", "CAPACITÂNCIA", "DOUTRINAÇÃO", "ESSENCIAL",
            "FAMILIARIDADE"});

    String name;
    String[] words;

    WordDictionary(String name, String[] words) {
        this.name = name;
        this.words = words;
    }

    public static WordDictionary get(String name) {
        for (WordDictionary value : values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String[] getWords() {
        return words;
    }
}
