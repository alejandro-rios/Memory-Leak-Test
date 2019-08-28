package com.alejandrorios.memoryleaktest

/**
 * Created by alejandrorios on 2019-08-27
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class LeakTest
