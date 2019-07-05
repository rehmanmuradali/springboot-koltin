package com.spring.basics.springin5steps.user.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class CustomizeResponseExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllException(ex : Exception , request: WebRequest) : ResponseEntity<Any> {
        val exceptionResponse = ExceptionResponse(Date(), ex.message!!, request.getDescription(false))
        println(exceptionResponse)
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(ex : Exception , request: WebRequest) : ResponseEntity<Any> {
        val exceptionResponse = ExceptionResponse(Date(), ex.message!!, request.getDescription(false))
        println(exceptionResponse)
        return ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND)
    }
}