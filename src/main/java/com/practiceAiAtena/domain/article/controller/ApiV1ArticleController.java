package com.practiceAiAtena.domain.article.controller;

import com.practiceAiAtena.domain.article.dto.*;
import com.practiceAiAtena.domain.article.entity.Article;
import com.practiceAiAtena.domain.article.service.ArticleService;
import com.practiceAiAtena.global.rsdata.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("")
    public RsData<WriteResponse> write(@Valid @RequestBody WriteRequest writeRequest){
        RsData<Article> writeRs = articleService.create(writeRequest.getTitle(),writeRequest.getContent());

        if (writeRs.isFail()) {
            return RsData.of(
                    writeRs.resultCode(),
                    writeRs.msg()
            );
        }

        return RsData.of(
                writeRs.resultCode(),
                writeRs.msg(),
                new WriteResponse(writeRs.data())
                );
    }

    @PatchMapping("/{id}")
    public RsData<ModifyResponse> modify(@Valid @RequestBody ModifyRequest modifyRequest, @PathVariable("id") Long id){
        Optional<Article> opArticle = articleService.findById(id);
        if(opArticle.isEmpty()){
            return RsData.of(
                    "F-1",
                    "%d번 게시물이 존재하지 않습니다.".formatted(id)
            );
        }
        RsData<Article> modifyRs = articleService.modify(opArticle.get(),modifyRequest.getTitle(),modifyRequest.getContent());
        return RsData.of(
                modifyRs.resultCode(),
                modifyRs.msg(),
                new ModifyResponse(modifyRs.data())
        );
    }

    @DeleteMapping("/{id")
    public RsData<DeleteResponse> delete(@PathVariable("id") Long id){
        Optional<Article> opArticle = articleService.findById(id);
        if(opArticle.isEmpty()){
            return RsData.of(
                    "F-1",
                    "%d번 게시물이 존재하지 않습니다.".formatted(id)
            );
        }
        RsData<Article> deleteRs = articleService.delete(id);
        return RsData.of(
                deleteRs.resultCode(),
                deleteRs.msg(),
                new DeleteResponse(opArticle.get())
        );
    }
}
