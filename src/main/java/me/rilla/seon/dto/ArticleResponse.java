package me.rilla.seon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.rilla.seon.model.Article;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
