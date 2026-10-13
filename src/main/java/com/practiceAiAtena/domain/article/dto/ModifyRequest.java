package com.practiceAiAtena.domain.article.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ModifyRequest {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
}
