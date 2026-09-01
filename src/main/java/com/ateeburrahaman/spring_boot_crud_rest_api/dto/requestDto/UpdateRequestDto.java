package com.ateeburrahaman.spring_boot_crud_rest_api.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UpdateRequestDto {
    @NotBlank(message = "Name Must Not Be Empty or Only Spaces or Null")
    private String name;
    @NotNull(message = "Roll Number Must Not Be Null")
    @Positive(message = "Roll No must be greater than 0")
    private Integer rollNo;
    @NotBlank(message = "Gender Must Not Be Empty or Only Spaces or Null")
    private String gender;
    @NotBlank(message = "Branch Must Not Be Empty or Only Spaces or Null")
    private String branch;


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
}
