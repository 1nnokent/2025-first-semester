package com.mipt.hw8.validationThings;

import com.mipt.hw8.annotations.Email;
import com.mipt.hw8.annotations.NotNull;
import com.mipt.hw8.annotations.Range;
import com.mipt.hw8.annotations.Size;

public class TestSubject {
  @NotNull(message = "Email must not be null.")
  @Email(message = "Email must be correct.")
  private String email;

  @NotNull(message = "Age must not be null.")
  @Range(min = 18, max = 120, message = "A person must be either an adult or alive.")
  private int age;

  @NotNull(message = "Nickname must not be null")
  @Size(min = 3, max = 20, message = "Nickname should be between 3 and 20 characters long.")
  private String nickname;

  @NotNull(message = "We do not accept unemployed people here.")
  private String occupation;

  public TestSubject(String nickname, int age, String email, String occupation){
    this.nickname = nickname;
    this.age = age;
    this.email = email;
    this.occupation = occupation;
  }
}
