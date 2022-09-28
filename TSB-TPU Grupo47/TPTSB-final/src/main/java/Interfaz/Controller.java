package Interfaz;

import Estructura.TSBHashTableDA;
import Negocio.Departamento;
import Negocio.Lectura;
import javafx.beans.Observable;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class Controller {

    @FXML
    public ComboBox cbDepartamento;
    @FXML
    public ComboBox cbFIltro;
    @FXML
    public ListView lvSeleccionados;
    @FXML
    public Label lblDepto;
    @FXML
    public Button btnCargarDatos;
    @FXML
    public Label lblOne;
    @FXML
    public Label lblTwo;
    @FXML
    public Label lblTree;
    @FXML
    private Label lblUbicacion;

    public Lectura lectura;

    public TSBHashTableDA tabla;



    public void cargarDatos(ActionEvent actionEvent) throws IOException {
        ObservableList ob;
        lectura = new Lectura(lblUbicacion.getText() + "datos_nomivac_covid19.csv");
        tabla = lectura.identificarCordoba("C:/Users/Andrés/Facu/3.TSB/TP/datos_nomivac_covid19.csv");
        clases.TSBArrayList<Departamento> lista = lectura.identificarDeptos(tabla);
        ob = FXCollections.observableArrayList(lista);// aca hay que agregar un string que diga "Todos"
        cbDepartamento.setItems(ob);
        ob = FXCollections.observableArrayList("Por Dosis","Por Sexo","Por Vacuna");
        cbFIltro.setItems(ob);

    }

    public void cambiarDatos(ActionEvent actionEvent) {
        DirectoryChooser dc = new DirectoryChooser();
        File file = dc.showDialog(null);
        dc.setTitle("Seleccione ubicaion de los datos ");
        dc.setInitialDirectory(new File(lblUbicacion.getText()));
        if (file != null) {
            lblUbicacion.setText(file.getPath());
        }
    }



    public void filtrarFiltros(ActionEvent actionEvent) {
        Departamento col = lectura.getFiltro(tabla, (String) cbFIltro.getValue(),(String) cbDepartamento.getValue());
        ObservableList ol = null;
        if ((String) cbFIltro.getValue() == "Por Sexo"){

            ol = FXCollections.observableArrayList(col.getContador().getDosisF(),col.getContador().getDosisM(),col.getContador().getDosisSN());
        }
        else {
            if (((String) cbFIltro.getValue() == "Por Dosis"))
            {
                ol = FXCollections.observableArrayList(col.getContador().getDosis1(),col.getContador().getDosis2(),col.getContador().getDosis3());
            }
            else
            {
                ol = FXCollections.observableArrayList(col.getContador().getVacunas());
            }
        }

        lvSeleccionados.setItems(ol);
    }


    public void comboChanged(ActionEvent event)
    {
        String elegido = (String) cbDepartamento.getValue();
        ObservableList ol;

        if (elegido == "Todos")
        {
            Collection col = lectura.getAllDepartamentos(tabla);
            ol = FXCollections.observableArrayList(col);


        }
        else {Departamento col = lectura.getDepartamento(tabla,elegido);
            ol = FXCollections.observableArrayList(col);}
        lvSeleccionados.setItems(ol);

    }
}