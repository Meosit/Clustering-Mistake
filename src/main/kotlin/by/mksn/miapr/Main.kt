package by.mksn.miapr

val STEP = 0.001
val NUMBERS_COUNT = 10000

val PROBABILITY_1 = 0.8
val MEAN_1 = 1.0
val DERIVATION_1 = 3.0

val PROBABILITY_2 = 1.0 - PROBABILITY_1
val MEAN_2 = 4.0
val DERIVATION_2 = 3.0


fun main(args: Array<String>) {
    val firstVector = generateVector(NUMBERS_COUNT, MEAN_1, DERIVATION_1)
    val secondVector = generateVector(NUMBERS_COUNT, MEAN_2, DERIVATION_2)
    val firstFunction = generateProbabilityDensityFunction(firstVector.mean(), firstVector.standardDeviation(), PROBABILITY_1)
    val secondFunction = generateProbabilityDensityFunction(secondVector.mean(), secondVector.standardDeviation(), PROBABILITY_2)
    val interval = getInterval(firstVector, secondVector)
    val xValues = doubleArrayFromRange(interval.first, interval.second, STEP)
    val y1Values = xValues.map(firstFunction).toDoubleArray()
    val y2Values = xValues.map(secondFunction).toDoubleArray()
    val areas = getAreas(y1Values, y2Values, STEP)
    draw(xValues, y1Values, y2Values, areas)
}

