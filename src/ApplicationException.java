//The ApplicationException class is a custom checked exception in Java.
//It extends Exception, making it a checked exception
// — meaning it must be either caught or declared in a method's throws clause
class ApplicationException extends Exception {
    public ApplicationException(String message) {
        super(message);
    }
}