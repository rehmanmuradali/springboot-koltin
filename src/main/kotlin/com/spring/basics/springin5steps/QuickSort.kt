package com.spring.basics.springin5steps

import org.springframework.stereotype.Component

@Component
class QuickSort : SortAlgorithm{

    override fun sort(number : IntArray) : IntArray {
        return  number
    }
}