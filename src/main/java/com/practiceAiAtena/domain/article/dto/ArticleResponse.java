package com.practiceAiAtena.domain.article.dto;

import com.practiceAiAtena.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleResponse {
    private final Article article;
}
