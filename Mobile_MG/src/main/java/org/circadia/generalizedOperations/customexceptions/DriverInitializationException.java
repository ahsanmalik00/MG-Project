package org.circadia.generalizedOperations.customexceptions;

public class DriverInitializationException extends FrameworkException {
  public DriverInitializationException(String message) {
    super(message);
  }

  public DriverInitializationException(String message, Throwable t) {
    super(message, t);
  }
}