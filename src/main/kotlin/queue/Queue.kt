package org.example.queue

interface Queue<T>{
    fun enqueue(item: T)
    fun dequeue(): T
    fun isEmpty(): Boolean
    fun isFull(): Boolean
    fun peek(): T
    fun size(): Int
}