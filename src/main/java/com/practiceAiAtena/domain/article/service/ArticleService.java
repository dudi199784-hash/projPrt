package com.practiceAiAtena.domain.article.service;

import com.practiceAiAtena.domain.article.entity.Article;
import com.practiceAiAtena.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    //--- 다건 조회
    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticle(Long id) {
        return articleRepository.findById(id);
    }

    public void create(String title, String content) {
        Article article  = Article.builder()
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article);
    }

}
