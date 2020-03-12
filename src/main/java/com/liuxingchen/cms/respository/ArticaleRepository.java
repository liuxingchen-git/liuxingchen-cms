package com.liuxingchen.cms.respository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.liuxingchen.cms.domain.Article;

public interface ArticaleRepository extends ElasticsearchRepository<Article, Integer>{

}
