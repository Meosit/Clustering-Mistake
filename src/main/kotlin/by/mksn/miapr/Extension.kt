package by.mksn.miapr

fun DoubleArray.mean(): Double {
    val sum = this.indices.sumByDouble { this[it] }
    return sum / this.size
}

fun DoubleArray.standardDeviation(): Double {
    return Math.sqrt(variance(this))
}

private fun variance(input: DoubleArray): Double {
    val expectedVal = expectedValue(input)
    val variance = input.indices
            .map { input[it] - expectedVal }
            .sumByDouble { it * it }
    return variance
}

private fun expectedValue(input: DoubleArray): Double {
    val sum = input.indices.sumByDouble { input[it] }
    return sum / input.size
}