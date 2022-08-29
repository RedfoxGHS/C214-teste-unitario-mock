package services;

import org.example.services.ProfessorService;

public class MockProfessorService implements ProfessorService {
    @Override
    public String buscarTodosHorariosDeAtendimentos() {
        return ProfessorConst.LISTA_HORARIOS_PROFESSORES;
    }

    @Override
    public String buscaHorarioPorNome(String nome) {

        if (nome == "Chris")
            return ProfessorConst.PROFESSOR_CHRIS;

        if (nome == "Gabriel")
            return ProfessorConst.PROFESSOR_GABRIEL;

        if (nome == "Uttoni")
            return ProfessorConst.PROFESSOR_UTTONI;

        return ProfessorConst.PROFESSOR_NAO_ENCONTRADO;
    }
}
