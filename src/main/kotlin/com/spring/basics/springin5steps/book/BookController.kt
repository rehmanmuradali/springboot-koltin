package com.spring.basics.springin5steps.book

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {

    @GetMapping("/books")
    fun getAllBooks() : List<Book> {

        return arrayListOf(Book(1,"Rich Dad Poor Dad 7", "Kranathkar"))
    }

}