module m0727 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires opencsv;
	
	opens jp.ac.kcg.e19c2018 to
		javafx.graphics, javafx.fxml, javafx.base;
}