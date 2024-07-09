package com.example.tallerRecuperativo.model.dato.dao;

import com.example.tallerRecuperativo.model.Entrada;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;


public class EntradaDAO {

    public static void agregarEntrada(DSLContext query, Entrada entrada) {
        Table<?> tablaEntrada = table(name("Entrada"));


    }



}
