package com.example.tallerRecuperativo.model.dato;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.foreignKey;
import static org.jooq.impl.DSL.primaryKey;
import static org.jooq.impl.SQLDataType.INTEGER;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException{

        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablaActividad(create);
        crearTablaCliente(create);
        crearTablaOrganizador(create);
        crearTablaEntrada(create);
        DBConnector.closeConnection();

    }

    private static void crearTablaActividad(DSLContext create) {
        create.createTableIfNotExists("Actividad")
                .column("id", INTEGER.identity(true))
                .column("nombre", VARCHAR(255))
                .column("fecha", VARCHAR(255))
                .column("hora", VARCHAR(255))
                .column("lugar", VARCHAR(255))
                .column("precio", INTEGER)
                .column("organizador", VARCHAR(255))
                .constraint(primaryKey("id")).execute();


    }

    private static void crearTablaCliente(DSLContext create) {
        create.createTableIfNotExists("Cliente")
                .column("id", INTEGER.identity(true))
                .column("nombre", VARCHAR(255))
                .column("apellido", VARCHAR(255))
                .column("edad", INTEGER)
                .column("email", VARCHAR(255))
                .column("telefono", VARCHAR(255))
                .constraint(primaryKey("id")).execute();

    }

    private static void crearTablaOrganizador(DSLContext create) {
        create.createTableIfNotExists("Organizador")
                .column("id", INTEGER.identity(true))
                .column("nombre", VARCHAR(255))
                .column("apellido", VARCHAR(255))
                .column("email", VARCHAR(255))
                .column("telefono", VARCHAR(255))
                .constraint(primaryKey("id")).execute();

    }

    private static void crearTablaEntrada(DSLContext create) {
        create.createTableIfNotExists("Entrada")
                .column("id", INTEGER.identity(true))
                .column("cliente", VARCHAR(255))
                .column("actividad", VARCHAR(255))
                .column("fecha", VARCHAR(255))
                .column("hora", VARCHAR(255))
                .column("precio", INTEGER)
                .constraint(primaryKey("id")).execute();

    }



    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection, String nombreBD) {
        DBConnector.closeConnection();
        connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }














    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion) {
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }

    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna) {
        create.alterTableIfExists(nombreTabla).addColumn(columna, tipoColumna);
    }







}
