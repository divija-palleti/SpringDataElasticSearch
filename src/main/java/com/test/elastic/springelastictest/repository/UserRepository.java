package com.test.elastic.springelastictest.repository;

import com.test.elastic.springelastictest.model.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<Users, String> {
    List<Users> findByName(String name);
}
