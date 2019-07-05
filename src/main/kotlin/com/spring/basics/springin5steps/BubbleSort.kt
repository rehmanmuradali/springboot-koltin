package com.spring.basics.springin5steps

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Primary
class BubbleSort : SortAlgorithm{

    override fun sort(number : IntArray) : IntArray {
        return  number
    }
}