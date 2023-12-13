/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act2trimestre1_aad;

import com.mysql.jdbc.DatabaseMetaData;
import java.sql.ResultSetMetaData;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Medac
 */
public class BBDD {

    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bbdd_dentista?useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "1234";
    protected static final Component ConsultarCliente = null;

    Connection cn = null;
    Statement stm = null;
    ResultSet Resultado = null;
    
    DefaultTableModel model = new DefaultTableModel();
    JLabel jLabel8;
    

    static {
        try {
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }

    public Connection conectarLabel(JLabel jLabel1) {

        try {
            cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");
            stm = cn.createStatement();
            jLabel1.setText("Conexión OK");

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
            jLabel1.setText("Error en la conexión");
        }

        return cn;
    }
    public Connection conectar() {

        try {
            cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");
            stm = cn.createStatement();

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }

        return cn;
    }

    public void consultar (int tableName, int tipoConsulta, JTable jTable1, JLabel jLabel8) throws SQLException{
        Icon IconoInsertar = new ImageIcon(getClass().getResource("/Iconos/accion.png"));
        String consultaSQL = null;
        String caracter;
        Vector<Object> filas = null;        
        
        switch (tipoConsulta) {
            //Consulta Like
            case 0:
                //Cliente
                switch (tableName) {
                    case 0:
                    {
                        Object[] columnas = {"DNI", "Nombre", "Direccion", "Telefono", "Edad", "Email"};
                        int col = JOptionPane.showOptionDialog(null, "¿En que columna de la tabla quieres realizar la consulta?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        switch (col) {
                            case 0:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where DNI like '"+caracter+"%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where DNI like '%"+caracter+"%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where DNI like '%"+caracter+"';";
                                        break;
                                }
                                break;
                            }
                            case 1:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Nombre like '"+caracter+"%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Nombre like '%"+caracter+"%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Nombre like '%"+caracter+"';";
                                        break;
                                }
                                break;
                            }
                            case 2:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Direccion like '"+caracter+"%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Direccion like '%"+caracter+"%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Direccion like '%"+caracter+"';";
                                        break;
                                }
                                break;
                            }
                            case 3:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Telefono like '"+caracter+"%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Telefono like '%"+caracter+"%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Telefono like '%"+caracter+"';";
                                        break;
                                }
                                break;
                            }
                            case 4:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Edad like '"+caracter+"%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Edad like '%"+caracter+"%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Edad like '%"+caracter+"';";
                                        break;
                                }
                                break;
                            }
                            default:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Email like '"+caracter+"%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Email like '%"+caracter+"%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cliente where Email like '%"+caracter+"';";
                                        break;
                                }
                                break;
                            }
                        }       break;
                    }
                    case 1:
                    {
                        Object[] columnas = {"DNI", "Nombre", "Contraseña", "RolAdmin"};
                        int col = JOptionPane.showOptionDialog(null, "¿En que columna de la tabla quieres realizar la consulta?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        switch (col) {
                            case 0:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where DNI like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where DNI like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where DNI like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 1:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where Nombre like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where Nombre like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where Nombre like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 2:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where Contraseña like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where Contraseña like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where Contraseña like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            default:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where RolAdmin like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where RolAdmin like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.usuario where RolAdmin like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                        }       break;
                    }
                    case 2:
                    {
                        Object[] columnas = {"IdDoctor", "Nombre", "Especialidad_Doctor"};
                        int col = JOptionPane.showOptionDialog(null, "¿En que columna de la tabla quieres realizar la consulta?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        switch (col) {
                            case 0:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.doctor where IdDoctor like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.doctor where IdDoctor like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.doctor where IdDoctor like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 1:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.doctor where Nombre like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.doctor where Nombre like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.doctor where Nombre like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            default:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.doctor where Especialidad_Doctor like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.doctor where Especialidad_Doctor like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.doctor where Especialidad_Doctor like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                        }       break;
                    }
                    case 3:
                    {
                        Object[] columnas = {"idStock", "Nombre", "idProveedor", "Precio"};
                        int col = JOptionPane.showOptionDialog(null, "¿En que columna de la tabla quieres realizar la consulta?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        switch (col) {
                            case 0:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where idStock like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where idStock like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where idStock like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 1:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where Nombre like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where Nombre like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where Nombre like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 2:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where idProveedor like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where idProveedor like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where idProveedor like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            default:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where Precio like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where Precio like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.stock where Precio like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                        }       break;
                    }
                    case 4:
                    {
                        Object[] columnas = {"IdProveedor", "Nombre_Empresa", "Telefono", "Correo_electronico", "Disponibilidad"};
                        int col = JOptionPane.showOptionDialog(null, "¿En que columna de la tabla quieres realizar la consulta?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        switch (col) {
                            case 0:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where IdProveedor like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where IdProveedor like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where IdProveedor like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 1:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Nombre_Empresa like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Nombre_Empresa like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Nombre_Empresa like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 2:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Telefono like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Telefono like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Telefono like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 3:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Correo_electronico like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Correo_electronico like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Correo_electronico like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            default:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Disponibilidad like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Disponibilidad like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.proveedor where Disponibilidad like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                        }       break;
                    }
                    case 5:
                    {
                        Object[] columnas = {"idCita", "DniClientes", "IdDoctor", "IdTratamiento", "Fecha"};
                        int col = JOptionPane.showOptionDialog(null, "¿En que columna de la tabla quieres realizar la consulta?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        switch (col) {
                            case 0:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where idCita like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where idCita like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where idCita like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 1:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where DniClientes like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where DniClientes like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where DniClientes like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 2:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where IdDoctor like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where IdDoctor like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where IdDoctor like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 3:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where IdTratamiento like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where IdTratamiento like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where IdTratamiento like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            default:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where Fecha like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where Fecha like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.cita where Fecha like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                        }       break;
                    }
                    case 6:
                    {
                        Object[] columnas = {"idTratamiento", "Nombre", "Especialidad", "Precio"};
                        int col = JOptionPane.showOptionDialog(null, "¿En que columna de la tabla quieres realizar la consulta?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        switch (col) {
                            case 0:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where idTratamiento like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where idTratamiento like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where idTratamiento like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 1:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where Nombre like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where Nombre like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where Nombre like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 2:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where Especialidad like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where Especialidad like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where Especialidad like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            default:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where Precio like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where Precio like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento where Precio like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                        }       break;
                    }
                    case 7:
                    {
                        Object[] columnas = {"idpedido", "IdMaterial", "IdProveedor", "Cantidad"};
                        int col = JOptionPane.showOptionDialog(null, "¿En que columna de la tabla quieres realizar la consulta?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        switch (col) {
                            case 0:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where idpedido like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where idpedido like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where idpedido like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 1:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where IdMaterial like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where IdMaterial like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where IdMaterial like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            case 2:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where IdProveedor like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where IdProveedor like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where IdProveedor like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                            default:
                            {
                                Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                                int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                                caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                                switch (busq) {
                                    case 0:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where Cantidad like '" + caracter + "%';";
                                        break;
                                    case 1:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where Cantidad like '%" + caracter + "%';";
                                        break;
                                    default:
                                        consultaSQL = "SELECT * FROM bbdd_dentista.pedido where Cantidad like '%" + caracter + "';";
                                        break;
                                }
                                break;
                            }
                        }       break;
                    }
                    case 8:
                    {
                        Object[] columnas = {"idTratamiento"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que que columna de la tabla quieres realizar la consulta?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        if (col == 0) {
                            Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                            int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                            
                            caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                            
                            switch (busq) {
                                case 0:
                                    consultaSQL = "SELECT * FROM bbdd_dentista.factura where idTratamiento like '" + caracter + "%';";
                                    break;
                                case 1:
                                    consultaSQL = "SELECT * FROM bbdd_dentista.factura where idTratamiento like '%" + caracter + "%';";
                                    break;
                                default:
                                    consultaSQL = "SELECT * FROM bbdd_dentista.factura where idTratamiento like '%" + caracter + "';";
                                    break;
                            }
                        }       break;
                    }
                    default:
                    {
                        Object[] columnas = {"idCita", "IdMaterial"};
                        int col = JOptionPane.showOptionDialog(null, "¿En que columna de la tabla quieres realizar la consulta?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        if (col == 0) {
                            Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                            int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                            
                            caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                            
                            switch (busq) {
                                case 0:
                                    consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material where idCita like '" + caracter + "%';";
                                    break;
                                case 1:
                                    consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material where idCita like '%" + caracter + "%';";
                                    break;
                                default:
                                    consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material where idCita like '%" + caracter + "';";
                                    break;
                            }
                        }
                        else {
                            Object[] busqueda = {"Que comience por el caracter...", "Que contenga el caracter...", "Que finalice por el caracter..."};
                            int busq = JOptionPane.showOptionDialog(null, "¿Qué condición de búsqueda vas a utilizar?", "Condición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, busqueda, busqueda[0]);
                            
                            caracter = JOptionPane.showInputDialog("Introduzca los caracteres que se usarán para filtrar la búsqueda:");
                            
                            switch (busq) {
                                case 0:
                                    consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material where IdMaterial like '" + caracter + "%';";
                                    break;
                                case 1:
                                    consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material where IdMaterial like '%" + caracter + "%';";
                                    break;
                                default:
                                    consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material where IdMaterial like '%" + caracter + "';";
                                    break;
                            }
                        }       break;
                    }
                }   break;
            
            //Join
            case 1:
                //Cliente
                switch (tableName) {
                    case 0:
                    {
                        Object[] tabla2 = {"Usuario", "Doctor", "Stock", "Proveedor", "Cita", "Tratamiento", "Pedido", "Factura", "Solicitud_material"};
                        int t2 = JOptionPane.showOptionDialog(null, "¿Con qué tabla deseas realizar la unión?", "CONSULTAR JOIN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, tabla2, tabla2[0]);
                        switch (t2) {
                            case 0:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cliente cross join bbdd_dentista.usuario;";
                                break;
                            case 1:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cliente cross join bbdd_dentista.doctor;";
                                break;
                            case 2:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cliente cross join bbdd_dentista.stock;";
                                break;
                            case 3:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cliente cross join bbdd_dentista.proveedor;";
                                break;
                            case 4:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cliente cross join bbdd_dentista.cita;";
                                break;
                            case 5:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cliente cross join bbdd_dentista.tratamiento;";
                                break;
                            case 6:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cliente cross join bbdd_dentista.pedido;";
                                break;
                            case 7:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cliente cross join bbdd_dentista.factura;";
                                break;
                            default:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cliente cross join bbdd_dentista.solicitud;";
                                break;
                        }
                        break;
                    }
                    case 1:
                    {
                        Object[] tabla2 = {"Cliente", "Doctor", "Stock", "Proveedor", "Cita", "Tratamiento", "Pedido", "Factura", "Solicitud_material"};
                        int t2 = JOptionPane.showOptionDialog(null, "¿Con qué tabla deseas realizar la unión?", "CONSULTAR JOIN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, tabla2, tabla2[0]);
                        switch (t2) {
                            case 0:
                                consultaSQL = "SELECT * FROM bbdd_dentista.usuario cross join bbdd_dentista.cliente;";
                                break;
                            case 1:
                                consultaSQL = "SELECT * FROM bbdd_dentista.usuario cross join bbdd_dentista.doctor;";
                                break;
                            case 2:
                                consultaSQL = "SELECT * FROM bbdd_dentista.usuario cross join bbdd_dentista.stock;";
                                break;
                            case 3:
                                consultaSQL = "SELECT * FROM bbdd_dentista.usuario cross join bbdd_dentista.proveedor;";
                                break;
                            case 4:
                                consultaSQL = "SELECT * FROM bbdd_dentista.usuario cross join bbdd_dentista.cita;";
                                break;
                            case 5:
                                consultaSQL = "SELECT * FROM bbdd_dentista.usuario cross join bbdd_dentista.tratamiento;";
                                break;
                            case 6:
                                consultaSQL = "SELECT * FROM bbdd_dentista.usuario cross join bbdd_dentista.pedido;";
                                break;
                            case 7:
                                consultaSQL = "SELECT * FROM bbdd_dentista.usuario cross join bbdd_dentista.factura;";
                                break;
                            default:
                                consultaSQL = "SELECT * FROM bbdd_dentista.usuario cross join bbdd_dentista.solicitud;";
                                break;
                        }
                        break;
                    }
                    case 2:
                    {
                        Object[] tabla2 = {"Cliente", "Usuario", "Stock", "Proveedor", "Cita", "Tratamiento", "Pedido", "Factura", "Solicitud_material"};
                        int t2 = JOptionPane.showOptionDialog(null, "¿Con qué tabla deseas realizar la unión?", "CONSULTAR JOIN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, tabla2, tabla2[0]);
                        switch (t2) {
                            case 0:
                                consultaSQL = "SELECT * FROM bbdd_dentista.doctor cross join bbdd_dentista.cliente;";
                                break;
                            case 1:
                                consultaSQL = "SELECT * FROM bbdd_dentista.doctor cross join bbdd_dentista.usuario;";
                                break;
                            case 2:
                                consultaSQL = "SELECT * FROM bbdd_dentista.doctor cross join bbdd_dentista.stock;";
                                break;
                            case 3:
                                consultaSQL = "SELECT * FROM bbdd_dentista.doctor cross join bbdd_dentista.proveedor;";
                                break;
                            case 4:
                                consultaSQL = "SELECT * FROM bbdd_dentista.doctor cross join bbdd_dentista.cita;";
                                break;
                            case 5:
                                consultaSQL = "SELECT * FROM bbdd_dentista.doctor cross join bbdd_dentista.tratamiento;";
                                break;
                            case 6:
                                consultaSQL = "SELECT * FROM bbdd_dentista.doctor cross join bbdd_dentista.pedido;";
                                break;
                            case 7:
                                consultaSQL = "SELECT * FROM bbdd_dentista.doctor cross join bbdd_dentista.factura;";
                                break;
                            default:
                                consultaSQL = "SELECT * FROM bbdd_dentista.doctor cross join bbdd_dentista.solicitud;";
                                break;
                        }
                        break;
                    }
                    case 3:
                    {
                        Object[] tabla2 = {"Cliente", "Usuario", "Doctor", "Proveedor", "Cita", "Tratamiento", "Pedido", "Factura", "Solicitud_material"};
                        int t2 = JOptionPane.showOptionDialog(null, "¿Con qué tabla deseas realizar la unión?", "CONSULTAR JOIN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, tabla2, tabla2[0]);
                        switch (t2) {
                            case 0:
                                consultaSQL = "SELECT * FROM bbdd_dentista.stock cross join bbdd_dentista.cliente;";
                                break;
                            case 1:
                                consultaSQL = "SELECT * FROM bbdd_dentista.stock cross join bbdd_dentista.usuario;";
                                break;
                            case 2:
                                consultaSQL = "SELECT * FROM bbdd_dentista.stock cross join bbdd_dentista.doctor;";
                                break;
                            case 3:
                                consultaSQL = "SELECT * FROM bbdd_dentista.stock cross join bbdd_dentista.proveedor;";
                                break;
                            case 4:
                                consultaSQL = "SELECT * FROM bbdd_dentista.stock cross join bbdd_dentista.cita;";
                                break;
                            case 5:
                                consultaSQL = "SELECT * FROM bbdd_dentista.stock cross join bbdd_dentista.tratamiento;";
                                break;
                            case 6:
                                consultaSQL = "SELECT * FROM bbdd_dentista.stock cross join bbdd_dentista.pedido;";
                                break;
                            case 7:
                                consultaSQL = "SELECT * FROM bbdd_dentista.stock cross join bbdd_dentista.factura;";
                                break;
                            default:
                                consultaSQL = "SELECT * FROM bbdd_dentista.stock cross join bbdd_dentista.solicitud;";
                                break;
                        }
                        break;
                    }
                    case 4:
                    {
                        Object[] tabla2 = {"Cliente", "Usuario", "Doctor", "Stock", "Cita", "Tratamiento", "Pedido", "Factura", "Solicitud_material"};
                        int t2 = JOptionPane.showOptionDialog(null, "¿Con qué tabla deseas realizar la unión?", "CONSULTAR JOIN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, tabla2, tabla2[0]);
                        switch (t2) {
                            case 0:
                                consultaSQL = "SELECT * FROM bbdd_dentista.proveedor cross join bbdd_dentista.cliente;";
                                break;
                            case 1:
                                consultaSQL = "SELECT * FROM bbdd_dentista.proveedor cross join bbdd_dentista.usuario;";
                                break;
                            case 2:
                                consultaSQL = "SELECT * FROM bbdd_dentista.proveedor cross join bbdd_dentista.doctor;";
                                break;
                            case 3:
                                consultaSQL = "SELECT * FROM bbdd_dentista.proveedor cross join bbdd_dentista.stock;";
                                break;
                            case 4:
                                consultaSQL = "SELECT * FROM bbdd_dentista.proveedor cross join bbdd_dentista.cita;";
                                break;
                            case 5:
                                consultaSQL = "SELECT * FROM bbdd_dentista.proveedor cross join bbdd_dentista.tratamiento;";
                                break;
                            case 6:
                                consultaSQL = "SELECT * FROM bbdd_dentista.proveedor cross join bbdd_dentista.pedido;";
                                break;
                            case 7:
                                consultaSQL = "SELECT * FROM bbdd_dentista.proveedor cross join bbdd_dentista.factura;";
                                break;
                            default:
                                consultaSQL = "SELECT * FROM bbdd_dentista.proveedor cross join bbdd_dentista.solicitud;";
                                break;
                        }
                        break;
                    }
                    case 5:
                    {
                        Object[] tabla2 = {"Cliente", "Usuario", "Doctor", "Stock", "Proveedor", "Tratamiento", "Pedido", "Factura", "Solicitud_material"};
                        int t2 = JOptionPane.showOptionDialog(null, "¿Con qué tabla deseas realizar la unión?", "CONSULTAR JOIN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, tabla2, tabla2[0]);
                        switch (t2) {
                            case 0:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cita cross join bbdd_dentista.cliente;";
                                break;
                            case 1:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cita cross join bbdd_dentista.usuario;";
                                break;
                            case 2:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cita cross join bbdd_dentista.doctor;";
                                break;
                            case 3:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cita cross join bbdd_dentista.stock;";
                                break;
                            case 4:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cita cross join bbdd_dentista.proveedor;";
                                break;
                            case 5:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cita cross join bbdd_dentista.tratamiento;";
                                break;
                            case 6:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cita cross join bbdd_dentista.pedido;";
                                break;
                            case 7:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cita cross join bbdd_dentista.factura;";
                                break;
                            default:
                                consultaSQL = "SELECT * FROM bbdd_dentista.cita cross join bbdd_dentista.solicitud;";
                                break;
                        }
                        break;
                    }
                    case 6:
                    {
                        Object[] tabla2 = {"Cliente", "Usuario", "Doctor", "Stock", "Proveedor", "Cita", "Pedido", "Factura", "Solicitud_material"};
                        int t2 = JOptionPane.showOptionDialog(null, "¿Con qué tabla deseas realizar la unión?", "CONSULTAR JOIN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, tabla2, tabla2[0]);
                        switch (t2) {
                            case 0:
                                consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento cross join bbdd_dentista.cliente;";
                                break;
                            case 1:
                                consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento cross join bbdd_dentista.usuario;";
                                break;
                            case 2:
                                consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento cross join bbdd_dentista.doctor;";
                                break;
                            case 3:
                                consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento cross join bbdd_dentista.stock;";
                                break;
                            case 4:
                                consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento cross join bbdd_dentista.proveedor;";
                                break;
                            case 5:
                                consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento cross join bbdd_dentista.cita;";
                                break;
                            case 6:
                                consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento cross join bbdd_dentista.pedido;";
                                break;
                            case 7:
                                consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento cross join bbdd_dentista.factura;";
                                break;
                            default:
                                consultaSQL = "SELECT * FROM bbdd_dentista.tratamiento cross join bbdd_dentista.solicitud;";
                                break;
                        }
                        break;
                    }
                    case 7:
                    {
                        Object[] tabla2 = {"Cliente", "Usuario", "Doctor", "Stock", "Proveedor", "Cita", "Tratamiento", "Factura", "Solicitud_material"};
                        int t2 = JOptionPane.showOptionDialog(null, "¿Con qué tabla deseas realizar la unión?", "CONSULTAR JOIN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, tabla2, tabla2[0]);
                        switch (t2) {
                            case 0:
                                consultaSQL = "SELECT * FROM bbdd_dentista.pedido cross join bbdd_dentista.cliente;";
                                break;
                            case 1:
                                consultaSQL = "SELECT * FROM bbdd_dentista.pedido cross join bbdd_dentista.usuario;";
                                break;
                            case 2:
                                consultaSQL = "SELECT * FROM bbdd_dentista.pedido cross join bbdd_dentista.doctor;";
                                break;
                            case 3:
                                consultaSQL = "SELECT * FROM bbdd_dentista.pedido cross join bbdd_dentista.stock;";
                                break;
                            case 4:
                                consultaSQL = "SELECT * FROM bbdd_dentista.pedido cross join bbdd_dentista.proveedor;";
                                break;
                            case 5:
                                consultaSQL = "SELECT * FROM bbdd_dentista.pedido cross join bbdd_dentista.cita;";
                                break;
                            case 6:
                                consultaSQL = "SELECT * FROM bbdd_dentista.pedido cross join bbdd_dentista.tratamiento;";
                                break;
                            case 7:
                                consultaSQL = "SELECT * FROM bbdd_dentista.pedido cross join bbdd_dentista.factura;";
                                break;
                            default:
                                consultaSQL = "SELECT * FROM bbdd_dentista.pedido cross join bbdd_dentista.solicitud;";
                                break;
                        }
                        break;
                    }
                    case 8:
                    {
                        Object[] tabla2 = {"Cliente", "Usuario", "Doctor", "Stock", "Proveedor", "Cita", "Tratamiento", "Pedido", "Solicitud_material"};
                        int t2 = JOptionPane.showOptionDialog(null, "¿Con qué tabla deseas realizar la unión?", "CONSULTAR JOIN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, tabla2, tabla2[0]);
                        switch (t2) {
                            case 0:
                                consultaSQL = "SELECT * FROM bbdd_dentista.factura cross join bbdd_dentista.cliente;";
                                break;
                            case 1:
                                consultaSQL = "SELECT * FROM bbdd_dentista.factura cross join bbdd_dentista.usuario;";
                                break;
                            case 2:
                                consultaSQL = "SELECT * FROM bbdd_dentista.factura cross join bbdd_dentista.doctor;";
                                break;
                            case 3:
                                consultaSQL = "SELECT * FROM bbdd_dentista.factura cross join bbdd_dentista.stock;";
                                break;
                            case 4:
                                consultaSQL = "SELECT * FROM bbdd_dentista.factura cross join bbdd_dentista.proveedor;";
                                break;
                            case 5:
                                consultaSQL = "SELECT * FROM bbdd_dentista.factura cross join bbdd_dentista.cita;";
                                break;
                            case 6:
                                consultaSQL = "SELECT * FROM bbdd_dentista.factura cross join bbdd_dentista.tratamiento;";
                                break;
                            case 7:
                                consultaSQL = "SELECT * FROM bbdd_dentista.factura cross join bbdd_dentista.pedido;";
                                break;
                            default:
                                consultaSQL = "SELECT * FROM bbdd_dentista.factura cross join bbdd_dentista.solicitud;";
                                break;
                        }
                        break;
                    }
                    default:
                    {
                        Object[] tabla2 = {"Cliente", "Usuario", "Doctor", "Stock", "Proveedor", "Cita", "Tratamiento", "Pedido", "Factura"};
                        int t2 = JOptionPane.showOptionDialog(null, "¿Con qué tabla deseas realizar la unión?", "CONSULTAR JOIN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, tabla2, tabla2[0]);
                        switch (t2) {
                            case 0:
                                consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material cross join bbdd_dentista.cliente;";
                                break;
                            case 1:
                                consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material cross join bbdd_dentista.usuario;";
                                break;
                            case 2:
                                consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material cross join bbdd_dentista.doctor;";
                                break;
                            case 3:
                                consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material cross join bbdd_dentista.stock;";
                                break;
                            case 4:
                                consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material cross join bbdd_dentista.proveedor;";
                                break;
                            case 5:
                                consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material cross join bbdd_dentista.cita;";
                                break;
                            case 6:
                                consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material cross join bbdd_dentista.tratamiento;";
                                break;
                            case 7:
                                consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material cross join bbdd_dentista.pedido;";
                                break;
                            default:
                                consultaSQL = "SELECT * FROM bbdd_dentista.solicitud_material cross join bbdd_dentista.factura;";
                                break;
                        }
                        break;
                    }
                }   break;
            //Group by
            default:
            {
            //Cliente
            switch (tableName) {
                case 0:
                    {
                        Object[] columnas = {"DNI", "Nombre", "Direccion", "Telefono", "Edad", "Email"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que columna quieres utilizar para agrupar?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                switch (col) {
                    case 0:
                        consultaSQL = "SELECT count(DNI) as Cantidad, DNI FROM bbdd_dentista.cliente group by DNI;";
                        break;
                    case 1:
                        consultaSQL = "SELECT count(Nombre) as Cantidad, Nombre FROM bbdd_dentista.cliente group by Nombre;";
                        break;
                    case 2:
                        consultaSQL = "SELECT count(Direccion) as Cantidad, Direccion FROM bbdd_dentista.cliente group by Direccion;";
                        break;
                    case 3:
                        consultaSQL = "SELECT count(Telefono) as Cantidad, Telefono FROM bbdd_dentista.cliente group by Telefono;";
                        break;
                    case 4:
                        consultaSQL = "SELECT count(Edad) as Cantidad, Edad FROM bbdd_dentista.cliente group by Edad;";
                        break;
                    default:
                        consultaSQL = "SELECT count(Email) as Cantidad, Email FROM bbdd_dentista.cliente group by Email;";
                        break;
                }
break;
                    }
                case 1:
                    {
                        Object[] columnas = {"DNI", "Nombre", "Contraseña", "RolAdmin"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que columna quieres utilizar para agrupar?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                switch (col) {
                    case 0:
                        consultaSQL = "SELECT count(DNI) as Cantidad, DNI FROM bbdd_dentista.usuario group by DNI;";
                        break;
                    case 1:
                        consultaSQL = "SELECT count(Nombre) as Cantidad, Nombre FROM bbdd_dentista.usuario group by Nombre;";
                        break;
                    case 2:
                        consultaSQL = "SELECT count(Contraseña) as Cantidad, Contraseña FROM bbdd_dentista.usuario group by Contraseña;";
                        break;
                    default:
                        consultaSQL = "SELECT count(RolAdmin) as Cantidad, RolAdmin FROM bbdd_dentista.usuario group by RolAdmin;";
                        break;
                }
break;
                    }
                case 2:
                    {
                        Object[] columnas = {"IdDoctor", "Nombre", "Especialidad_Doctor"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que columna quieres utilizar para agrupar?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                switch (col) {
                    case 0:
                        consultaSQL = "SELECT count(IdDoctor) as Cantidad, IdDoctor FROM bbdd_dentista.doctor group by IdDoctor;";
                        break;
                    case 1:
                        consultaSQL = "SELECT count(Nombre) as Cantidad, Nombre FROM bbdd_dentista.doctor group by Nombre;";
                        break;
                    default:
                        consultaSQL = "SELECT count(Especialidad_Doctor) as Cantidad, Especialidad_Doctor FROM bbdd_dentista.doctor group by Especialidad_Doctor;";
                        break;
                }
break;
                    }
                case 3:
                    {
                        Object[] columnas = {"idStock", "Nombre", "idProveedor", "Precio"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que columna quieres utilizar para agrupar?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                switch (col) {
                    case 0:
                        consultaSQL = "SELECT count(idStock) as Cantidad, idStock FROM bbdd_dentista.stock group by idStock;";
                        break;
                    case 1:
                        consultaSQL = "SELECT count(Nombre) as Cantidad, Nombre FROM bbdd_dentista.stock group by Nombre;";
                        break;
                    case 2:
                        consultaSQL = "SELECT count(idProveedor) as Cantidad, idProveedor FROM bbdd_dentista.stock group by idProveedor;";
                        break;
                    default:
                        consultaSQL = "SELECT count(Precio) as Cantidad, Precio FROM bbdd_dentista.stock group by Precio;";
                        break;
                }
break;
                    }
                case 4:
                    {
                        Object[] columnas = {"IdProveedor", "Nombre_Empresa", "Telefono", "Correo_electronico", "Disponibilidad"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que columna quieres utilizar para agrupar?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                switch (col) {
                    case 0:
                        consultaSQL = "SELECT count(IdProveedor) as Cantidad, IdProveedor FROM bbdd_dentista.proveedor group by IdProveedor;";
                        break;
                    case 1:
                        consultaSQL = "SELECT count(Nombre_Empresa) as Cantidad, Nombre_Empresa FROM bbdd_dentista.proveedor group by Nombre_Empresa;";
                        break;
                    case 2:
                        consultaSQL = "SELECT count(Telefono) as Cantidad, Telefono FROM bbdd_dentista.proveedor group by Telefono;";
                        break;
                    case 3:
                        consultaSQL = "SELECT count(Correo_electronico) as Cantidad, Correo_electronico FROM bbdd_dentista.proveedor group by Correo_electronico;";
                        break;
                    default:
                        consultaSQL = "SELECT count(Disponibilidad) as Cantidad, Disponibilidad FROM bbdd_dentista.proveedor group by Disponibilidad;";
                        break;
                }
break;
                    }
                case 5:
                    {
                        Object[] columnas = {"idCita", "DniClientes", "IdDoctor", "IdTratamiento", "Fecha"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que columna quieres utilizar para agrupar?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                switch (col) {
                    case 0:
                        consultaSQL = "SELECT count(idCita) as Cantidad, idCita FROM bbdd_dentista.cita group by idCita;";
                        break;
                    case 1:
                        consultaSQL = "SELECT count(DniClientes) as Cantidad, DniClientes FROM bbdd_dentista.cita group by DniClientes;";
                        break;
                    case 2:
                        consultaSQL = "SELECT count(IdDoctor) as Cantidad, IdDoctor FROM bbdd_dentista.cita group by IdDoctor;";
                        break;
                    case 3:
                        consultaSQL = "SELECT count(IdTratamiento) as Cantidad, IdTratamiento FROM bbdd_dentista.cita group by IdTratamiento;";
                        break;
                    default:
                        consultaSQL = "SELECT count(Fecha) as Cantidad, Fecha FROM bbdd_dentista.cita group by Fecha;";
                        break;
                }
break;
                    }
                case 6:
                    {
                        Object[] columnas = {"idTratamiento", "Nombre", "Especialidad", "Precio"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que columna quieres utilizar para agrupar?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                switch (col) {
                    case 0:
                        consultaSQL = "SELECT count(idTratamiento) as Cantidad, idTratamiento FROM bbdd_dentista.tratamiento group by idTratamiento;";
                        break;
                    case 1:
                        consultaSQL = "SELECT count(Nombre) as Cantidad, Nombre FROM bbdd_dentista.tratamiento group by Nombre;";
                        break;
                    case 2:
                        consultaSQL = "SELECT count(Especialidad) as Cantidad, Especialidad FROM bbdd_dentista.tratamiento group by Especialidad;";
                        break;
                    default:
                        consultaSQL = "SELECT count(Precio) as Cantidad, Precio FROM bbdd_dentista.tratamiento group by Precio;";
                        break;
                }
break;
                    }
                case 7:
                    {
                        Object[] columnas = {"idpedido", "IdMaterial", "IdProveedor", "Cantidad"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que columna quieres utilizar para agrupar?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                switch (col) {
                    case 0:
                        consultaSQL = "SELECT count(idpedido) as Cantidad, idpedido FROM bbdd_dentista.pedido group by idpedido;";
                        break;
                    case 1:
                        consultaSQL = "SELECT count(IdMaterial) as Cantidad, IdMaterial FROM bbdd_dentista.pedido group by IdMaterial;";
                        break;
                    case 2:
                        consultaSQL = "SELECT count(IdProveedor) as Cantidad, IdProveedor FROM bbdd_dentista.pedido group by IdProveedor;";
                        break;
                    default:
                        consultaSQL = "SELECT count(Cantidad) as Cantidad, Cantidad FROM bbdd_dentista.pedido group by Cantidad;";
                        break;
                }
break;
                    }
                case 8:
                    {
                        Object[] columnas = {"idTratamiento"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que columna quieres utilizar para agrupar?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        if(col == 0){
                            consultaSQL = "SELECT count(idTratamiento) as Cantidad, idTratamiento FROM bbdd_dentista.factura group by idTratamiento;";
                        }   break;
                    }
                default:
                    {
                        Object[] columnas = {"idCita", "IdMaterial"};
                        int col = JOptionPane.showOptionDialog(null, "¿Que columna quieres utilizar para agrupar?", "CONSULTAR COLUMNA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, IconoInsertar, columnas, columnas[0]);
                        if(col == 0){
                            consultaSQL = "SELECT count(idCita) as Cantidad, idCita FROM bbdd_dentista.solicitud_material group by idCita;";
                        }
                        else{
                            consultaSQL = "SELECT count(IdMaterial) as Cantidad, IdMaterial FROM bbdd_dentista.solicitud_material group by IdMaterial;";
                        }   break;
                    }
            }
            }
            break;
        }
                
        
            //Vaciar tabla
            if (model.getRowCount()>0){
                int rows= jTable1.getRowCount();
                for (int a = 1; a<=rows; a++) {
                    model.removeRow(0);
                }
            } 
            
            //Realizar consulta
            Resultado = stm.executeQuery(consultaSQL);

            // Obtener metadatos de la consulta
            ResultSetMetaData metaData = Resultado.getMetaData();
            int columnCount = metaData.getColumnCount();

            String[] columnNames = new String[columnCount];
            // Imprimir los nombres de las columnas
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
                columnNames [i-1]= metaData.getColumnName(i);
                model.setColumnIdentifiers(columnNames);
            }

            jTable1.setModel(model);

            // Imprimir los datos
            while (Resultado.next()) {
                filas = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    filas.add(Resultado.getString(i));
                }
                model.addRow(filas);
            }
            
            jLabel8.setText(consultaSQL);
        }
    

    public void insertar(String tableName, JLabel jLabel8) {
        conectar();
        try {
            DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
            String columnNames = "";

            while (resultSet.next()) {
                String columnName = resultSet.getString("COLUMN_NAME");
                columnNames += columnName + ",";
            }

            columnNames = columnNames.substring(0, columnNames.length() - 1); // Elimina la última coma

            String valores = "";
            String[] columnNamesArray = columnNames.split(",");
            for (int i = 0; i < columnNamesArray.length; i++) {
                String columnName = columnNamesArray[i];
                String valor = JOptionPane.showInputDialog("Ingrese el valor para la columna " + columnName + ":");
                valores += "'" + valor + "'";
                if (i < columnNamesArray.length - 1) {
                    valores += ",";
                }
            }

            Statement statement = cn.createStatement();
            String query = "INSERT INTO " + tableName + " (" + columnNames + ") VALUES (" + valores + ")";
            statement.executeUpdate(query);
            statement.close();
            
            jLabel8.setText("INSERCIÓN COMPLETA\n"+query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrar(String tableName, JLabel jLabel8) {
        try {
            // Utilizar metadatos para obtener información sobre la tabla
            DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
            ResultSet resultSet = metaData.getPrimaryKeys(null, null, tableName);
            String primaryKeyName = "";
            if (resultSet.next()) {
                primaryKeyName = resultSet.getString("COLUMN_NAME");
            }

            // Solicitar al usuario una condición para borrar registros
            String condicion = JOptionPane.showInputDialog("Ingrese la condición para borrar registros de la tabla " + tableName + " (Ejemplo: " + primaryKeyName + " = 5):");

            if (condicion != null && !condicion.isEmpty()) {
                Statement statement = cn.createStatement();
                String query = "DELETE FROM " + tableName + " WHERE " + condicion;
                jLabel8.setText("BORRADO COMPLETO\n"+query);
                
                statement.executeUpdate(query);
                statement.close();

                JOptionPane.showMessageDialog(null, "Se han eliminado los registros que cumplan con la condición:\n" + condicion);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha especificado una condición de borrado. La operación se canceló.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(String tableName, JLabel jLabel8) {
        try {
            // Utilizar metadatos para obtener información sobre la tabla
            DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
            ResultSet resultSet = metaData.getPrimaryKeys(null, null, tableName);
            String primaryKeyName = "";
            if (resultSet.next()) {
                primaryKeyName = resultSet.getString("COLUMN_NAME");
            }

            // Solicitar al usuario una condición para actualizar registros
            String condicion = JOptionPane.showInputDialog("Ingrese la condición para actualizar registros de la tabla " + tableName + " (Ejemplo: " + primaryKeyName + " = 5):");

            if (condicion != null && !condicion.isEmpty()) {
                // Solicitar al usuario un conjunto de valores para actualizar
                String valores = JOptionPane.showInputDialog("Ingrese el conjunto de valores para actualizar (Ejemplo: columna1 = 'nuevo_valor', columna2 = 10):");

                if (valores != null && !valores.isEmpty()) {
                    Statement statement = cn.createStatement();
                    String query = "UPDATE " + tableName + " SET " + valores + " WHERE " + condicion;
                    jLabel8.setText("MODIFICACIÓN COMPLETA\n"+query);
                    
                    statement.executeUpdate(query);
                    statement.close();

                    JOptionPane.showMessageDialog(null, "Se han actualizado los registros que cumplan con la condición:\n" + condicion);
                } else {
                    JOptionPane.showMessageDialog(null, "No se han especificado valores para actualizar. La operación se canceló.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha especificado una condición de actualización. La operación se canceló.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}