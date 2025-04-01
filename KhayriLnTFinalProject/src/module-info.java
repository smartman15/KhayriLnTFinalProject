module KhayriLnTFinalProject {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.sql;
	requires java.desktop;
	requires javafx.base;
	
	opens Controller;
	opens Model;
	opens View;
	opens application;
}
