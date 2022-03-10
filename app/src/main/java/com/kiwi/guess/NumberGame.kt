package com.kiwi.guess

class NumberGame {
    var secrect :Int = 0
    var counter = 0
    var end = false
    init {
        reset()
    }
    fun reset() {
        secrect = (1..100).random()
        counter = 0
        end = false
    }
    fun guess(num: Int): String{
        counter++
        val message = if (num > secrect) "smaller"
            else if (num < secrect) "bigger"
            else{
                end = true
                "You got it"
        }
        return message
    }
}