package org.circadia.generalizedOperations.customexceptions;

public class InvalidPathException extends FrameworkException {

  public InvalidPathException(String message) {
    super(message);
  }

  public InvalidPathException(String message, Throwable t) {
    super(message, t);
  }
}