package com.example.springIntro.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogDTO {


    @JsonProperty(value = "blog_title", required = true, defaultValue = "A Title")
    private String title;

    @JsonProperty(value = "blog_content", required = true, defaultValue = "The Contents")
    private String content;

    @JsonProperty(value = "author_user_id")
    private Long authorUserId; // for legally user





    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;

    @JsonProperty(value = "updated_att")
    private LocalDateTime updatedAt;

//    @JsonProperty(namespace = "rating")
//    private Double rating;



}