package assignment04;

public class AlreadyExistsInDicException extends Exception {
    AlreadyExistsInDicException(){
        super("this word already exist in dictionary");
    }
    AlreadyExistsInDicException(String message){
        super(message);
    }
}
