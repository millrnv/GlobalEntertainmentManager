package com.example.tallerRecuperativo.model.dato.dao;

import com.example.tallerRecuperativo.model.Actividad;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.INTEGER;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class ActividadDAO {

    public static void agregarActividad(DSLContext query, Actividad actividad) {
        Table<?> tablaActividad = table(name("Actividad"));
        Field<String> nombreActividad = field(name("nombreActividad"), VARCHAR(255));
        Field<Integer> edadMin = field(name("edadMin"), INTEGER);
        Field<String> fecha = field(name("fecha"), VARCHAR(255));
        Field<String> lugar = field(name("lugar"), VARCHAR(255));
        Field<String> duracion = field(name("duracion"), VARCHAR(255));

        query.insertInto(tablaActividad, nombreActividad, edadMin, fecha, lugar, duracion)
                .values(actividad.getNombreActividad(), actividad.getEdadMin(), actividad.getFecha(), actividad.getLugar(), actividad.getDuracion())
                .execute();

    }

    public static List<Actividad> obtenerActividades(DSLContext query) {
        List<Actividad> actividades = new ArrayList<>();
        Result<?> resultados = query.select().from(DSL.table("Actividad")).fetch();
        for (Record resultado : resultados) {
            actividades.add(new Actividad(
                    resultado.get("id", Integer.class),
                    resultado.get("nombreActividad", String.class),
                    resultado.get("edadMin", Integer.class),
                    resultado.get("fecha", String.class),
                    resultado.get("lugar", String.class),
                    resultado.get("duracion", String.class)
            ));
        }
        return actividades;
    }

    public static Actividad obtenerActividadPorId(DSLContext query, int id) {
        Result<?> resultado = query.select().from(DSL.table("Actividad")).where(DSL.field("id").eq(id)).fetch();
        if (!resultado.isEmpty()) {
            Record record = resultado.get(0);
            return new Actividad(
                    record.get("id", Integer.class),
                    record.get("nombreActividad", String.class),
                    record.get("edadMin", Integer.class),
                    record.get("fecha", String.class),
                    record.get("lugar", String.class),
                    record.get("duracion", String.class)
            );
        }
        return null;
    }

    public static void eliminarActividad(DSLContext query, int id) {
        query.deleteFrom(DSL.table("Actividad")).where(DSL.field("id").eq(id)).execute();
    }


}
