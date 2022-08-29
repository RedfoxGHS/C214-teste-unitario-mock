package mockito;

import org.example.controllers.ProfessorController;
import org.example.models.Professor;
import org.example.services.ProfessorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import services.ProfessorConst;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProfessorControllerTest {
    @Mock
    private ProfessorService professorService;

    ProfessorController professorController;

    @Before
    public void setup() {
        professorController = new ProfessorController(professorService);
    }

    @Test
    public void testBuscaTodosHorariosProfessores() {
        Mockito.when(professorService.buscarTodosHorariosDeAtendimentos())
                .thenReturn(ProfessorConst.LISTA_HORARIOS_PROFESSORES);

        List<Professor> horariosProfessores = professorController.buscarTodosHorariosDeAtendimentos();

        assertEquals(3, horariosProfessores.size());
        assertEquals("Chris", horariosProfessores.get(ProfessorConst.INDEX_CHRIS).getNomeDoProfessor());
        assertEquals("Gabriel", horariosProfessores.get(ProfessorConst.INDEX_GABRIEL).getNomeDoProfessor());
        assertEquals("Uttoni", horariosProfessores.get(ProfessorConst.INDEX_UTTONI).getNomeDoProfessor());
    }

    @Test
    public void testBuscaTodosHorariosProfessoresComRetornoNull() {
        Mockito.when(professorService.buscarTodosHorariosDeAtendimentos())
                .thenReturn(null);

        List<Professor> horariosProfessores = professorController.buscarTodosHorariosDeAtendimentos();

        assertEquals(0, horariosProfessores.size());
        assertEquals(true, horariosProfessores.isEmpty());
    }

    @Test
    public void testBuscaHorarioChris() {
        String nome = "Chris";
        Mockito.when(professorService.buscaHorarioPorNome(nome)).thenReturn(ProfessorConst.PROFESSOR_CHRIS);

        Professor professorChris = professorController.buscaHorarioProfessorPorNome(nome);


        assertEquals("Chris", professorChris.getNomeDoProfessor());
        assertEquals("Terça 15:30 as 17:30", professorChris.getHorarioDeAtendimento());
        assertEquals("integral", professorChris.getPeriodo());
    }

    @Test
    public void testBuscaHorarioGabriel() {
        String nome = "Gabriel";
        Mockito.when(professorService.buscaHorarioPorNome(nome)).thenReturn(ProfessorConst.PROFESSOR_GABRIEL);

        Professor professorGabriel = professorController.buscaHorarioProfessorPorNome(nome);


        assertEquals("Gabriel", professorGabriel.getNomeDoProfessor());
        assertEquals("Quarta 18:30 as 19:30", professorGabriel.getHorarioDeAtendimento());
        assertEquals("noturno", professorGabriel.getPeriodo());
    }

    @Test
    public void testBuscaHorarioUttoni() {
        String nome = "Uttoni";
        Mockito.when(professorService.buscaHorarioPorNome(nome)).thenReturn(ProfessorConst.PROFESSOR_UTTONI);

        Professor professorUttoni = professorController.buscaHorarioProfessorPorNome(nome);


        assertEquals("Uttoni", professorUttoni.getNomeDoProfessor());
        assertEquals("Quinta 10:00 as 12:00", professorUttoni.getHorarioDeAtendimento());
        assertEquals("integral", professorUttoni.getPeriodo());
    }

    @Test
    public void testBuscaHorarioProfessorInvalido() {
        String nome = "Invalido";
        Mockito.when(professorService.buscaHorarioPorNome(nome)).thenReturn(null);

        Professor professorInvalido = professorController.buscaHorarioProfessorPorNome(nome);

        assertEquals(null, professorInvalido);
    }

    @Test
    public void testBuscaHorarioProfessorComValorNull() {
        Mockito.when(professorService.buscaHorarioPorNome(null)).thenReturn(null);

        Professor professorInvalido = professorController.buscaHorarioProfessorPorNome(null);

        assertEquals(null, professorInvalido);
    }
}
