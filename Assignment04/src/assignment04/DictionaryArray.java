package assignment04;

import java.util.ArrayList;

public class DictionaryArray implements Dictionary {
    private ArrayList<WordDefinitionPair> DicList;

    DictionaryArray(){
        DicList = new ArrayList<WordDefinitionPair>();
    }

    public ArrayList<WordDefinitionPair> getDicList() {//copy and return to prevent privacy leak..?
        return new ArrayList<WordDefinitionPair>(DicList);
    }

    @Override public boolean isEmpty() {
        return DicList.isEmpty();
    }

    @Override public void getDefinition(String word) throws EmptyException, NotInDicException {
        if (isEmpty()) { throw new EmptyException(); }
        int index = DicList.indexOf(new WordDefinitionPair(word));
        if (index == -1){ throw new NotInDicException(); }
        System.out.println(DicList.get(index).getDefinition());
    }

    @Override public void insertEntry(String word, String definition) throws AlreadyExistsInDicException {
        WordDefinitionPair temp = new WordDefinitionPair(word, definition);
        if (DicList.contains(temp)){ throw new AlreadyExistsInDicException();}
        DicList.add(temp);
    }

    @Override public void removeWord(String word) throws EmptyException, NotInDicException {
        if (isEmpty()){ throw new EmptyException(); }
        int index = DicList.indexOf(new WordDefinitionPair(word));
        if (index == -1){ throw new NotInDicException(); }
        DicList.remove(index);
    }

    @Override public void printWord() throws EmptyException {
        if (isEmpty()) {throw new EmptyException(); }
        int i=1;
        for (WordDefinitionPair word:
                this.DicList) {
            System.out.println( i++ + ". " + word.getWord());
        }
    }

    @Override public void printAll() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        for (WordDefinitionPair word :
                this.DicList) {
            System.out.println("****************************************");
            System.out.println("word       : " + word.getWord());
            System.out.println("definition : " + word.getDefinition());
        }
    }
}
