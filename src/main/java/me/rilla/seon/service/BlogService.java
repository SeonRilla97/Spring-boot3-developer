package me.rilla.seon.service;

import lombok.RequiredArgsConstructor;
import me.rilla.seon.dto.AddArticleRequest;
import me.rilla.seon.dto.ArticleResponse;
import me.rilla.seon.dto.UpdateArticleRequest;
import me.rilla.seon.model.Article;
import me.rilla.seon.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public ArticleResponse update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found : " + id));
        article.update(request.getTitle(),request.getContent());
        return new ArticleResponse(article);
    }
}
