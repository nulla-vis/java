package jp.ac.kcg.e19c2018;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;

public class ChartController {

    @FXML
    private ListView<String> list;

    @FXML
    private LineChart<String, Number> chart;
    
    private LinkedHashMap<String, Series<String,Number>> cityData;
    
    @FXML
    protected void initialize() throws NumberFormatException, CsvValidationException, IOException {
    	cityData = new LinkedHashMap<>();
    	list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	readCSVFile("tokeisyo2017a1013.csv");
    	prepareListSelection();
    }
    
    @FXML
    void click(MouseEvent event) {

    }
    
	private void prepareListSelection() {
    	list.getSelectionModel().selectedItemProperty().addListener(
        		(ob,oldSel,newSel)->{
                  ObservableList<Data<String,Number>> data = chart.getData().get(0).getData();
//        			System.out.println(oldSel);
        			System.out.println(newSel);
//        			ObservableList<Data<String,Number>> data = chart.getData().get(i).getData();
        			System.out.println(cityData.get(newSel).dataProperty().getValue().get(0));
//        			data.clear();
                  data.add(cityData.get(newSel).dataProperty().getValue().get(0));              
//                  data.add(new Data<>("H26",d2));
//                  data.add(new Data<>("H27",d3));
//                  data.add(new Data<>("H28",d4));
//                  data.add(new Data<>("H29",d5));
        	});
	}

	private void readCSVFile(String Filename) throws NumberFormatException, CsvValidationException, IOException {
		try {
			CSVReader dataReader = new CSVReader(new FileReader("tokeisyo2017a1013.csv"));
            String[] nextLine;
            
            int i = 0;
            while ((nextLine = dataReader.readNext()) != null) {
            	Series<String, Number> series = new Series<>();
              String cityName = String.valueOf(nextLine[0]);
            	if(nextLine != null) {
            		System.out.println(Arrays.toString(nextLine));
            	}
              series.setName(cityName);
//              ObservableList<Data<String,Number>> data = chart.getData().get(i).getData();
              chart.getData().add(series);

              double h1 = Double.parseDouble(nextLine[1]);
              double m1 = Double.parseDouble(nextLine[2]);
              double d1 = (m1/h1);
              
              double h2 = Double.parseDouble(nextLine[3]);
              double m2 = Double.parseDouble(nextLine[4]);
              double d2 = (m2/h2);
              
              double h3 = Double.parseDouble(nextLine[5]);
              double m3 = Double.parseDouble(nextLine[6]);
              double d3 = (m3/h3);
              
              double h4 = Double.parseDouble(nextLine[7]);
              double m4 = Double.parseDouble(nextLine[8]);
              double d4 = (m4/h4);
              
              double h5 = Double.parseDouble(nextLine[9]);
              double m5 = Double.parseDouble(nextLine[10]);
              double d5 = (m5/h5);
              series.getData().add(new XYChart.Data<String, Number>("H25",d1));
              series.getData().add(new XYChart.Data<String, Number>("H26",d2));
              series.getData().add(new XYChart.Data<String, Number>("H27",d3));
              series.getData().add(new XYChart.Data<String, Number>("H28",d4));
              series.getData().add(new XYChart.Data<String, Number>("H29",d5));
//              data.set(0, new Data<>("H25",d1));
//              data.set(1, new Data<>("H26",d2));
//              data.set(2, new Data<>("H27",d3));
//              data.set(3, new Data<>("H28",d4));
//              data.set(4, new Data<>("H29",d5));
//              System.out.println(data.get(i));
              
              cityData.put(cityName, series);
              list.getItems().add(cityName);
              i++;
            }
//            	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println("DONE");
            }
        
	}

