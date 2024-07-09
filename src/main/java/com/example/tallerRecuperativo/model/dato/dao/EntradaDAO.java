package com.example.tallerRecuperativo.model.dato.dao;


import com.example.tallerRecuperativo.model.Actividad;
import com.example.tallerRecuperativo.model.Cliente;
import com.example.tallerRecuperativo.model.Entrada;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;
import static org.jooq.impl.SQLDataType.INTEGER;
import static org.jooq.impl.SQLDataType.DOUBLE;



public class EntradaDAO {

    public static void agregarEntrada(DSLContext query, Entrada entrada) {
        Table<?> tablaEntrada = table(name("Entrada"));
        Field<Integer> idActividad = field(name("idActividad"), INTEGER);
        Field<Integer> idCliente = field(name("idCliente"), INTEGER);
        Field<String> tipoEntrada = field(name("tipoEntrada"), VARCHAR(255));
        Field<Integer> disponibilidad = field(name("disponibilidad"), INTEGER);
        Field<Double> precio = field(name("precio"), DOUBLE);

        query.insertInto(tablaEntrada, idActividad, idCliente, tipoEntrada, disponibilidad, precio)
                .values(entrada.getActividad().getId(), entrada.getCliente().getId(), entrada.getTipoEntrada(), entrada.getDisponibilidad(), entrada.getPrecio())
                .execute();


    }

    public static List<Entrada> obtenerEntradas(DSLContext query) {
        List<Entrada> entradas = new ArrayList<>();
        Result<?> resultados = query.select().from(DSL.table("Entrada")).fetch();
        for (Record resultado : resultados) {
            Actividad actividad = ActividadDAO.obtenerActividadPorId(query, resultado.get("idActividad", Integer.class));
            Cliente cliente = ClienteDAO.obtenerClientePorId(query, resultado.get("idCliente", Integer.class));
            entradas.add(new Entrada(
                    resultado.get("id", Integer.class),
                    actividad,
                    cliente,
                    resultado.get("tipoEntrada", String.class),
                    resultado.get("disponibilidad", Integer.class),
                    resultado.get("precio", Double.class)
            ));
        }
        return entradas;

    }

    public static Entrada obtenerEntradaPorId(DSLContext query, int id) {
        Result<?> resultado = query.select().from(DSL.table("Entrada")).where(DSL.field("id").eq(id)).fetch();
        if (!resultado.isEmpty()) {
            Record record = resultado.get(0);
            Actividad actividad = ActividadDAO.obtenerActividadPorId(query, record.get("idActividad", Integer.class));
            Cliente cliente = ClienteDAO.obtenerClientePorId(query, record.get("idCliente", Integer.class));
            return new Entrada(
                    record.get("id", Integer.class),
                    actividad,
                    cliente,
                    record.get("tipoEntrada", String.class),
                    record.get("disponibilidad", Integer.class),
                    record.get("precio", Double.class)
            );
        }
        return null;

    }

    public static void eliminarEntrada(DSLContext query, int id) {
        query.deleteFrom(table("Entrada")).where(field("id").eq(id)).execute();
    }


}
