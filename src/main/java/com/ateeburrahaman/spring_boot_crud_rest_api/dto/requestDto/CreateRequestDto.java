package com.ateeburrahaman.spring_boot_crud_rest_api.dto.requestDto;

public class CreateRequestDto {
    private String name;
    private String email;
    private Integer rollNo;
    private String gender;
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
