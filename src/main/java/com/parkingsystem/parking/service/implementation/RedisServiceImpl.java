package com.parkingsystem.parking.service.implementation;


import com.parkingsystem.parking.service.abstraction.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisServiceImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public void addAvailableSlot(String key , Long slotId){
        redisTemplate.opsForSet().add(key,slotId);
    }

    public Long getAvailableSlot(String key){
        Object slot = redisTemplate.opsForSet().pop(key);

        if (slot == null){
            return null;
        }
        return (Long) slot;
    }

    public void releaseSlot(String key, Long slotId){
        redisTemplate.opsForSet().add(key,slotId);
    }
}
