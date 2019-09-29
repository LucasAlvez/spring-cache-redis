package com.example.cache.repository;

import com.example.cache.domain.User;
import com.example.cache.domain.UserKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<User, UserKey> {
}
