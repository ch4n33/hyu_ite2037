package assignment04;

public interface Dictionary {
    boolean isEmpty();
    void insertEntry(String word, String definition) throws AlreadyExistsInDicException;
    void getDefinition(String word) throws EmptyException, NotInDicException;
    void removeWord(String word) throws EmptyException, NotInDicException;
    void printWord() throws EmptyException;
    void printAll() throws EmptyException;
}
