package com.semarslan.elasticsearch.repository;

import com.semarslan.elasticsearch.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {

    /**
     * Search with ElasticSearch query
     * @param search
     * @return
     */
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Person> getByCustomQuery(String search);

    /**
     * Search with Spring Boot format
     * @param name
     * @param lastname
     * @return
     */
    List<Person> findByNameLikeOrLastNameLike(String name, String lastname);
}
