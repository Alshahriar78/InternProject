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





}
