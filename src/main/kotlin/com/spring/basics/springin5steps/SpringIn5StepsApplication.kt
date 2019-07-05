package com.spring.basics.springin5steps

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringIn5StepsApplication

fun main(args: Array<String>) {

	//var binarySearchImpl = BinarySearchImpl(QuickSort())
	//var result = binarySearchImpl.binarySearch(intArrayOf(1,2,3,4), 2)
	//println(result)

	var applicationContext = runApplication<SpringIn5StepsApplication>(*args)
	var binarySearchImpl = applicationContext.getBean(BinarySearchImpl::class.java)
	var result = binarySearchImpl.binarySearch(intArrayOf(1,4,5) , 2)
	println(result)
	for (bean in applicationContext.beanDefinitionNames){
		println(bean)
	}
}
