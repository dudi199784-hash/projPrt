package com.practiceAiAtena.domain.article.dto;

import com.practiceAiAtena.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArticlesResponse {
    private final List<Article> articles;
}
