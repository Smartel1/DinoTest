package ru.smartel.dinotest.service;

import ru.smartel.dinotest.dto.UserDTO;
import ru.smartel.dinotest.exception.UserNotFoundException;

import java.util.List;

/**
 * Service for User
 */
public interface UserService {
    /**
     * Get all users
     * @return List<UserDTO> dtos
     */
    List<UserDTO> getAll();

    /**
     * Create user drom DTO
     * @param dto UserDTO data
     * @return UserDTO
     */
    UserDTO create(UserDTO dto);

    /**
     * Update existing user or throw
     * @param id Long identity
     * @param dto UserDTO data
     * @return UserDTO updated dto
     * @throws UserNotFoundException if user not found
     */
    UserDTO update(Long id, UserDTO dto) throws UserNotFoundException;

    /**
     * Get user by id
     * @param id Long identity
     * @return UserDTO user
     * @throws UserNotFoundException if user not found
     */
    UserDTO getOne(Long id) throws UserNotFoundException;

    /**
     * Remove user
     * @param id Long identity
     * @throws UserNotFoundException if user not found
     */
    void remove(Long id) throws UserNotFoundException;
}
