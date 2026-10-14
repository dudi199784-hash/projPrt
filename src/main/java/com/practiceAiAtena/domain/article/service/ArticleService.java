package com.practiceAiAtena.domain.article.service;

import com.practiceAiAtena.domain.article.entity.Article;
import com.practiceAiAtena.domain.article.repository.ArticleRepository;
import com.practiceAiAtena.global.rsdata.RsData;
import jakarta.transaction.Transactional;
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

    @Transactional
    public RsData<Article> create(String title, String content) {
        Article article  = Article.builder()
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article);
        return RsData.of("S-2","작성 성공",article);
    }

    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    public RsData<Article> modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
        articleRepository.save(article);
        return RsData.of(
                "S-3",
                "%d번 게시물이 수정되었습니다.".formatted(article.getId()),
                article
        );
    }

    public RsData<Article> delete(Long id) {
        articleRepository.deleteById(id);
        return RsData.of(
                "S-4",
                "%d번 게시물이 삭제되었습니다.".formatted(id)
        );
    }
}
