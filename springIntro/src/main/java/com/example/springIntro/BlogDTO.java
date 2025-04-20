package com.example.springIntro;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BlogDTO {

    @JsonProperty(value = "blog_title", required = true)
    private String title;

    @JsonProperty(value = "blog_content", required = true)
    private String content;


    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("comments")
    private List<BlogCommentDTO> comments;
}
