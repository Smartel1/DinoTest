package ru.smartel.dinotest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.smartel.dinotest.dto.UserDTO;
import ru.smartel.dinotest.exception.UserNotFoundException;
import ru.smartel.dinotest.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> list() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO view (
            @PathVariable Long id
    ) throws UserNotFoundException {
        return userService.getOne(id);
    }

    @PostMapping
    public UserDTO create (
            @RequestBody @Validated UserDTO dto
    ) {
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    public UserDTO update (
            @PathVariable Long id,
            @RequestBody @Validated UserDTO dto
    ) throws UserNotFoundException {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete (
            @PathVariable Long id
    ) throws UserNotFoundException {
        userService.remove(id);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFound() {
    }
}
