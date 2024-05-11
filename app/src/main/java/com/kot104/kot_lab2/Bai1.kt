package com.kot104.kot_lab2

fun main() {
    println("Phương trình ax+b=0")
    var a = 0.0
    var b = 0.0
    print("Nhập a:")
    var s = readLine()
    if (s != null) a = s.toDouble()
    print("Nhập b:")
    s = readLine()
    if (s != null) b = s.toDouble()
    if (a == 0.0 && b == 0.0) {
        println("Phương trình vô số nghiệm")
    } else if (a == 0.0 && b != 0.0) {
        println("Phương trình vô nghiệm")
    } else {
        val x = -b / a
        println("No x=" + x)
    }
}
