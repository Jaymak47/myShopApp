package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import  javafx.geometry.Insets;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class Main extends Application {
    Stage Window;
    TableView<Products> table1;


    @Override
    public void start(Stage primaryStage) throws Exception {



        //Set Window
        Window = primaryStage;
        Window.setTitle("Aspire Graphics");

        //Name Colum
        TableColumn<Products,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


        //Name Price
        TableColumn<Products,Double> namePrice= new TableColumn<>("Price");
        namePrice.setMinWidth(100);
        namePrice.setCellValueFactory(new PropertyValueFactory<>("price"));


        //Name Colum
        TableColumn<Products,Integer> nameQuantity = new TableColumn<>("Quantity");
        nameQuantity.setMinWidth(200);
        nameQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table1 = new TableView<>();
        table1.setItems(getProduct());
        table1.getColumns().addAll(nameColumn,namePrice,nameQuantity);


        // Set Layout
        StackPane Layout = new StackPane();
        Layout.getChildren().add(table1);

        // Scene
        Scene scene = new Scene(Layout, 300, 400);
        Window.setScene(scene);
        Window.show();

    }


    public static void main(String []args){
        launch(args);
    }


// Get all of the Products

    public ObservableList<Products> getProduct(){
        ObservableList<Products> product = FXCollections.observableArrayList();
        product.add(new Products("Laptop",855,56));
        product.add(new Products("HardDisk",85,59));
        product.add(new Products("Memory",98,57));
        product.add(new Products("Monitor",100,50));

        return product;

    }

}


