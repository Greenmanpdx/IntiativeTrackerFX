/**
 * Created by GreenManPDX on 8/15/2016.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class AddPlayerWindow {
    GridPane grid;
    Button save;
    Label Attack, AC, HP, Init, InBonus, Fort, Will, Ref, Name, d, Weapon, Die;
    TextField atk, die, ac, hp, init, initBonus, fort, will, ref, name, weapon, attackBonus;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Initiative Tracker");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        save = new Button("Save");
        save.setOnAction(e -> ButtonClicked(e));

        Name = new Label("Name");
        name = new TextField();
        Attack = new Label("Attack");
        d = new Label("d");
        atk = new TextField();
        die = new TextField();
        Die = new Label("Dice");
        Weapon = new Label("Weapon");
        weapon = new TextField();
        attackBonus = new TextField();

        AC = new Label("AC");
        ac = new TextField();

        HP = new Label("HP");
        hp = new TextField();

        Init = new Label("Initiative");
        InBonus =  new Label("Initiative Bonus");
        initBonus = new TextField();
        init = new TextField();

        Fort = new Label("Fortitude");
        Will = new Label("Will");
        Ref = new Label("Reflex");

        fort = new TextField();
        will = new TextField();
        ref = new TextField();

        /*atk.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }*/







    }

    public void ButtonClicked(ActionEvent e)
    {

        int a = Integer.parseInt(atk.getText());
        int b = Integer.parseInt(die.getText());
        int c = Integer.parseInt(attackBonus.getText());

        Dice dice = new Dice(a, b, c);
        Attack attack = new Attack(weapon.getText(), dice);

        int a = Integer.parseInt(ac.getText());
        int h = Integer.parseInt(hp.getText());
        int i = Integer.parseInt(init.getText());
        int ib = Integer.parseInt(initBonus.getText());
        int f = Integer.parseInt(fort.getText());
        int w = Integer.parseInt(will.getText());
        int r = Integer.parseInt(ref.getText());

        NPC monster = new NPC(h,a, attack, f, w, r, i, ib, name.getText());


    }
}
