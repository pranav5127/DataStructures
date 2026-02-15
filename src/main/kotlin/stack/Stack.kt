package org.example.stack


interface Stack<T> {
    fun push(item: T)
    fun pop(): T
    fun peek(): T
    fun isFull(): Boolean
    fun isEmpty(): Boolean
    fun size(): Int
}

