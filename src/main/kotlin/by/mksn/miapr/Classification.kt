package by.mksn.miapr

import java.util.*

private val RANDOM = Random()

fun doubleArrayFromRange(start: Double, end: Double, step: Double): DoubleArray {
    val list = emptyList<Double>().toMutableList()
    var x = start
    while (x <= end) {
        list.add(x)
        x += step
    }
    return list.toDoubleArray()
}

fun gaussianRandomNumber(mean: Double, derivation: Double)
        = RANDOM.nextGaussian() * derivation + mean

fun generateVector(length: Int, mean: Double, derivation: Double)
        = DoubleArray(length, { gaussianRandomNumber(mean, derivation) })

fun getInterval(firstVector: DoubleArray, secondVector: DoubleArray): Pair<Double, Double> {
    val allPoints = firstVector.plus(secondVector)
    return allPoints.min()!! to allPoints.max()!!
}

fun gaussian(x: Double, mean: Double, derivation: Double): Double {
    var result = 1 / (derivation * Math.sqrt(2 * Math.PI))
    result *= Math.exp(-0.5 * Math.pow((x - mean) / derivation, 2.0))
    return result
}

fun generateProbabilityDensityFunction(vectorMean: Double, vectorDerivation: Double, probability: Double)
        = { x: Double -> gaussian(x, vectorMean, vectorDerivation) * probability }

fun getAreas(y1Values: DoubleArray, y2Values: DoubleArray, step: Double): Pair<Double, Double> {
    var detectionMistake = 0.0
    var falsePositive = 0.0
    for (i in y1Values.indices) {
        if (y1Values[i] > y2Values[i]) {
            detectionMistake += y1Values[i] * step
        } else {
            falsePositive += y2Values[i] * step
        }
    }
    return detectionMistake to falsePositive
}