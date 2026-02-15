package org.example.stack

@Suppress("UNCHECKED_CAST")
public class ArrayStack<T>(
    private val capacity: Int
) : Stack<T> {
    /*
    * Creates a stack of size `size` of the type `T`.
    * Supports PUSH, POP, PEEK, IS_FULL, IS_EMPTY  operation.
    */

    init {
        if (capacity <= 0) {
            throw IllegalStateException("Capacity must be greater than 0")
        }
    }

    // Actual data structure to hold the elements.
    private val elements: Array<T?> = arrayOfNulls(capacity)
    private var top: Int = 0

    override fun push(item: T) {
        if (isFull()) {
            throw IllegalStateException("Stack Overflow")
        }
        elements[top++] = item
    }

    override fun pop(): T {
        if (isEmpty()) {
            throw IllegalStateException("Stack Underflow")
        }

        val item = elements[--top] as T
        elements[top] = null
        return item
    }

    override fun peek(): T {
        if (isEmpty()) {
            throw IllegalStateException("Stack Underflow")
        }
        val item = elements[top - 1] as T
        return item
    }

    override fun isFull(): Boolean = top == capacity

    override fun isEmpty(): Boolean = top == 0

    override fun size(): Int = top
}

