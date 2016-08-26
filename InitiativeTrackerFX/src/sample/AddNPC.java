package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class AddNPC{

    @FXML
    private Button save, addAttack;

    @FXML
    private TextField number, die, ac, hp, init, initBonus, fort, will, ref, name, weapon, attackBonus, dmgBonus;
    @FXML
    private RadioButton melee, touch, ranged, rangedTouch;
    @FXML
    private ToggleGroup range;

    @FXML
    private NPC monster;
    @FXML
    private Attack attack;
    @FXML
    private Stage dialogStage;

    @FXML
    private TableView<Attack> attackTableView;
    @FXML
    private TableColumn<Character, String> weaponColumn;
    @FXML
    private TableColumn<Character, String> attackColumn;
    @FXML
    private TableColumn<Character, String> rangeColumn;
    @FXML
    private TableColumn<Character, String> damageColumn;


    @FXML
    private void initialize(){
        weaponColumn.setCellValueFactory(new PropertyValueFactory<>("weapon"));
        attackColumn.setCellValueFactory(new PropertyValueFactory<>("attackBonus"));
        rangeColumn.setCellValueFactory(new PropertyValueFactory<>("ranged"));
        damageColumn.setCellValueFactory(new PropertyValueFactory<>("damage"));

        showAttackDetails(null);

        attackTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Attack>() {


            @Override
            public void changed(ObservableValue<? extends Attack> observable, Attack oldValue, Attack newValue) {
                showAttackDetails(newValue);
            }
        });
    }
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void setNPC(NPC npc){
        this.monster = npc;

    }

    private void showAttackDetails(Attack attack){

    }





    private void handleButtonAction(ActionEvent event){

        if(event.getSource() == save) {

            monster.setAC(Integer.parseInt(ac.getText()));
            monster.setHP(Integer.parseInt(hp.getText()));
            monster.setInitiative(Integer.parseInt(init.getText()));
            monster.setInitiativeBonus(Integer.parseInt(initBonus.getText()));
            monster.setFort(Integer.parseInt(fort.getText()));
            monster.setWill(Integer.parseInt(will.getText()));
            monster.setReflex(Integer.parseInt(ref.getText()));

            dialogStage.close();
        }

        if(event.getSource() == addAttack){

            attack.setDice(Integer.parseInt(number.getText()), Integer.parseInt(die.getText()), Integer.parseInt(dmgBonus.getText()));
            attack.setAttackBonus(Integer.parseInt(attackBonus.getText()));
            attack.setName(weapon.getText());
            attack.setRange(range.getSelectedToggle().getUserData().toString());
            monster.addAttack(attack);



        }

    }
}


