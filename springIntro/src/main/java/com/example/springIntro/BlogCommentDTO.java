package com.example.springIntro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BlogCommentDTO {


    @JsonProperty("viewer_name")
    private String viewer;

    @JsonProperty("content")
    private String content;
}