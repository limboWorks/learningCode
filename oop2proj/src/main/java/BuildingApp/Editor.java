package BuildingApp;

        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.Priority;
        import javafx.scene.layout.RowConstraints;
        import javafx.scene.layout.ColumnConstraints;

public class Editor extends GridPane {

    public Editor(){
        //...
        initializeControls();
        makeColumnRow();
        //addValueChangedListeners();
        //makeRightImageSize();

    }

    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private TextField textField4;
    private TextField textField5;
    private TextField textField6;
    private TextField textField7;
    private TextField textField8;
    private TextField textField9;
    private TextField textField10;
    private TextField textField11;
    private TextField textField12;
    private TextField textfield13;
    private TextField textfield14;

    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private Label label9;
    private Label label10;
    private Label label11;
    private Label label12;
    private Label label13;
    private Label label14;
    private Label label15;
    private Label label16;

    //private ImageView imageView1; // URL als Label?

    private void initializeControls(){

        textField1 = new TextField();
        textField2 = new TextField();
        textField3 = new TextField();
        textField4 = new TextField();
        textField4 = new TextField();
        textField5 = new TextField();
        textField6 = new TextField();
        textField7 = new TextField();
        textField8 = new TextField();
        textField9 = new TextField();
        textField10 = new TextField();
        textField11 = new TextField();
        textField12 = new TextField();
        textfield13 = new TextField();
        textfield14 = new TextField();

        label1 = new Label("ID"); // evtl () ohne ID
        label2 = new Label("Rang"); // evtl ohne Rang und ""

        label3 = new Label("Name");

        label4 = new Label("Stadt");
        label5 = new Label("Land");

        label6 = new Label("Höhe (m)");
        label7 = new Label("Höhe (ft)");

        label8 = new Label("Etagen");
        label9 = new Label("Baujahr");

        label10 = new Label("Architekt");
        label11 = new Label("Stil");

        label12 = new Label("Kosten");
        label13 = new Label("Material");

        label14 = new Label("Längengrad");
        label15 = new Label("Breitengrad");

        label16 = new Label("URL");
    }

    //imageView1 = new ImageView(); //URL?

    public void makeColumnRow(){

        //Spalte
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc, cc, cc);

        //Zeile
        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc); // 11 weil evtl 3 nochmals vorkommen

        add(label1, 0, 0);

        add(label2, 0, 1);

        add(label3, 0, 2); //Name

        add(label4, 0, 3); //Stadt
        add(label5, 2, 3); //Land

        add(label6, 0, 4); //Höhe
        add(label7, 2, 4);

        add(label8, 0, 5);
        add(label9, 2, 5);

        add(label10, 0, 6);
        add(label11, 2, 6);

        add(label12, 0, 7);
        add(label13, 2, 7);

        add(label14, 0, 8);
        add(label15, 2, 8);

        add(label16, 0, 9);



        add(textField1, 1, 2, 11, 1);

        add(textField2, 1, 3);
        add(textField3, 3, 3);

        add(textField4, 1, 4);
        add(textField5, 3, 4);

        add(textField6, 1, 5);
        add(textField7, 3, 5);

        add(textField8, 1, 6);
        add(textField9, 3, 6);

        add(textField10, 1, 7);
        add(textField11, 3, 7);

        add(textField12, 1, 8);
        add(textfield13, 3, 8);

        add(textfield14, 1, 9, 11, 1);






    }



}