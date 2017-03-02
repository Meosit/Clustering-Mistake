package by.mksn.miapr

fun DoubleArray.mean(): Double {
    val sum = this.indices.sumByDouble { this[it] }
    return sum / this.size
}

fun DoubleArray.standardDeviation(): Double {
    return Math.sqrt(variance(this))
}

private fun variance(input: DoubleArray): Double {
    val mean = input.mean()
    val variance = input.indices
            .map { input[it] - mean }
            .sumByDouble { it * it }
    return variance / input.size
}
