package by.mksn.miapr

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import java.io.File

fun draw(firstFunction: (x: Double) -> Double, secondFunction: (x: Double) -> Double, step: Double, interval: Interval) {
    val dataset = XYSeriesCollection()
    val series1 = XYSeries("First Function")
    val series2 = XYSeries("Second Function")

    var x = interval.start
    while (x < interval.end) {
        series1.add(x, firstFunction(x))
        series2.add(x, secondFunction(x))
        x += step
    }

    dataset.addSeries(series1)
    dataset.addSeries(series2)

    val chart = ChartFactory.createXYLineChart("Blah", "X", "Y", dataset, PlotOrientation.VERTICAL, true, false, false)
    ChartUtilities.saveChartAsPNG(File("test.jpg"), chart, 1000, 1000)
}