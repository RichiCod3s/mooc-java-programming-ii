package application;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    int investment = 25; //set to starting slider value
    int interestRate = 0;
    HashMap<Integer, Double> monthlySavingsMap = new HashMap();
    HashMap<Integer, Double> interestSavingsMap = new HashMap();

    @Override
    public void start(Stage window) {

        // application can be managed using a BorderPane. 
        BorderPane layout = new BorderPane();

        //In the middle of the BorderPane add a line chart (LineChart), which has two numerical axis (NumberAxis).
        final NumberAxis xAxis = new NumberAxis("Years", 0, 30, 1);
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Savings");

        //create linechart
        LineChart<Number, Number> linechart = new LineChart(xAxis, yAxis);
        linechart.setTitle("Savings Calculator");
        linechart.setAnimated(false);
        layout.setCenter(linechart);

        //define a series
        XYChart.Series monthlySeries = new XYChart.Series();
        monthlySeries.setName("Monthly Savings");

        XYChart.Series interestSeries = new XYChart.Series();
        interestSeries.setName("Interest Savings");
        //On the top of the BorderPane add a VBox component which contains two BorderPanes        
        VBox top = new VBox();

        Slider monthlySavings = getSlider(25, 250, true);
        
        //added settings (not needed just added slider options)
        monthlySavings.setSnapToTicks(true);
        monthlySavings.setBlockIncrement(500);
        monthlySavings.setShowTickMarks(true);
        monthlySavings.setShowTickLabels(true);
        monthlySavings.setValue(25);
        
        Slider yearlyInterest = getSlider(0, 10, false);
        
         //added settings (not needed just added slider options)
        yearlyInterest.setMinorTickCount(10);
        yearlyInterest.setShowTickMarks(true);
        yearlyInterest.setShowTickLabels(true);
        yearlyInterest.setValue(0);
        
        
        BorderPane m = sliderBorderPane("Monthly savings", monthlySavings);
        BorderPane y = sliderBorderPane("Yearly interest rate", yearlyInterest);

        top.getChildren().addAll(m, y);
        layout.setTop(top);
        
        // pre populate the series on startup. Otherwise nothing before actionListner enabled
            monthlySavings();
            interestSavings();
            populateSeries(monthlySeries, interestSeries);

        // action logic - addListner()
        monthlySavings.valueProperty().addListener((change, oldValue, newValue) -> {
            investment = newValue.intValue(); 
            monthlySavings();
            interestSavings();
            populateSeries(monthlySeries, interestSeries);
        });

        yearlyInterest.valueProperty().addListener((change, oldValue, newValue) -> {
           // investment = newValue.intValue();
            interestRate = newValue.intValue(); 
            monthlySavings();
            interestSavings();
            populateSeries(monthlySeries, interestSeries);
        });

        //add line chart to scene and series to the line chart
        populateSeries(monthlySeries, interestSeries);
        linechart.getData().addAll(monthlySeries, interestSeries);
       
        Scene scene = new Scene(layout, 800, 600);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public BorderPane sliderBorderPane(String text, Slider slider) {
        BorderPane borderPane = new BorderPane();
        Label label = new Label(text);
        Label sliderValue = new Label(String.valueOf(slider.getValue()));

        // Add a listener to the slider's value property
        slider.valueProperty().addListener((change, oldValue, newValue) -> {
            sliderValue.setText(String.valueOf(newValue.intValue())); // Update the label with the new value
        });

        borderPane.setLeft(label);
        borderPane.setCenter(slider);
        borderPane.setRight(sliderValue);

        //layout style
        //  borderPane.setPrefSize(300, 180);
        borderPane.setPadding(new Insets(10, 10, 10, 10));

        return borderPane;
    }

    public Slider getSlider(int min, int max, boolean tickMarks) {

        //A slider in the middle and a text describing the slider on the right. 
        Slider slider = new Slider();
        slider.setMin(min);
        slider.setMax(max);
        slider.setValue(0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(tickMarks);

        //other methods that could be used 
        //slider.setMajorTickUnit(50);
        // slider.setMinorTickCount(5);
        //slider.setBlockIncrement(10);
        // slider.setSnapToTicks(true); You can assign the setSnapToTicks method to true to keep the slider's value aligned with the tick marks.
        // label for value of slider // right of border
        return slider;
    }

    public void monthlySavings() {
        // map.clear();
       
        double savings = 0;
        int years = 30;

        // monthly savings
        for (int currentYear = 0; currentYear <= years; currentYear++) {
            //add to hashMap
            monthlySavingsMap.put(currentYear, savings);
            savings += investment * 12;
        }

          // get rid of this later - for debugging
       for (Map.Entry<Integer, Double> entry : monthlySavingsMap.entrySet()) {
            System.out.println("MKey: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    
    }

    public void interestSavings() {

        //interest savings
        double savings = 0;
        int years = 30;

         for (int currentYear = 0; currentYear <= years; currentYear++) {
        // Calculate the savings with compound interest for the current year
        double totalInterest = savings * (interestRate / 100.0);
        savings += totalInterest;

        // Store the savings for the current year in the map
        interestSavingsMap.put(currentYear, savings);

        // Add the monthly investment to savings for the next year
        savings += investment * 12;
    }

        // get rid of this later - for debugging
       for (Map.Entry<Integer, Double> entry : interestSavingsMap.entrySet()) {
            System.out.println("InterestKey: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public void populateSeries(XYChart.Series monthlySeries, XYChart.Series interestSeries) {
        // we need to clear the data in the series or the new data will be added to the existing data, making more and more lines(Series)
        monthlySeries.getData().clear();
        interestSeries.getData().clear();

        for (Map.Entry<Integer, Double> entry : monthlySavingsMap.entrySet()) {
            monthlySeries.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
        }

        for (Map.Entry<Integer, Double> entry : interestSavingsMap.entrySet()) {
            interestSeries.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
        }
    }
}
