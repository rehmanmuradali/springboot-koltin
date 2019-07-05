package com.spring.basics.springin5steps.user

import java.util.*
import javax.validation.constraints.Past
import javax.validation.constraints.Size

class User(var id: Int = -1, @Size(min = 2) var name: String = "N/A", @Past var birthDate: Date = Date()) {
}