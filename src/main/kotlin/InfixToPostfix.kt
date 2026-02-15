package org.example

import org.example.stack.ArrayStack

class InfixToPostfix(var expression: String) {

    private val capacity = expression.length
    private val stack: ArrayStack<Char> = ArrayStack(capacity)
    private val result = StringBuilder()

    private fun precedence(operator: Char): Int {
        return when (operator) {
            '^' -> 3
            '*', '/' -> 2
            '+', '-' -> 1
            else -> -1
        }
    }

    private fun isRightAssociative(operator: Char): Boolean =
        operator == '^'

    private fun isOperator(ch: Char): Boolean =
        ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'

    fun converter(): String {
        for (item in expression) {
            when {
                // Operand
                item.isLetterOrDigit() -> {
                    result.append(item)
                }

                // Left parenthesis
                item == '(' -> {
                    stack.push(item)
                }

                // Right parenthesis
                item == ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop())
                    }
                    stack.pop() // remove '('
                }

                // Operator
                isOperator(item) -> {
                    while (
                        !stack.isEmpty() &&
                        (precedence(stack.peek()) > precedence(item) ||
                                (precedence(stack.peek()) == precedence(item) && !isRightAssociative(item)))
                    ) {
                        result.append(stack.pop())
                    }
                    stack.push(item)
                }

            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop())
        }

        return result.toString()
    }
}

fun main() {
    val exp = InfixToPostfix("a+b*c/d-c^y")
    println(exp.converter())
}
