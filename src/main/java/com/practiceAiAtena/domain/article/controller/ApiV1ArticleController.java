package com.practiceAiAtena.domain.article.controller;

import com.practiceAiAtena.domain.article.dto.ArticleResponse;
import com.practiceAiAtena.domain.article.dto.ArticlesResponse;
import com.practiceAiAtena.domain.article.entity.Article;
import com.practiceAiAtena.domain.article.service.ArticleService;
import com.practiceAiAtena.global.rsdata.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping //--- 다건 조회
    public RsData<ArticlesResponse> getArticles(){
        List<Article> articles = articleService.getList();
        return RsData.of("S-1","성공",new ArticlesResponse(articles));
    }

    @GetMapping("/{id}")  //--- 단건 조회
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id){
        return articleService.getArticle(id).map(article -> RsData.of(
                "S-1",
                "성공",
                new ArticleResponse(article)
        )).orElseGet(()-> RsData.of(
                "F-1",
                "%d번 게시물은 존재하지않습니다.".formatted(id),
                null
        ));
    }
}
