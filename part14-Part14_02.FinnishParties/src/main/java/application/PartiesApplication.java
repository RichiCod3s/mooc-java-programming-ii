package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage window) {

        window.setTitle("Relative Support of Finnish Parties");
        
        //define the axes
        final NumberAxis xAxis = new NumberAxis(1968, 2010, 10);
        final NumberAxis yAxis = new NumberAxis(0, 30, 5);
        xAxis.setLabel("Year");
        yAxis.setLabel("Support");
        

        //create chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative Support of Finnish Parties");

        HashMap<String, HashMap<Integer, Double>> values = fileToMap("partiesData.tsv");
        
        // Go through the parties and add them to the chart
        values.keySet().stream().forEach(party -> {
             // A different data set for every party
            XYChart.Series data = new XYChart.Series();
            data.setName(party);
        
         // Add the party's support numbers to the data set
         values.get(party).entrySet().stream().forEach(pair -> {
             data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
              });   
         
             // Add the data set to the chart
         lineChart.getData().add(data);
         
        });
        
        
        ////add line chart to scene and series to the line chart
        Scene scene = new Scene(lineChart, 800,600);
        window.setScene(scene);
        window.show();
        // Add a short delay to ensure the chart is fully rendered


    }

    public static void main(String[] args) {

        launch(PartiesApplication.class);
   

    }
    // test failed as it wants this in the start method
    public static HashMap<String, HashMap<Integer, Double>> fileToMap(String fileName) {

        //stores party and the above data
        HashMap<String, HashMap<Integer, Double>> data = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            // first line of header of years put in to array         
            String header = scanner.nextLine();
            String[] years = header.split("\t"); //1-11

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                // Break each line of data in to an array
                String[] pieces = line.split("\t");

                // map years and support
                HashMap<Integer, Double> map = new HashMap<>();

                //store hashmap of year and data - starts at [1]
                for (int j = 1; j < pieces.length; j++) {

                    if (!pieces[j].equals("-")) {// skip the data that is populated with "-"
                        map.put(Integer.valueOf(years[j]), Double.valueOf(pieces[j]));
                    }

                }

                // then [0] partyName, the rest is the data   // partyName[0], arrayYear[1], pieces[1] etc etc  
                data.put(pieces[0], map);

            }
        } catch (FileNotFoundException e) {

        }
        return data;
    }
}
