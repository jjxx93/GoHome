package cn.gohome.exception;

/**
 * Created by jiax on 2016/11/9.
 */
public class NotFaceException extends RuntimeException{
    public NotFaceException(String message) {
        super(message);
    }

    public NotFaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
