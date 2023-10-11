

/**
 * Exception when same book is reissues
 */
public class IllegalBookIssueException extends Exception {
	 public IllegalBookIssueException(String errorMessage) {
	        super(errorMessage);}
}
