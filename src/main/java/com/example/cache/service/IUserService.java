package com.example.cache.service;

import com.example.cache.domain.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface IUserService {

    /**
     * Create user.
     *
     * @param user the user
     * @return the user
     */
    User create(final User user);

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    User update(final User user);

    /**
     * Find by id user.
     *
     * @param cpf the cpf
     * @return the user
     */
    User findById(final String cpf);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<User> findAll();

    /**
     * Delete.
     *
     * @param cpf the cpf
     */
    void delete(final String cpf);
}
