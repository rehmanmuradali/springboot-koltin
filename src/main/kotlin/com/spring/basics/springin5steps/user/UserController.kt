package com.spring.basics.springin5steps.user

import com.spring.basics.springin5steps.user.exception.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
class UserController {

    @Autowired
    private lateinit var userDaoService: UserDaoService

    @GetMapping("/users")
    fun retrieveAllUsers(): List<User> {
        return userDaoService.findAll()
    }

    @GetMapping("/users/{id}")
    fun retrieveUser(@PathVariable id: Int): User? {

        return userDaoService.findOne(id) ?: throw UserNotFoundException("id-$id")
    }


    @PostMapping("/users")
    fun saveUser(@Valid @RequestBody user: User): ResponseEntity<User> {

        var newUser = userDaoService.save(user)
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.id)
                .toUri()

        return ResponseEntity.created(uri).build()
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Int){

        userDaoService.deleteById(id) ?:  throw UserNotFoundException("id-$id")
    }
}