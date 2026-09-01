package com.ateeburrahaman.spring_boot_crud_rest_api.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateRequestDto {
    @NotBlank(message = "Name Must Not Be Empty or Only Spaces or Null")
    private String name;
    @Email(message = "Please Enter Correct Email")
    @NotBlank(message = "Email Must Not Be Empty or Only Spaces or Null")
    private String email;
    @NotNull(message = "Roll Number Must Not Be Null")
    private Integer rollNo;
    @NotBlank(message = "Gender Must Not Be Empty or Only Spaces or Null")
    private String gender;
    @NotBlank(message = "Branch Must Not Be Empty or Only Spaces or Null")
    private String branch;

    public CreateRequestDto(String name, String email, Integer rollNo, String branch, String gender) {
        this.name = name;
        this.email = email;
        this.rollNo = rollNo;
        this.branch = branch;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
