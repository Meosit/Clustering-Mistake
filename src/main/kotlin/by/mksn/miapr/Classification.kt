package by.mksn.miapr

import java.util.*

private val RANDOM = Random()


fun gaussianRandomNumber(mean: Double, derivation: Double)
        = RANDOM.nextGaussian() * derivation + mean

fun generateVector(length: Int, mean: Double, derivation: Double)
        = DoubleArray(length, { gaussianRandomNumber(mean, derivation) })

data class Interval(val start: Double, val end: Double)

fun getInterval(firstVector: DoubleArray, secondVector: DoubleArray): Interval {
    val allPoints = firstVector.plus(secondVector)
    return Interval(allPoints.min()!!, allPoints.max()!!)
}

fun gaussian(x: Double, mean: Double, derivation: Double): Double {
    var result = 1 / (derivation * Math.sqrt(2 * Math.PI))
    result *= Math.exp(-0.5 * Math.pow((x - mean) / derivation, 2.0))
    return result
}

fun generateProbabilityDensityFunction(vectorMean: Double, vectorDerivation: Double, probability: Double)
        = { x: Double -> gaussian(x, vectorMean, vectorDerivation) * probability }

