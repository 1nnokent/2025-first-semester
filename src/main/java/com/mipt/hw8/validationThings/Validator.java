package com.mipt.hw8.validationThings;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import com.mipt.hw8.annotations.*;
import java.util.regex.Pattern;

public class Validator {

  private static void validateNotNull(Object object, Field field, ValidationResult result) {
    field.setAccessible(true);
    try {
      if (field.isAnnotationPresent(NotNull.class)) {
        if (field.get(object) == null) {
          result.addError(field.getAnnotation(NotNull.class).message());
        }
      }
    } catch (IllegalAccessException e) { }
  }

  private static void validateSize(Object object, Field field, ValidationResult result) {
    field.setAccessible(true);
    try {
      if (field.isAnnotationPresent(Size.class)) {
        if (field.get(object) == null) {
          result.addError("An object's field must not be null.");
        } else if (!(field.get(object) instanceof String)) {
          result.addError("An object must be an instance of the String class.");
        } else {
          int stringSize = ((String) field.get(object)).length();
          Size annotation = field.getAnnotation(Size.class);
          if (stringSize < annotation.min() || stringSize > annotation.max()) {
            result.addError(annotation.message());
          }
        }
      }
    } catch (IllegalAccessException e) { }
  }

  private static void validateRange(Object object, Field field, ValidationResult result) {
    field.setAccessible(true);
    try {
      if (field.isAnnotationPresent(Range.class)) {
        if (field.get(object) == null) {
          result.addError("An object's field must not be null.");
        } else if (!(field.get(object) instanceof Number)) {
          result.addError("An object must be an instance of the Number class.");
        } else {
          Range annotation = field.getAnnotation(Range.class);
          if (((Integer) field.get(object)).longValue() < annotation.min()
              || ((Integer) field.get(object)).longValue() > annotation.max()) {
            result.addError(annotation.message());
          }
        }
      }
    } catch (IllegalAccessException e) { }
  }

  private static void validateEmail(Object object, Field field, ValidationResult result) {
    final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    field.setAccessible(true);
    try {
      if (field.isAnnotationPresent(Email.class)) {
        if (field.get(object) == null) {
          result.addError("An object's field must not be null.");
        } else if (!(field.get(object) instanceof String)) {
          result.addError("An object must be an instance of the String class.");
        } else {
          Email annotation = field.getAnnotation(Email.class);
          if (!Pattern.compile(EMAIL_REGEX).matcher((String) field.get(object)).matches()) {
            result.addError(annotation.message());
          }
        }
      }
    } catch (IllegalAccessException e) { }
  }


  public static ValidationResult validate(Object object) {
    ValidationResult result = new ValidationResult();

    if (object == null) {
      result.addError("An object must not be null.");
      return result;
    }

    for (Field field : object.getClass().getDeclaredFields()) {
      validateNotNull(object, field, result);
      validateSize(object, field, result);
      validateRange(object, field, result);
      validateEmail(object, field, result);
    }

    return result;
  }
}
