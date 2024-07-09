package com.example.tallerRecuperativo.model.dato.dao;

import com.example.tallerRecuperativo.model.Organizador;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class OrganizadorDAO {

    public static void agregarOrganizador(DSLContext query, Organizador organizador) {
        Table<?> tablaOrganizador = table(name("Organizador"));
        Field<String> nombre = field(name("nombre"), VARCHAR(255));
        Field<String> especialidad = field(name("especialidad"), VARCHAR(255));

        query.insertInto(tablaOrganizador, nombre, especialidad)
                .values(organizador.getNombre(), organizador.getEspecialidad())
                .execute();

    }

    public static List<Organizador> obtenerOrganizadores(DSLContext query) {
        List<Organizador> organizadores = new ArrayList<>();
        Result<?> resultados = query.select().from(DSL.table("Organizador")).fetch();
        for (Record resultado : resultados) {
            organizadores.add(new Organizador(
                    resultado.get("id", Integer.class),
                    resultado.get("nombre", String.class),
                    resultado.get("especialidad", String.class)
            ));
        }
        return organizadores;

    }

    public static Organizador obtenerOrganizadorPorId(DSLContext query, int id) {
        Result<?> resultado = query.select().from(DSL.table("Organizador")).where(DSL.field("id").eq(id)).fetch();
        if (!resultado.isEmpty()) {
            Record record = resultado.get(0);
            return new Organizador(
                    record.get("id", Integer.class),
                    record.get("nombre", String.class),
                    record.get("especialidad", String.class)
            );
        }
        return null;
    }

    public static void eliminarOrganizador(DSLContext query, int id) {
        query.deleteFrom(table("Organizador")).where(field("id").eq(id)).execute();
    }




}
