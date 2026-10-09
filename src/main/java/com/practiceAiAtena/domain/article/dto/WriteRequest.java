package com.practiceAiAtena.domain.article.dto;

import com.practiceAiAtena.domain.article.entity.Article;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class WriteRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
