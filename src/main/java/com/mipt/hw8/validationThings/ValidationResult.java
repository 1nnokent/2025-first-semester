package com.mipt.hw8.validationThings;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
  private boolean isValid;
  private List<String> errors;

  public ValidationResult () {
    this.isValid = true;
    this.errors = new ArrayList<>();
  }

  public boolean isValid() {
    return isValid;
  }

  public List<String> getErrors() {
    return errors;
  }

  public void addError(String error) {
    errors.add(error);
    isValid = false;
  }

  public boolean hasError(String error) {
    for (String curError : errors) {
      if (curError.equals(error)){
        return true;
      }
    }
    return false;
  }
}
