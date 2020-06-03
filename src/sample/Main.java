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
import javafx.stage.WindowEvent;


public class Main extends Application {
    Stage Window;
    TableView<Products> table1;
    TextField Name,Price,Quanity;

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

        //Add Name Input
        Name = new TextField();
        Name.setPromptText("Name");
        Name.setMinWidth(20);

        //Add Price Input
       Price = new TextField();
        Price.setPromptText("Price");

        //Add Quantity  Input
        Quanity = new TextField();
        Quanity.setPromptText("Quantity");

       //Add Button Delete Buttopn
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> AddButtonClicked ());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked ());
        Button QuitButton = new Button("Quit");
        QuitButton.setOnAction(e-> closeProgram());


        table1 = new TableView<>();
        table1.setItems(getProduct());
        table1.getColumns().addAll(nameColumn,namePrice,nameQuantity);


        // Set Layout
        HBox HB = new HBox();
        HB.setPadding(new Insets (10,10,10,10 ));
        HB.setSpacing(10);
        HB.getChildren().addAll(Name,Price,Quanity,addButton,deleteButton);

        HBox HB1 = new HBox();
        HB1.setPadding(new Insets (10,10,10,10 ));
        HB1.setSpacing(10);
        HB1.getChildren().add(QuitButton);


        VBox Layout = new VBox();
        Layout.getChildren().addAll(table1,HB,HB1);


        // Scene
        Scene scene = new Scene(Layout, 300, 400);
        Window.setScene(scene);
        Window.show();

    }


    public static void main(String []args){
        launch(args);
    }

    //Close Program
    public void closeProgram(){
        Window.close();
    }
    // Add Button Functionality

    public void AddButtonClicked(){
        Products prod = new Products();
        prod.setName(Name.getText());
        prod.setPrice(Double.parseDouble (Price.getText()));
        prod.setQuantity(Integer.parseInt(Quanity.getText()));
        table1.getItems().addAll(prod);
        Name.clear();
        Price.clear();
        Quanity.clear();

    }


    // Delete Button
    public void deleteButtonClicked(){
        ObservableList<Products> prodSelected, allProducts;
        allProducts = table1.getItems();
        prodSelected = table1.getSelectionModel().getSelectedItems();

        prodSelected.forEach(allProducts::remove);


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


