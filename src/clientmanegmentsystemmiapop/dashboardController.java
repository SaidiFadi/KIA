/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmanegmentsystemmiapop;

/**
 *
 * @author FADI
 */
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class dashboardController implements Initializable {

      @FXML
    private AnchorPane main_form;
      
    @FXML
    private Button close;
    
     @FXML
    private Button bd_btn;
     
     @FXML
    private AnchorPane bd_form;

    @FXML
    private TextField bd_id;

    @FXML
    private TextField bd_date;

    @FXML
    private TextField bd_max;
      @FXML
    private TextField bd_search;
    
    @FXML
    private Button bd_addbtn;
    @FXML
    private Button bd_clearbtn;
    @FXML
    private Button bd_updatebtn;

     @FXML
    private TableView<bdData> bd_tableView;

    @FXML
    private TableColumn<bdData, String> bd_col_id;

    @FXML
    private TableColumn<bdData, String> bd_col_date;

    @FXML
    private TableColumn<bdData, Integer> bd_col_max;
    @FXML
    private Button minimize;
    
       @FXML
    private Button fullScreenBtn;

    @FXML
    private Button home_btn;

    @FXML
    private Button addclient_btn;

    @FXML
    private Button info_btn;

    @FXML
    private Button logout;

    @FXML
    private Label username;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalclient;

    @FXML
    private Label home_totalaccorder;

    @FXML
    private Label home_totalrefuser;

    @FXML
    private BarChart<?, ?> home_chart;

    @FXML
    private AnchorPane addclient_form;

    @FXML
    private TableView<clientData> addclient_tableView;

    @FXML
    private TableColumn<clientData, String> addclient_col_clientID;

    @FXML
    private TableColumn<clientData, String> addclient_col_firstName;

    @FXML
    private TableColumn<clientData, String> addclient_col_lastName;

    @FXML
    private TableColumn<clientData, String> addclient_col_CIN;

    @FXML
    private TableColumn<clientData, String> addclient_col_adresse;

    @FXML
    private TableColumn<clientData, String> addclient_col_phoneNum1;

    @FXML
    private TableColumn<clientData, String> addclient_col_phoneNum2;

    @FXML
    private TableColumn<clientData, String> addclient_col_date;

    @FXML
    private TableColumn<clientData, String> addclient_col_etat;

    @FXML
    private TextField addclient_search;

    @FXML
    private TextField addclient_clientID;

    @FXML
    private TextField addclient_firstName;

    @FXML
    private TextField addclient_lastName;

    @FXML
    private TextField addclient_CIN;

    @FXML
    private TextField addclient_adresse;

    @FXML
    private TextField addclient_phoneNum1;

    @FXML
    private TextField addclient_phoneNum2;

    @FXML
    private Button addclient_addBtn;

    @FXML
    private Button addclient_updateBtn;

    @FXML
    private Button addclient_clearBtn;

    @FXML
    private ComboBox<?> addclient_etat;

    @FXML
    private AnchorPane info_form;

    @FXML
    private TextField infoclient_search;

    @FXML
    private Label infoclient_clientID;

    @FXML
    private Label infoclient_firstName;

    @FXML
    private Label infoclient_lastName;

    @FXML
    private Label infoclient_CIN;
    
    @FXML
    private DatePicker infoclient_ddSMS;

    @FXML
    private DatePicker infoclient_ddReponse;

    @FXML
    private TextArea infoclient_commentaire;

    @FXML
    private ComboBox<?> infoclient_etat;
    
    
    @FXML
    private ComboBox<?> infoclient_bd;

    @FXML
    private Button infoclient_upadateBtn;

    @FXML
    private Button infoclient_clearBtn;

  //  @FXML
   // private TextField infoclient_ddSMS;

    @FXML
    private TableView<clientData> infoclient_tableView;

    @FXML
    private TableColumn<clientData, String> infoclient_col_clientID;

    @FXML
    private TableColumn<clientData, String> infoclient_col_firstName;

    @FXML
    private TableColumn<clientData, String> infoclient_col_lastName;

    @FXML
    private TableColumn<clientData, String> infoclient_col_CIN;

    @FXML
    private TableColumn<clientData, String> infoclient_col_phoneNum1;

    @FXML
    private TableColumn<clientData, String> infoclient_col_phoneNum2;

    @FXML
    private TableColumn<clientData, String> infoclient_col_date;

    @FXML
    private TableColumn<clientData, String> infoclient_col_etat;

    @FXML
    private TableColumn<clientData, String> infoclient_col_ddReponse;

    @FXML
    private TableColumn<clientData, String> infoclient_col_ddSMS;

    @FXML
    private TableColumn<clientData, String> infoclient_col_commentaire;
 @FXML
    private TableColumn<clientData, String> infoclient_col_bd;
    
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;
    
    public void homeTotalClient() {

        String sql = "SELECT COUNT(id) FROM clientdata";

        connect = database.connectDb();
        int countData = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }

            home_totalclient.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    


    public void homeTotalRefuser() {

        String sql = "SELECT COUNT(id) FROM clientdata WHERE etat = 'Refuser'";

        connect = database.connectDb();
        int countData = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }
            home_totalrefuser.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void homeTotalAccorder() {

        String sql = "SELECT COUNT(id) FROM clientdata WHERE etat = 'accorder'";

        connect = database.connectDb();
        int countData = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }
            home_totalaccorder.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeChart() {

        home_chart.getData().clear();

        String sql = "SELECT date, COUNT(id) FROM clientdata GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 7";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public void addClientAdd() {

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "INSERT INTO clientdata "
                + "(client_id,firstName,lastName,CIN,adresse,phoneNumone,phoneNumtwo,etat,date,ddSMS,ddReponse,commentaire,bdName) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;
            if (addclient_clientID.getText().isEmpty()  /*|| addclient_etat.getSelectionModel().getSelectedItem() == null
                   /* || addclient_firstName.getText().isEmpty()
                    || addclient_lastName.getText().isEmpty()
                    || addclient_etat.getSelectionModel().getSelectedItem() == null
                    || addclient_phoneNumone.getText().isEmpty()
                    
                    || getData.path == null || getData.path == ""*/) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                String check = "SELECT client_id FROM clientdata WHERE client_id = '"
                        + addclient_clientID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Client ID: " + addclient_clientID.getText() + " was already exist!");
                    alert.showAndWait();
                } else {

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, addclient_clientID.getText());
                    prepare.setString(2, addclient_firstName.getText());
                    prepare.setString(3, addclient_lastName.getText());
                   
                    prepare.setString(4, addclient_CIN.getText());
                    prepare.setString(5, addclient_adresse.getText());
                    prepare.setString(6, addclient_phoneNum1.getText());
                    prepare.setString(7, addclient_phoneNum2.getText());
                  //   prepare.setString(8, (String) addclient_etat.getSelectionModel().getSelectedItem());
                   prepare.setString(8, " en cours ");
               

                  //  String uri = getData.path;
                   // uri = uri.replace("\\", "\\\\");

                 //   prepare.setString(9, uri);
                    prepare.setString(9, String.valueOf(sqlDate));
                    prepare.setString(10, " ");
                    prepare.setString(11, " ");
                    prepare.setString(12, " ");
                    prepare.setString(13, " ");



                    prepare.executeUpdate();

             /*       String insertInfo = "INSERT INTO clientbd "
                            + "(bdName,dateCreation,client_id,firstName,lastName,CIN,phoneNumone,phoneNumtwo,date,nbMAX) "
                            + "VALUES(?,?,?,?,?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertInfo);
                    prepare.setString(1, addclient_clientID.getText());
                    prepare.setString(2, addclient_firstName.getText());
                    prepare.setString(3, addclient_lastName.getText());
                    prepare.setString(4, addclient_CIN.getText());
                    prepare.setString(5, addclient_phoneNum1.getText());
                    prepare.setString(6, addclient_phoneNum2.getText());
                     prepare.setString(7, String.valueOf(sqlDate));
                     prepare.setString(8, addclient_etat.getText());
                    prepare.setString(9, addclient_ddSMS.getText());
                    prepare.setString(10, addclient_ddReponse.getText());
                    prepare.setString(11, addclient_commentaire.getText());
                    
                    prepare.setString(5, "0.0");
                    prepare.setString(6, String.valueOf(sqlDate));
                    prepare.executeUpdate();
*/
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    addClientShowListData();
                    addClientReset();
                     infoClientShowListData();
                    infoClientReset();
                }
            }

        } catch (SQLException e) {
        }

      
    }
    
    
    public void addClientUpdate() {

      //  String uri = getData.path;
      //  uri = uri.replace("\\", "\\\\");

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "UPDATE clientdata SET firstName = '"
                + addclient_firstName.getText() + "', lastName = '"
                + addclient_lastName.getText() + "', CIN    = '"
                + addclient_CIN.getText() +  "', adresse = '"
                + addclient_adresse.getText() +"', etat = '"
                + addclient_etat.getSelectionModel().getSelectedItem() + "', phoneNumone = '"
                + addclient_phoneNum1.getText() +  "', phoneNumtwo = '"
                + addclient_phoneNum2.getText()  + /*"', date = '" + sqlDate +*/ "' WHERE client_id ='"
                + addclient_clientID.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (addclient_clientID.getText().isEmpty() /*|| addclient_etat.getSelectionModel().getSelectedItem() == null
                     /*|| addclient_firstName.getText().isEmpty()
                    || addclient_lastName.getText().isEmpty()
                    || addclient_CIN.getText().isEmpty()
                    || addclient_adresse.getText().isEmpty()
                    || addclient_etat.getSelectionModel().getSelectedItem() == null
                    || addclient_phoneNum1.getText().isEmpty()
                    || addclient_phoneNum2.getText().isEmpty()
                  
                    || getData.path == null || getData.path == ""*/) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE client ID: " + addclient_clientID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                      addClientShowListData();
                    addClientReset();
                     infoClientShowListData();
                   // infoClientReset();
/*
                    double salary = 0;

                    String checkData = "SELECT * FROM client_info WHERE client_id = '"
                            + addclient_clientID.getText() + "'";

                    prepare = connect.prepareStatement(checkData);
                    result = prepare.executeQuery();

                    while (result.next()) {
                        salary = result.getDouble("salary");
                    }

                    String updateInfo = "UPDATE client_info SET firstName = '"
                            + addclient_firstName.getText() + "', lastName = '"
                            + addclient_lastName.getText() + "', position = '"
                            + addclient_etat.getSelectionModel().getSelectedItem()
                            + "' WHERE client_id = '"
                            + addclient_clientID.getText() + "'";

                    prepare = connect.prepareStatement(updateInfo);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    addClientShowListData();
                    addClientReset(); */
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void infoClientUpdate() {

      //  String uri = getData.path;
      //  uri = uri.replace("\\", "\\\\");

        Date date = new Date();
       java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "UPDATE clientdata SET etat = '"
                + infoclient_etat.getSelectionModel().getSelectedItem() + "', ddSMS = '"
                + infoclient_ddSMS.getValue() +  "', ddReponse = '"
                + infoclient_ddReponse.getValue()  + "', commentaire = '" +  infoclient_commentaire.getText() + "', bdName = '" +  infoclient_bd.getSelectionModel().getSelectedItem()
                +"' WHERE client_id ='"
                + infoclient_clientID.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (infoclient_clientID.getText().isEmpty() || infoclient_etat.getSelectionModel().getSelectedItem() == null
                     /*|| addclient_firstName.getText().isEmpty()
                    || addclient_lastName.getText().isEmpty()
                    || addclient_CIN.getText().isEmpty()
                    || addclient_adresse.getText().isEmpty()
                    || addclient_etat.getSelectionModel().getSelectedItem() == null
                    || addclient_phoneNum1.getText().isEmpty()
                    || addclient_phoneNum2.getText().isEmpty()
                 
                    || getData.path == null || getData.path == ""*/) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE client ID: " + infoclient_clientID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                      infoClientShowListData();
                    infoClientReset();
                    addClientShowListData();
                    addClientReset();
/*
                    double salary = 0;

                    String checkData = "SELECT * FROM client_info WHERE client_id = '"
                            + addclient_clientID.getText() + "'";

                    prepare = connect.prepareStatement(checkData);
                    result = prepare.executeQuery();

                    while (result.next()) {
                        salary = result.getDouble("salary");
                    }

                    String updateInfo = "UPDATE client_info SET firstName = '"
                            + addclient_firstName.getText() + "', lastName = '"
                            + addclient_lastName.getText() + "', position = '"
                            + addclient_etat.getSelectionModel().getSelectedItem()
                            + "' WHERE client_id = '"
                            + addclient_clientID.getText() + "'";

                    prepare = connect.prepareStatement(updateInfo);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    addClientShowListData();
                    addClientReset(); */
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
      public void addClientReset() {
        addclient_clientID.setText("");
       addclient_firstName.setText("");
        addclient_lastName.setText("");
        addclient_CIN.setText("");
        addclient_adresse.setText("");
        addclient_etat.getSelectionModel().clearSelection();
      
        addclient_phoneNum1.setText("");
        addclient_phoneNum2.setText("");
        
    
       // getData.path = "";
    }
       public void infoClientReset() {
  //          Date date = new Date();
  //     java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        infoclient_clientID.setText("");
       infoclient_firstName.setText("");
        infoclient_lastName.setText("");
        infoclient_CIN.setText("");
      //  addclient_adresse.setText("");
     
      infoclient_ddSMS.setValue(null);
      
      infoclient_etat.getSelectionModel().clearSelection();

     infoclient_ddReponse.setValue(null);
      
       infoclient_commentaire.setText("");
       
       infoclient_bd.getSelectionModel().clearSelection();
       // addclient_phoneNum1.setText("");
       // addclient_phoneNum2.setText("");
      
       // getData.path = "";
    }
      private String[] etatList = {"en cours", "Accorder", "Refuser"};
      
      public void addClientEtatList() {
        List<String> listP = new ArrayList<>();

        for (String data : etatList) {
            listP.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listP);
        addclient_etat.setItems(listData);
    }
       public void infoClientEtatList() {
        List<String> listP = new ArrayList<>();

        for (String data : etatList) {
            listP.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listP);
        infoclient_etat.setItems(listData);
    }
      
      public void addClientSearch() {

        FilteredList<clientData> filter = new FilteredList<>(addClientList, e -> true);

        addclient_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateClientData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateClientData.getClientId().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getLastName().toLowerCase().contains(searchKey)) {
                    return true;
                  } else if (predicateClientData.getCIN().toLowerCase().contains(searchKey)) {
                    return true; 
                     } else if (predicateClientData.getAdresse().toLowerCase().contains(searchKey)) {
                    return true;  
                } else if (predicateClientData.getEtat().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getPhoneNumone().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getPhoneNumtwo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getDate().toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<clientData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(addclient_tableView.comparatorProperty());
        addclient_tableView.setItems(sortList);
    } 
           public void infoClientSearch() {

        FilteredList<clientData> filter = new FilteredList<>(infoClientList, e -> true);

        infoclient_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateClientData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateClientData.getClientId().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getLastName().toLowerCase().contains(searchKey)) {
                    return true;
                  } else if (predicateClientData.getCIN().toLowerCase().contains(searchKey)) {
                    return true; 
                    /* } else if (predicateClientData.getAdresse().toLowerCase().contains(searchKey)) {
                    return true; */ 
                } else if (predicateClientData.getEtat().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getPhoneNumone().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getPhoneNumtwo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getDate().toString().contains(searchKey)) {
                    return true;
                    } else if (predicateClientData.getDdSMS().toLowerCase().contains(searchKey)) {
                    return true; 
                    } else if (predicateClientData.getDdReponse().toLowerCase().contains(searchKey)) {
                    return true; 
                    } else if (predicateClientData.getCommentaire().toLowerCase().contains(searchKey)) {
                    return true; 
                     } else if (predicateClientData.getBdName().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<clientData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(infoclient_tableView.comparatorProperty());
        infoclient_tableView.setItems(sortList);
    } 
      
      
   public ObservableList<clientData> addClientListData() {

        ObservableList<clientData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM clientdata";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            clientData clientD;

            while (result.next()) {
                clientD = new clientData(result.getString("client_id"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("CIN"),
                        result.getString("adresse"),
                        result.getString("phoneNumone"),
                        result.getString("phoneNumtwo"),
                        result.getString("etat"),
                     
                        result.getDate("date"));
                listData.add(clientD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
        private ObservableList<clientData> addClientList;
        private ObservableList<clientData> infoClientList;
        
         public ObservableList<clientData> infoClientListData() {

        ObservableList<clientData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM clientdata";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            clientData clientD;

            while (result.next()) {
                clientD = new clientData(result.getString("client_id"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("CIN"),
                        result.getString("phoneNumone"),
                        result.getString("phoneNumtwo"),
                        result.getDate("date"),
                     result.getString("ddSMS"),
                       result.getString("etat"),
                       result.getString("ddReponse"),
                       result.getString("commentaire"),
                result.getString("bdName"));
                listData.add(clientD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
        
public void infoClientShowListData() {
        infoClientList = infoClientListData();

       infoclient_col_clientID.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        infoclient_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        infoclient_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        infoclient_col_CIN.setCellValueFactory(new PropertyValueFactory<>("CIN"));
        infoclient_col_phoneNum1.setCellValueFactory(new PropertyValueFactory<>("phoneNumone"));
        infoclient_col_phoneNum2.setCellValueFactory(new PropertyValueFactory<>("phoneNumtwo"));
        infoclient_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
         infoclient_col_ddSMS.setCellValueFactory(new PropertyValueFactory<>("ddSMS"));
        infoclient_col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
       
        infoclient_col_ddReponse.setCellValueFactory(new PropertyValueFactory<>("ddReponse"));
        infoclient_col_commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        infoclient_col_bd.setCellValueFactory(new PropertyValueFactory<>("bdName"));
        

        infoclient_tableView.setItems(infoClientList);
}

    public void addClientShowListData() {
        addClientList = addClientListData();

        addclient_col_clientID.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        addclient_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addclient_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addclient_col_CIN.setCellValueFactory(new PropertyValueFactory<>("CIN"));
       addclient_col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        addclient_col_phoneNum1.setCellValueFactory(new PropertyValueFactory<>("phoneNumone"));
        addclient_col_phoneNum2.setCellValueFactory(new PropertyValueFactory<>("phoneNumtwo"));
        addclient_col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        addclient_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        addclient_tableView.setItems(addClientList);

    }
    
    public void addClientSelect() {
        clientData clientD = addclient_tableView.getSelectionModel().getSelectedItem();
        int num = addclient_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addclient_clientID.setText(clientD.getClientId());
        addclient_firstName.setText(clientD.getFirstName());
        addclient_lastName.setText(clientD.getLastName());
        addclient_CIN.setText(clientD.getCIN());
        addclient_adresse.setText(clientD.getAdresse());
        addclient_phoneNum1.setText(clientD.getPhoneNumone());
        addclient_phoneNum2.setText(clientD.getPhoneNumtwo());
        

    }
     public void infoClientSelect() {
        clientData clientD = infoclient_tableView.getSelectionModel().getSelectedItem();
        int num = infoclient_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        infoclient_clientID.setText(clientD.getClientId());
        infoclient_firstName.setText(clientD.getFirstName());
       infoclient_lastName.setText(clientD.getLastName());
        infoclient_CIN.setText(clientD.getCIN());
        // addEmployee_employeeID.setText(String.valueOf(employeeD.getEmployeeId()));
        infoclient_ddSMS.setValue(java.time.LocalDate.parse(clientD.getDdSMS()));
      infoclient_ddReponse.setValue(java.time.LocalDate.parse(clientD.getDdReponse()));
         infoclient_commentaire.setText(clientD.getCommentaire());
        //addclient_adresse.setText(clientD.getAdresse());
       // addclient_phoneNum1.setText(clientD.getPhoneNumone());
        //addclient_phoneNum2.setText(clientD.getPhoneNumtwo());
        

    }

    public void displayUsername(){
        
                username.setText(getData.username);

    }
    
    
    
         public void switchForm(ActionEvent event) {
         
          if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            addclient_form.setVisible(false);
            info_form.setVisible(false);
            bd_form.setVisible(false);

            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #ccc9c9, #ccc9c9);");
            addclient_btn.setStyle("-fx-background-color:transparent");
            info_btn.setStyle("-fx-background-color:transparent");
/*
            home_totalclient();
            home_totalaccorder();
            home_totalrefuser();
            homeChart();
             homeTotalRefuser();
        homeTotalAccorder();
        homeTotalClient();
        homeChart();
            
            addClientSearch();
            infoClientSearch();
            availableBDSearch();
            addClientBDList();
*/
 homeTotalRefuser();
        homeTotalAccorder();
        homeTotalClient();
        homeChart();
            infoClientShowListData() ;
            addClientSearch();
            infoClientSearch();
            availableBDSearch();
            addClientBDList();
        } else if (event.getSource() == addclient_btn) {
            home_form.setVisible(false);
            addclient_form.setVisible(true);
           info_form.setVisible(false);
           bd_form.setVisible(false);

            addclient_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #ccc9c9, #ccc9c9);");
            home_btn.setStyle("-fx-background-color:transparent");
            info_btn.setStyle("-fx-background-color:transparent");
            addClientEtatList();
            infoClientEtatList();

          homeTotalRefuser();
        homeTotalAccorder();
        homeTotalClient();
        homeChart();
            
            addClientSearch();
            infoClientSearch();
            availableBDSearch();
            addClientBDList();
infoClientShowListData() ;
        } else if (event.getSource() == info_btn) {
            home_form.setVisible(false);
            addclient_form.setVisible(false);
            info_form.setVisible(true);
            bd_form.setVisible(false);

            info_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #ccc9c9, #ccc9c9);");
            addclient_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
             homeTotalRefuser();
        homeTotalAccorder();
        homeTotalClient();
        homeChart();
            
            addClientSearch();
            infoClientSearch();
            availableBDSearch();
            addClientBDList();

           // salaryShowListData();
infoClientShowListData() ;

 } else if (event.getSource() == bd_btn) {
            home_form.setVisible(false);
            addclient_form.setVisible(false);
            info_form.setVisible(false);
            bd_form.setVisible(true);

            info_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #ccc9c9, #ccc9c9);");
            addclient_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
              addClientSearch();
            infoClientSearch();
            availableBDSearch();
            addClientBDList();
            infoClientShowListData() ;
        }
         
         }
    
    
     private double x = 0;
      private double y = 0;
     public void logout() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    
     }
        public void close() {
        System.exit(0);
    }
   
    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
   // public void toggleFullScreen(Stage stage) {
   //     stage.setFullScreenbtn(!stage.isFullScreen());
   // }
     public void toggleFullScreen(Stage stage) {
        stage.setFullScreen(!stage.isFullScreen());
    }
     
     public void availableBDAdd() {

        String insertData = "INSERT INTO clientbd (bdName,dateCreation,nbMAX) VALUES(?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;

            if (bd_id.getText().isEmpty()
                    || bd_date.getText().isEmpty()
                    || bd_max.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
//            CHECK IF THE COURSE YOU WANT TO INSERT IS ALREADY EXIST!
                String checkData = "SELECT bdName FROM clientbd WHERE bdName = '"
                        + bd_id.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("bdName: " + bd_id.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, bd_id.getText());
                    prepare.setString(2, bd_date.getText());
                    prepare.setString(3, bd_max.getText());

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                availableBDShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableBDClear();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
      
       public void availableBDUpdate() {

      //  String uri = getData.path;
      //  uri = uri.replace("\\", "\\\\");

       

        String sql = "UPDATE clientbd SET dateCreation = '"
                + bd_date.getText() + "', nbMAX = '"
                + bd_max.getText() + /*"', date = '" + sqlDate +*/ "' WHERE bdName ='"
                + bd_id.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (bd_id.getText().isEmpty() 
                     ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE bd: " + bd_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    availableBDListData();
                   //   addClientShowListData();
                    availableBDClear();
                   //  infoClientShowListData();
                     availableBDShowListData();
                   // infoClientReset();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        public void availableBDClear() {
        bd_id.setText("");
        bd_date.setText("");
        bd_max.setText("");
    }
        
         public ObservableList<bdData> availableBDListData() {

        ObservableList<bdData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM clientbd";

        connect = database.connectDb();

        try {
            bdData bdD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                bdD = new bdData(result.getString("bdName"),
                        result.getString("dateCreation"),
                        result.getString("nbMAX"));

                listData.add(bdD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<bdData> availableBDList;

    public void availableBDShowListData() {
        availableBDList = availableBDListData();

        bd_col_id.setCellValueFactory(new PropertyValueFactory<>("bdName"));
        bd_col_date.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
        bd_col_max.setCellValueFactory(new PropertyValueFactory<>("nbMAX"));

        bd_tableView.setItems(availableBDList);

    }

    public void availableBDSelect() {
        bdData bdD = bd_tableView.getSelectionModel().getSelectedItem();
        int num = bd_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        bd_id.setText(bdD.getBdName());
        bd_date.setText(bdD.getDateCreation());
        bd_max.setText(bdD.getNbMAX());

    }
    
      public void availableBDSearch() {

        FilteredList<bdData> filter = new FilteredList<>(availableBDList, e -> true);

        bd_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateClientData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateClientData.getBdName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getDateCreation().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getNbMAX().toString().contains(searchKey)) {
                    return true;
                 /* } else if (predicateClientData.getCIN().toLowerCase().contains(searchKey)) {
                    return true; 
                    } else if (predicateClientData.getAdresse().toLowerCase().contains(searchKey)) {
                    return true; 
                } else if (predicateClientData.getEtat().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getPhoneNumone().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getPhoneNumtwo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateClientData.getDate().toString().contains(searchKey)) {
                    return true;
                    } else if (predicateClientData.getDdSMS().toLowerCase().contains(searchKey)) {
                    return true; 
                    } else if (predicateClientData.getDdReponse().toLowerCase().contains(searchKey)) {
                    return true; 
                    } else if (predicateClientData.getCommentaire().toLowerCase().contains(searchKey)) {
                    return true; */
                } else {
                    return false;
                }
            });
        });

        SortedList<bdData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(bd_tableView.comparatorProperty());
        bd_tableView.setItems(sortList);
    } 
       public void addClientBDList() {

       String listBD = "SELECT * FROM clientbd";

        connect = database.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listBD);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("bdName"));
            }
            infoclient_bd.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }
 /*
         String listBD = "SELECT * FROM clientbd";
    connect = database.connectDb();

    try {
        ObservableList listC = FXCollections.observableArrayList();

        prepare = connect.prepareStatement(listBD);
        result = prepare.executeQuery();

        int nbMax = 0; // Initialize nbMax to 0

        if (result.next()) {
            nbMax = result.getInt("nbMAX"); // Retrieve the nbMAX value from the first row of the result set
        }

        int count = 0;
        while (result.next() && count < nbMax) {
            listC.add(result.getString("bdName"));
            count++;
        }
        infoclient_bd.setItems(listC);

    } catch (Exception e) {
        e.printStackTrace();
    }
           */
    }
    /*
    public void addClientBDList(int nb_max) {
    String listBD = "SELECT * FROM clientbd";
    connect = database.connectDb();

    try {
        ObservableList<String> listC = FXCollections.observableArrayList();

        prepare = connect.prepareStatement(listBD);
        result = prepare.executeQuery();

        int count = 0;
        while (result.next() && count < nb_max) {
            listC.add(result.getString("bdName"));
            count++;
        }
        infoclient_bd.setItems(listC);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addClientShowListData();
        addClientEtatList();
        infoClientShowListData();
        infoClientEtatList();
        homeTotalRefuser();
        homeTotalAccorder();
        homeTotalClient();
        homeChart();
        displayUsername();
        availableBDShowListData();
        availableBDListData();
        addClientBDList();
    }
}
    
    


   