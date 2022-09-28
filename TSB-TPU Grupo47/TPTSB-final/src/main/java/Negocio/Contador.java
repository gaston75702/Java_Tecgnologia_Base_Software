package Negocio;

import clases.TSBArrayList;

public class Contador {
    private int dosisF;
    private int dosisM;
    private int dosisSN;
    private int dosis1;
    private int dosis2;
    private int dosis3;
    private clases.TSBArrayList<Vacuna> vacunas;

    public Contador() {
        this.dosisF = 0;
        this.dosisM = 0;
        this.dosisSN = 0;
        this.dosis1 =0;
        this.dosis2 =0;
        this.dosis3 =0;
        vacunas = new TSBArrayList<Vacuna>();
    }

    public String getDosisF() {
        String string;
        string = "Cantidad de dosis femenino: " + dosisM;
        return string;
    }

    public String getDosisM() {
        String string;
        string = "Cantidad de dosis masculino: " + dosisM;
        return string;
    }

    public String getDosisSN() {

        String string;
        string = "Cantidad de dosis sin genero:" + dosisSN;
        return string;
    }

    public String getDosis1() {

        String string;
        string = "Cantidad de 1era Dosis: " + dosis1;
        return string;

    }

    public String getDosis2() {
        String string;
        string = "Cantidad de 2da Dosis: " + dosis2;
        return string;

    }

    public String getDosis3() {
        String string;
        string = "Cantidad de 3ra Dosis: " + dosis3;
        return string;

    }

    public void setDosisSexo(String sexo){
        if (sexo.compareTo("F")==0)
            dosisF++;
        else
        if (sexo.compareTo("M")==0)
            dosisM++;
        else
            dosisSN++;
    }

    public void setDosisOrden(String orden){
        if (orden.compareTo("1")==0) dosis1++;
        else
        if (orden.compareTo("2")==0)
            dosis2++;
        else
            dosis3++;
    }

    public void setVacuna(String vacuna){
        for (Vacuna value : this.vacunas) {
            Vacuna vac = (Vacuna) value;
            if (vac.getNombre().compareTo(vacuna) == 0) {
                vac.setCantidad(vac.getCantidad() + 1);
                return;
            }
        }
        Vacuna vac = new Vacuna(vacuna);
        this.vacunas.add(vac);
    }

    public TSBArrayList<Vacuna> getVacunas() {
        return vacunas;
    }

    @Override
    public String toString() {
        return " Contador " +
                " \nCantidad de dosis aplicada a femenino = " + dosisF +
                ", \nCantidad de dosis aplicada a masculino = " + dosisM +
                ", \nCantidad de dosis aplicada a sn = " + dosisSN +
                ", \nCantidad de 1eras dosis aplicadas = " + dosis1 +
                ", \nCantidad de 2das dosis aplicadas = " + dosis2 +
                ", \nCantidad de 3ras dosis aplicadas = " + dosis3 +
                ", \n" + vacunas ;
    }
}
