package org.example.queue

class ArrayQueue<T>(private val capacity: Int) : Queue<T> {

    private val elements: Array<T?> = arrayOfNulls(capacity)
    private var front = 0
    private var rear = -1
    private var count = 0

    override fun enqueue(item: T) {
        if (isFull()) {
            throw IllegalStateException("Queue Full")
        }
        rear++
        elements[rear] = item
        count++
    }

    override fun dequeue(): T {
        if (isEmpty()) {
            throw IllegalStateException("Queue Empty")
        }
        val item = elements[front]
        elements[front] = null
        front++
        count--
        return item as T
    }

    override fun peek(): T {
        if (isEmpty()) {
            throw IllegalStateException("Queue Empty")
        }
        return elements[front] as T
    }

    override fun isEmpty(): Boolean = count == 0

    override fun isFull(): Boolean = count == capacity

    override fun size(): Int = count
}
