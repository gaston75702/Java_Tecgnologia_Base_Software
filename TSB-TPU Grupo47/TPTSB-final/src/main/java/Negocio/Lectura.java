package Negocio;

import Estructura.TSBHashTableDA;
import clases.TSBArrayList;

import java.io.*;
import java.util.*;

public class Lectura {
    public File file;

    public Lectura(String lectura) {
        this.file = new File(lectura);
    }

    public Lectura() {
    }


    public String leerEncabezado()
    {
        String linea = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
            {
                linea = scanner.nextLine();
                break;
            }

        } catch (FileNotFoundException e) {
            System.out.println("no se pudo leer el archivo ");
        }

        return linea;
    }

    public TSBHashTableDA<String, Departamento> identificarCordoba(String path) throws IOException
    {
        FileReader fr = new FileReader(path);
        BufferedReader br = null;
        br = new BufferedReader(fr);
        String linea;
        boolean esPrimeraLinea = true;
        TSBHashTableDA<String, Departamento> table = new TSBHashTableDA<>(365251);
        while((linea = br.readLine())!=null)
        {
            if (esPrimeraLinea) {
                esPrimeraLinea = false;
                continue;
            }

            String[] arreglo = linea.replace("\"","").split(",");
            if (arreglo[3].contains("14"))
            {
                if (table.get(arreglo[9])==null) {
                    Departamento departamento = new Departamento(arreglo[9], arreglo[8]);
                    table.put(departamento.getCodigo(), departamento);
                    departamento.getContador().setDosisSexo(arreglo[0]);
                    departamento.getContador().setDosisOrden(arreglo[13]);
                    departamento.getContador().setVacuna(arreglo[11]);

                }
                else {
                    Departamento departamento = (Departamento) table.get(arreglo[9]);
                    departamento.getContador().setDosisSexo(arreglo[0]);
                    departamento.getContador().setDosisOrden(arreglo[13]);
                    departamento.getContador().setVacuna(arreglo[11]);
                }
            }
        }
        return table;
    }

    public clases.TSBArrayList<Departamento> identificarDeptos(TSBHashTableDA tabla)
    {

        clases.TSBArrayList departamentos = new TSBArrayList();
        Iterator<Departamento> it = tabla.values().iterator();
        while (it.hasNext())
        {
            departamentos.add(it.next().getNombre());
        }

        return departamentos;

    }

    public Departamento getDepartamento(TSBHashTableDA tabla, String nombre)
    {

        Iterator<Departamento> it = tabla.values().iterator();
        while (it.hasNext())
        {
            Departamento actual = it.next();
            if (actual.getNombre() == nombre)
            {
                return (Departamento) tabla.get(actual.getCodigo());
            }
        }
        return null;
    }

    public Departamento getFiltro(TSBHashTableDA tabla, String codigo , String depto )
    {
        Iterator<Departamento> it = tabla.values().iterator();


        while (it.hasNext())
        {
            Departamento actual = it.next();
            if(actual.getNombre() == depto) {
                if (codigo == "Por Sexo") return actual;
                else
                    if(codigo == "Por dosis") return actual;

                    else {return actual;}
            }
        }

        return null;
    }

    public Collection getAllDepartamentos(TSBHashTableDA tabla) {
        Collection col = null;
        Iterator<Departamento> it = tabla.values().iterator();
        while (it.hasNext())
        {
            Departamento actual = it.next();
            col.add(actual);
        }
        return col;

    }
}
