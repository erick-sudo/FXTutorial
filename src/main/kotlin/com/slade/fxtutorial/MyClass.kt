package com.slade.fxtutorial

class MyClass(
    private var value: String? = null
) {
    companion object {
        fun valueOf(value: String): MyClass = MyClass(value)
    }
}