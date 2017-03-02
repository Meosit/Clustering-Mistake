package by.mksn.miapr

val STEP = 0.001
val NUMBERS_COUNT = 10000

val PROBABILITY_1 = 0.2
val MEAN_1 = 1.0
val DERIVATION_1 = 0.8

val PROBABILITY_2 = 1.0 - PROBABILITY_1
val MEAN_2 = 1.0
val DERIVATION_2 = 1.5

fun main(args: Array<String>) {
    val firstVector = generateVector(NUMBERS_COUNT, MEAN_1, DERIVATION_1)
    val secondVector = generateVector(NUMBERS_COUNT, MEAN_2, DERIVATION_2)
    val interval = getInterval(firstVector, secondVector)
    val firstFunction = generateProbabilityDensityFunction(firstVector.mean(), firstVector.standardDeviation(), PROBABILITY_1)
    val secondFunction = generateProbabilityDensityFunction(firstVector.mean(), firstVector.standardDeviation(), PROBABILITY_2)
    draw(firstFunction, secondFunction, STEP, interval)
}

