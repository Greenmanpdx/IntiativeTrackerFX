package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class Controller {
    @FXML
    private TableView<Character> characterTable;
    //@FXML
    //private Label characterName;
    @FXML
    private TableColumn<Character, String> nameColumn;
    @FXML
    private TableColumn<Character, String> initiativeColumn;
    @FXML
    private Button AddPlayerbtn;
    @FXML
    private Button AddNPCbtn;
    @FXML
    private Button StartCombatbtn;
    @FXML
    private Main main;


    private void handleButtonAction(ActionEvent event){

        Stage stage;
        //Parent root;

        if(event.getSource() == AddNPCbtn){

            NPC temp = new NPC();
            boolean saved = main.addNPCpopup(temp);
            if (saved){
                main.getCharacterObservableList().add(temp);
            }

        }

        if(event.getSource() == AddPlayerbtn){
        /*    stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPlayerfx.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(AddPlayerbtn.getScene().getWindow());
            stage.showAndWait();*/

        }

        if(event.getSource() == StartCombatbtn){

        }

    }

    private void refreshCharcaterTable(){
        int selectedIndex = characterTable.getSelectionModel().getSelectedIndex();
        characterTable.setItems(null);
        characterTable.layout();
        characterTable.getSelectionModel().select(selectedIndex);
    }

    public Controller(){

    }

    @FXML
    public void initialize(){

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        initiativeColumn.setCellValueFactory(new PropertyValueFactory<>("initiative"));

        showChracterDetails(null);

        characterTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Character>() {
            @Override
            public void changed(ObservableValue<? extends Character> observable, Character oldValue, Character newValue) {
                showChracterDetails(null);
            }
        });
    }

    public void setMain(Main main)
    {
        this.main = main;
        characterTable.setItems(main.getCharacterObservableList());

    }

    private void showChracterDetails(Character character){

    }
}
