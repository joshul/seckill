package org.seckill.exception;

/**
 * Created by joshul on 2017/2/8.
 */
public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
