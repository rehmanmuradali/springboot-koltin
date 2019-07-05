package com.spring.basics.springin5steps

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BinarySearchImpl(@Autowired var sortAlgorithm: SortAlgorithm) {


    fun binarySearch(numbers: IntArray, numberToSearchFor: Int): Int {

        val sortedNumbers = sortAlgorithm.sort(numbers)
        println(sortAlgorithm)


        return 3
    }

}