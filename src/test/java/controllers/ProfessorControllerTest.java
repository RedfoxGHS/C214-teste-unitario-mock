package controllers;

import org.example.controllers.ProfessorController;
import org.example.models.Professor;
import org.example.services.ProfessorService;
import org.junit.Before;
import org.junit.Test;
import services.MockProfessorService;
import services.ProfessorConst;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProfessorControllerTest {

    ProfessorService professorService;

    ProfessorController professorController;

    @Before
    public void setup() {
        professorService = new MockProfessorService();
        professorController = new ProfessorController(professorService);
    }

    @Test
    public void testBuscaTodosHorariosProfessores() {
        List<Professor> horariosProfessores = professorController.buscarTodosHorariosDeAtendimentos();

        assertEquals(3, horariosProfessores.size());
        assertEquals("Chris", horariosProfessores.get(ProfessorConst.INDEX_CHRIS).getNomeDoProfessor());
        assertEquals("Gabriel", horariosProfessores.get(ProfessorConst.INDEX_GABRIEL).getNomeDoProfessor());
        assertEquals("Uttoni", horariosProfessores.get(ProfessorConst.INDEX_UTTONI).getNomeDoProfessor());
    }

    @Test
    public void testBuscaHorarioChris() {
        Professor professorChris = professorController.buscaHorarioProfessorPorNome("Chris");


        assertEquals("Chris", professorChris.getNomeDoProfessor());
        assertEquals("Terça 15:30 as 17:30", professorChris.getHorarioDeAtendimento());
        assertEquals("integral", professorChris.getPeriodo());
    }

    @Test
    public void testBuscaHorarioGabriel() {
        Professor professorGabriel = professorController.buscaHorarioProfessorPorNome("Gabriel");


        assertEquals("Gabriel", professorGabriel.getNomeDoProfessor());
        assertEquals("Quarta 18:30 as 19:30", professorGabriel.getHorarioDeAtendimento());
        assertEquals("noturno", professorGabriel.getPeriodo());
    }

    @Test
    public void testBuscaHorarioUttoni() {
        Professor professorUttoni = professorController.buscaHorarioProfessorPorNome("Uttoni");


        assertEquals("Uttoni", professorUttoni.getNomeDoProfessor());
        assertEquals("Quinta 10:00 as 12:00", professorUttoni.getHorarioDeAtendimento());
        assertEquals("integral", professorUttoni.getPeriodo());
    }

    @Test
    public void testBuscaHorarioProfessorInvalido() {
        Professor professorInvalido = professorController.buscaHorarioProfessorPorNome("Invalido");

        assertEquals(null, professorInvalido);
    }

    @Test
    public void testBuscaHorarioProfessorComValorNull() {
        Professor professorInvalido = professorController.buscaHorarioProfessorPorNome(null);

        assertEquals(null, professorInvalido);
    }
}
