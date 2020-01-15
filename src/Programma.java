import java.sql.Time;

public class Programma {
    private int ProgrammaID;
    private SerieFilm serieFilm;
    private String Aflevering;
    private String Titel;
    private Time tijdsduur;


    public Programma(int programmaID, SerieFilm serieFilm, String aflevering, String titel, Time tijdsduur) {
        ProgrammaID = programmaID;
        this.serieFilm = serieFilm;
        Aflevering = aflevering;
        Titel = titel;
        this.tijdsduur = tijdsduur;
    }
}
