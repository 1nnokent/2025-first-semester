package com.mipt.hw8;

import com.mipt.classeshw7.CustomArrayList;
import com.mipt.hw8.annotations.NotNull;
import com.mipt.hw8.validationThings.TestSubject;
import com.mipt.hw8.validationThings.ValidationResult;
import com.mipt.hw8.validationThings.Validator;
import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class ValidationTester {

  TestSubject obj;

  @BeforeEach
  public void setup () {
    obj = null;
  }

  @Test
  public void SuccessfulValidation () {
    obj = new TestSubject("abeba", 19, "ya@gmail.com", "st.street");
    ValidationResult result = Validator.validate(obj);
    assertTrue(result.isValid());
  }

  @Test
  public void NicknameTooShort () {
    obj = new TestSubject("ab", 19, "ya@gmail.com", "st.street");
    ValidationResult result = Validator.validate(obj);
    assertTrue(result.hasError("Nickname should be between 3 and 20 characters long."));
  }

  @Test
  public void NicknameTooLong () {
    obj = new TestSubject("ab".repeat(20), 19, "ya@gmail.com", "st.street");
    ValidationResult result = Validator.validate(obj);
    assertTrue(result.hasError("Nickname should be between 3 and 20 characters long."));
  }

  @Test
  public void NicknameExactly20CharactersLong () {
    obj = new TestSubject("ab".repeat(10), 19, "ya@gmail.com", "st.street");
    ValidationResult result = Validator.validate(obj);
    assertTrue(result.isValid());
  }

  @Test
  public void NicknameExactly3CharactersLong () {
    obj = new TestSubject("aba", 19, "ya@gmail.com", "st.street");
    ValidationResult result = Validator.validate(obj);
    assertTrue(result.isValid());
  }

  @Test
  public void IncorrectEmail () {
    obj = new TestSubject("ab", 19, "ya@gmailcom", "st.street");
    ValidationResult result = Validator.validate(obj);
    assertTrue(result.hasError("Email must be correct."));
  }

  @Test
  public void NullOccupation () {
    obj = new TestSubject("ab", 19, "ya@gmailcom", null);
    ValidationResult result = Validator.validate(obj);
    assertTrue(result.hasError("We do not accept unemployed people here."));
  }

  @Test
  public void TooYoung () {
    obj = new TestSubject("ab", 12, "ya@gmailcom", null);
    ValidationResult result = Validator.validate(obj);
    assertTrue(result.hasError("A person must be either an adult or alive."));
  }

  @Test
  public void TooOld () {
    obj = new TestSubject("ab", 121, "ya@gmailcom", null);
    ValidationResult result = Validator.validate(obj);
    assertTrue(result.hasError("A person must be either an adult or alive."));
  }
}
