package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;



public class Main extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

    private ObservableList<Character> characterObservableList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Initiative Tracker Home");

        try {
            // Load the root layout from the fxml file
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample/sample.fxml"));
            rootLayout =  loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }

        showCharacterOverview();
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {return primaryStage;}
    public ObservableList<Character> getCharacterObservableList() {return characterObservableList;}


    public boolean addNPCpopup(NPC npc){
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.AddNPCFX.fxml"));
            AnchorPane page =  loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Enter Character");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            AddNPC controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setNPC(npc);

            dialogStage.showAndWait();


        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Shows the person overview scene.
     */
    public void showCharacterOverview() {
        try {
            // Load the fxml file and set into the center of the main layout
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample/sample.fxml"));
            AnchorPane overviewPage = loader.load();
            rootLayout.setCenter(overviewPage);

            Controller controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}