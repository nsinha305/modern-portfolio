package com.portfolio.exception;

/**
 * Created by nesinha on 7/28/16.
 * Custom exception class to be thrown if inputs provided to Portfolio or Simulator object are not valid.
 */
public class InputValidationException extends Exception {

    public InputValidationException(String message) {
        super(message);
    }
}
