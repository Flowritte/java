package transaccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class transacciones {



        private Connection conexion = null;

        public void trasaccion() throws SQLException {
            try {
                conecta();
                transcaccion();

            }finally {
                cerrar();

            }}

        public void conecta() throws SQLException{
            String jdbc ="jdbc:mysql://localhost:3306/alumnos";
            conexion = DriverManager.getConnection(jdbc,"root","1234");
            conexion.setAutoCommit(false);

        }
        public void transcaccion() throws SQLException { //sentencias tipo prepared
            final String PROFESOR ="INSERT INTO profesores(id_profesor, nombre, apellido) VALUES(?, ?, ?)";
            final String ASIGNATURA ="INSERT INTO asignatura(id_asignatura, nombre, profesor) VALUES(?, ?, ?)";
            PreparedStatement profesor = null;
            PreparedStatement asignatura = null;
            try {
                profesor = conexion.prepareStatement(PROFESOR);

                profesor.setInt(1, 50);
                profesor.setString(2, "Pepito");
                profesor.setString(3, "Perez");
                profesor.executeUpdate();

                asignatura = conexion.prepareStatement(ASIGNATURA);
                asignatura.setInt(1, 100);
                asignatura.setString(3,"Fundamentos de Base De Datos");
                asignatura.setInt(3,50);
                asignatura.executeUpdate();

                conexion.commit();
                System.out.println("Ejecutado");

            }catch (SQLException e){
                conexion.rollback();
                e.printStackTrace();
            }finally {
                if(profesor != null){
                    profesor.close();
                }
                if(asignatura != null){
                    profesor.close();
                }
            }
        }
        public void cerrar() throws SQLException{
            if(conexion != null){
                conexion.close();
            }
        }
        public static void main(String[] args) {
            try {
                new preparestatement();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }

    }


