package services;

public class ProfessorConst {
    public static int INDEX_CHRIS = 0;
    public static int INDEX_GABRIEL = 1;
    public static int INDEX_UTTONI = 2;

    public static String LISTA_HORARIOS_PROFESSORES = "[" +
            "{'nomeDoProfessor': 'Chris','horarioDeAtendimento': 'Terça 15:30 as 17:30', 'periodo':'integral'}, " +
            "{'nomeDoProfessor': 'Gabriel','horarioDeAtendimento': 'Quarta 18:30 as 19:30', 'periodo':'noturno'}, " +
            "{'nomeDoProfessor': 'Uttoni','horarioDeAtendimento': 'Quinta 10:00 as 12:00', 'periodo':'integral'}]";

    public static String PROFESSOR_CHRIS =
            "{'nomeDoProfessor': 'Chris','horarioDeAtendimento': 'Terça 15:30 as 17:30', 'periodo':'integral'}";

    public static String PROFESSOR_GABRIEL =
            "{'nomeDoProfessor': 'Gabriel','horarioDeAtendimento': 'Quarta 18:30 as 19:30', 'periodo':'noturno'}";

    public static String PROFESSOR_UTTONI =
            "{'nomeDoProfessor': 'Uttoni','horarioDeAtendimento': 'Quinta 10:00 as 12:00', 'periodo':'integral'}";

    public static String PROFESSOR_NAO_ENCONTRADO = null;

}
