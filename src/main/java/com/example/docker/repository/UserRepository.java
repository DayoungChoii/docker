package com.example.docker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final RedisTemplate<Long, Integer> template;

    @Autowired
    public UserRepository(RedisTemplate<Long, Integer> template) {
        this.template = template;
    }

    public void save(Long userId, Integer count) {
        template.opsForValue().set(userId, count);
    }

    public Integer findCount(Long userId){
        return template.opsForValue().get(userId);
    }
}
