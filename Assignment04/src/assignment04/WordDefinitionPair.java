package assignment04;

public class WordDefinitionPair {
    private String word;
    private String definition;
    WordDefinitionPair(String word, String definition){
        this.definition = definition;
        this.word = word;
    }

    WordDefinitionPair(String word){
        this.word = word;
        this.definition = null;
    }
    public String getDefinition() { return definition; }
    public String getWord() { return word; }
    public void setDefinition(String definition) { this.definition = definition; }
    public void setWord(String word) { this.word = word; }
    public boolean equals(Object o){
        if (o == null) {
            return false;
        }if (o.getClass() != this.getClass()){
            System.out.println(o.getClass());
            return false;
        }
        WordDefinitionPair word = (WordDefinitionPair) o;
        return this.getWord().equals(word.getWord());
    }
}

