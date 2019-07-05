package com.spring.basics.springin5steps.user

import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.ArrayList

@Component
class UserDaoService {

    companion object {
        private var users: MutableList<User> = ArrayList()
        private var count: Int

        init {
            users.add(User(1, "Rehman", Date()))
            users.add(User(2, "Daniyal", Date()))
            users.add(User(3, "AliMuhammad", Date()))
            users.add(User(4, "Alizain", Date()))

            count = 4
        }
    }

    fun findAll(): List<User> {
        return users
    }

    fun save(user: User): User {

        if (user.id == -1) user.id = ++count
        users.add(user)
        return user
    }

    fun findOne(id: Int): User? {

        for (user in users) if (user.id == id) return user
        return null
    }

    fun deleteById(id: Int): User? {
        val iterator = users.iterator()
        for (user in iterator) {
            if (user.id == id) {
                iterator.remove()
                return user
            }
        }
        return null
    }

}