package com.practiceAiAtena.domain.article.repository;

import com.practiceAiAtena.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long> {
}
