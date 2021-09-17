import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;




public class CameraMain extends  Application {
    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        Label Reocam = new Label();
        Reocam.setText("REOCAM");
        Reocam.setFont(Font.font("Lucida Grande", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 26));
        Reocam.setTextFill(Color.color(0.5, 0.6, 0.9));

        TextField number = new TextField();
        number.setFont(Font.font("Lucida Grande", FontWeight.BOLD, FontPosture.REGULAR, 18));
        number.setMaxWidth(100);
        TextField ip = new TextField();
        ip.setFont(Font.font("Lucida Grande", FontWeight.BOLD, FontPosture.REGULAR, 18));
        ip.setText("192.168.0.216");
        Label ipl = new Label();
       // ipl.setFont(Font.font("Lucida Grande", FontWeight.BOLD, FontPosture.REGULAR, 18));
       // ipl.setText("192.168.23.9");
        TextArea ipout = new TextArea();
        ipout.setFont(Font.font("Lucida Grande", FontWeight.BOLD, FontPosture.REGULAR, 18));
        ipout.setMaxHeight(200);


        Button search = new Button();
        search.setText("   Search   ");
        search.setTextAlignment(TextAlignment.CENTER);
        search.setStyle("#iphone {\n" +
                "    -fx-background-color: \n" +
                "        #516175,\n" +
                "        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
                "        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);\n" +
                "    -fx-background-insets: 0 0 -1 0,0,1;\n" +
                "    -fx-background-radius: 5,5,4;\n" +
                "    -fx-padding: 7 30 7 30;\n" +
                "    -fx-text-fill: #202224;\n" +
                "    -fx-font-family: \"Lucida Grande\";\n" +
                "    -fx-font-size: 20px;\n" +
                "    -fx-text-fill: gray;\n" +
                "}");

        Button ping = new Button();
        ping.setText("   Ping   ");
        ping.setTextAlignment(TextAlignment.CENTER);
        ping.setStyle("#iphone {\n" +
                "    -fx-background-color: \n" +
                "        #516175,\n" +
                "        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
                "        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);\n" +
                "    -fx-background-insets: 0 0 -1 0,0,1;\n" +
                "    -fx-background-radius: 5,5,4;\n" +
                "    -fx-padding: 7 30 7 30;\n" +
                "    -fx-text-fill: #202224;\n" +
                "    -fx-font-family: \"Lucida Grande\";\n" +
                "    -fx-font-size: 20px;\n" +
                "    -fx-text-fill: gray;\n" +
                "}");


        TextArea INFO = new TextArea();
        INFO.setFont(Font.font("Lucida Grande", FontWeight.BOLD, FontPosture.REGULAR, 18));

        TextArea VM = new TextArea();
        VM.setFont(Font.font("Lucida Grande", FontWeight.BOLD, FontPosture.REGULAR, 18));

        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setBlendMode(BlendMode.MULTIPLY);
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        gridpane.add(Reocam,0,0);
        gridpane.add(number,0,1);
        gridpane.add(search,1,1);
        gridpane.add(INFO,0,2);
        gridpane.add(VM,0,3);
        //gridpane.add(ipl,0,4);
        gridpane.add(ip,0,4);
        gridpane.add(ping,1,4);
        gridpane.add(ipout,0,5);



        Scene scene = new Scene(gridpane);


        stage.setScene(scene);

        stage.setTitle("REOCAM NUMBER");
        stage.setWidth(1000);
        stage.setHeight(1000);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);

        stage.show();

        search.setOnAction(event -> {

            //////////////////////////////////////////

            ArrayList<String> arr = ReaderInfo.read(); //DATA
            String numbernumber = number.getText();
            for ( int i = 0; i < arr.size(); i++)
            {

                String s = arr.get(i).substring(0,3);
                String sinfo = arr.get(i);

                if(s.contains(numbernumber))
                {
                   INFO.setText(sinfo);

                }

            }
            ArrayList<String> arr2 = ReaderVirtual.read(); //DATA
            for ( int i = 0; i < arr2.size(); i++)
            {

                String s = arr2.get(i).substring(0,3);
                String sVM = arr2.get(i);

                if(s.contains(numbernumber))
                {
                    VM.setText(sVM);

                }

            }

            ///////////////////////////////////////////////



        });


        /////////////////////////////////////////
        ping.setOnAction(event -> {
        try {
            String ipnew;

            ipnew = ip.getText();
           // ipnew = "192.168.0.216";


            String line;
            String[] cmd = {"cmd.exe", "/c", "ping" + " " + ipnew};

            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream(),"866"));

           for (int i = 0; i < 6; i++) {
                line = input.readLine();
               ipout.appendText(line + "\n");
            }
            input.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        });
        ////////////////////////////////////////////



    }
}
