package com.example.springIntro.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BlogCommentDTO {


    @JsonProperty("commentator_id")
    private Long commentator;

    @JsonProperty("blog_id")
    private Long blogId;


    @JsonProperty("content")
    private String content;
}