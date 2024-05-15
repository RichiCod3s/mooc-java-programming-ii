package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    @Override
    public void start(Stage window) {

        window.setTitle("University of Helsinki Shanghai Ranking");

        // define the axes
        final NumberAxis xAxis = new NumberAxis(2006, 2018, 11); // needed to enter in the range as by default 
        final NumberAxis yAxis = new NumberAxis(0,100, 10);
        xAxis.setLabel("year");
        yAxis.setLabel("Ranking");

        //creating the chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("University of Helsinki Shanghai Ranking");
        //lineChart.setLegendVisible(false);
        
        
        //define a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Shanghai Ranking");

        //populating the series with data    x,y
        series.getData().add(new XYChart.Data(2007, 73));
        series.getData().add(new XYChart.Data(2008, 68));
        series.getData().add(new XYChart.Data(2009, 72));
        series.getData().add(new XYChart.Data(2010, 72));
        series.getData().add(new XYChart.Data(2011, 74));
        series.getData().add(new XYChart.Data(2012, 73));
        series.getData().add(new XYChart.Data(2013, 76));
        series.getData().add(new XYChart.Data(2014, 73));
        series.getData().add(new XYChart.Data(2015, 67));
        series.getData().add(new XYChart.Data(2016, 56));
        series.getData().add(new XYChart.Data(2017, 56));
        
        // add the line chart to scene and series to the line chart
        
        Scene scene = new Scene(lineChart, 800,600);
        lineChart.getData().add(series);
        
        window.setScene(scene);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
