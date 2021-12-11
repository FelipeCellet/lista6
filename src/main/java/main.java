import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        Arquivo arquivo = new Arquivo();
        List<game> listaGames = new ArrayList<>();
        List<game> listaFiltrada = new ArrayList<>();

        listaGames = arquivo.mapeamento();
        listaFiltrada = arquivo.filtraPlataforma(listaGames,"PS4");


        System.out.println("Lista de jogos de PS4");
        for(game g : listaFiltrada){
            System.out.println(g);
        }
        listaFiltrada =arquivo.filtraEmpresa(listaGames,"Activision");
        System.out.println("Lista de jogos da Activision");
        for(game g : listaFiltrada){
            System.out.println(g);
        }
    }
}
