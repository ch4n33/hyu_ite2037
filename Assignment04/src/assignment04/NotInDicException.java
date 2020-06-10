package assignment04;

public class NotInDicException extends Exception {
    NotInDicException(){
        super("this word not exist in dictionary");
    }
    NotInDicException(String message){
        super(message);
    }
}
