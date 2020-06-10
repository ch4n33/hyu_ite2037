package assignment04;

public class EmptyException extends Exception {//this exception should be first-handled
    EmptyException(){
        super("List is empty");
    }
    EmptyException(String message){
        super(message);
    }
}
