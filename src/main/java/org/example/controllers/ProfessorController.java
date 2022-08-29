package org.example.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.example.models.Professor;
import org.example.services.ProfessorService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ProfessorController {

    ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    public List<Professor> buscarTodosHorariosDeAtendimentos() {

        String listaHorariosAtendimentosJson = this.professorService.buscarTodosHorariosDeAtendimentos();

        if (listaHorariosAtendimentosJson == null)
            return new ArrayList<Professor>();

        Gson gson = new Gson();

        Type founderListType = new TypeToken<List<Professor>>() {
        }.getType();

        List<Professor> listaHorariosAtendimentos = gson.fromJson(listaHorariosAtendimentosJson, founderListType);

        return listaHorariosAtendimentos;
    }

    public Professor buscaHorarioProfessorPorNome(String nome) {
        String professorHorarioJson = professorService.buscaHorarioPorNome(nome);

        if (professorHorarioJson == null)
            return null;

        JsonObject jsonObject = JsonParser.parseString(professorHorarioJson).getAsJsonObject();

        Professor professorHorario = new Professor(
                jsonObject.get("nomeDoProfessor").getAsString(),
                jsonObject.get("horarioDeAtendimento").getAsString(),
                jsonObject.get("periodo").getAsString()
        );

        return professorHorario;
    }
}
