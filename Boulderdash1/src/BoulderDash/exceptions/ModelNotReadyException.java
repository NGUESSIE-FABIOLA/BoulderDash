package BoulderDash.exceptions;


/**
 * ModelNotReadyException
 *
 * Raises an 'ModelNotReadyException' exception.
 * Given the exception message.
 *
 */
public class ModelNotReadyException extends Exception {
    /**
     * Class constructor
     *
     * @param  message  Exception backtrace message
     */
    public ModelNotReadyException(String message) {
        super(message);
    }
}
