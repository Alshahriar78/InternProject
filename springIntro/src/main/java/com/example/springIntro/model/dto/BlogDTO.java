package com.example.springIntro.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogDTO {


    @JsonProperty(namespace = "blog_title", required = true, defaultValue = "A Title")
    private String title;

    @JsonProperty(namespace = "blog_content", value = "Content's of the blog.", required = true, defaultValue = "The Contents")
    private String content;

    @JsonProperty(namespace = "author_user_id")
    private Long authorUserId; // for legally user



    // client theke nibo na eta
    @JsonProperty(namespace = "id")
    private Long id;

    @JsonProperty(namespace = "created_at")
    private LocalDateTime createdAt;

    @JsonProperty(namespace = "updated_att")
    private LocalDateTime updatedAt;

//    @JsonProperty(namespace = "rating")
//    private Double rating;



}