package com.example.tallerRecuperativo.model.dato.dao;

import com.example.tallerRecuperativo.model.Cliente;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class ClienteDAO {

    public static void agregarCliente(DSLContext query, Cliente cliente) {
        Table<?> tablaCliente = table(name("Cliente"));
        Field<String> nombre = field(name("nombre"), VARCHAR(255));
        Field<String> email = field(name("email"), VARCHAR(255));
        Field<String> direccion = field(name("direccion"), VARCHAR(255));
        Field<String> nTelefonico = field(name("telefono"), VARCHAR(255));
        Field<String> preferencias = field(name("preferencias"), VARCHAR(255));

        query.insertInto(tablaCliente, nombre,email, direccion, nTelefonico, preferencias)
                .values(cliente.getNombre(), cliente.getEmail(), cliente.getDireccion(), cliente.getnTelefonico(), cliente.getPreferencias())
                .execute();
    }

    public static List<Cliente> obtenerClientes(DSLContext query) {
        List<Cliente> clientes = new ArrayList<>();
        Result<?> resultados = query.select().from(DSL.table("Cliente")).fetch();
        for (Record resultado : resultados) {
            clientes.add(new Cliente(
                    resultado.get("id", Integer.class),
                    resultado.get("nombre", String.class),
                    resultado.get("email", String.class),
                    resultado.get("direccion", String.class),
                    resultado.get("telefono", String.class),
                    resultado.get("preferencias", String.class)
            ));
        }
        return clientes;
    }

    public static Cliente obtenerClientePorId(DSLContext query, int id) {
        Result<?> resultado = query.select().from(DSL.table("Cliente")).where(DSL.field("id").eq(id)).fetch();
        if (!resultado.isEmpty()) {
            Record record = resultado.get(0);
            return new Cliente(
                    record.get("id", Integer.class),
                    record.get("nombre", String.class),
                    record.get("email", String.class),
                    record.get("direccion", String.class),
                    record.get("telefono", String.class),
                    record.get("preferencias", String.class)
            );
        }
        return null;
    }

    public static void eliminarCliente(DSLContext query, int id) {
        query.deleteFrom(table("Cliente")).where(field("id").eq(id)).execute();
    }


}
