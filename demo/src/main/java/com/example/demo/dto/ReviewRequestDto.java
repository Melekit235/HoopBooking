package com.example.demo.dto;

public class ReviewRequestDto {

    private Integer userId;
    private String text;

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

}
