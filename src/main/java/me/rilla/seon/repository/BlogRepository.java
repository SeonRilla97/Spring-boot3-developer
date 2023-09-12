package me.rilla.seon.repository;

import me.rilla.seon.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {

}
