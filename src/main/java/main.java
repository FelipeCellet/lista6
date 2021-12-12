
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.util.OpencsvUtils;

import csv.utils.Csv;
import model.Plataform;
import model.Publisher;
import model.game;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Path arquivo = Paths.get("vendas-games.csv");
        List<game> gameList =Csv.mapeamento(arquivo);
        System.out.println("------------------------");
        System.out.println("Lista de jogos de PS4");
        List<game> ps4List =Csv.getByPlataform(gameList, Plataform.PS4);
        ps4List.forEach(e -> System.out.println(e.getName()));
        System.out.println("------------------------");
        System.out.println("Lista de jogos da Activision");
        List<game> activisionList = Csv.getByPublisher(gameList, Publisher.Activision);
        activisionList.forEach(a -> System.out.println(a.getName()));




    }



}
