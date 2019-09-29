package com.example.cache.service;

import com.example.cache.domain.User;
import com.example.cache.domain.UserKey;
import com.example.cache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    /**
     * User repository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Cache name.
     */
    private final String CACHE_NAME = "User";

    @Override
    @CacheEvict(cacheNames = CACHE_NAME, allEntries = true)
    public User create(final User user) {
        return this.userRepository.save(user);
    }

    @Override
    @CachePut(cacheNames = CACHE_NAME, key="#user.getCpf()")
    public User update(final User user) {
        return this.userRepository.save(user);
    }

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "#cpf")
    public User findById(final String cpf) {
        Optional<User> user = this.userRepository.findById(new UserKey(cpf));
        return user.get();
    }

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "#root.method.name")
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    @CacheEvict(cacheNames = CACHE_NAME, key="#cpf")
    public void delete(final String cpf) {
        this.userRepository.deleteById(new UserKey(cpf));
    }
}