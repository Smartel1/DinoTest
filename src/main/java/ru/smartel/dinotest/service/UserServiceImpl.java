package ru.smartel.dinotest.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.smartel.dinotest.dto.UserDTO;
import ru.smartel.dinotest.entity.User;
import ru.smartel.dinotest.exception.UserNotFoundException;
import ru.smartel.dinotest.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO create(UserDTO dto) {
        User user = new User();
        fillEntity(user, dto);

        userRepository.save(user);

        return new UserDTO(user);
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        fillEntity(user, dto);
        userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public UserDTO getOne(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return new UserDTO(user);
    }

    @Override
    public void remove(Long id) throws UserNotFoundException {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new UserNotFoundException();
        }
    }

    private void fillEntity(User user, UserDTO dto) {
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setAddress(dto.getAddress());
        user.setBirthdate(dto.getBirthdate());
    }
}
