package csv.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.Plataform;
import model.Publisher;
import model.game;

public class Csv {

    public  static List<game> mapeamento(Path path){
        List<game> listagames = new ArrayList<>();

        try{
            Reader reader = Files.newBufferedReader(path);
            CsvToBean<game> csvToBean = new CsvToBeanBuilder(reader).withType(game.class).withIgnoreLeadingWhiteSpace(true).build();
            listagames = csvToBean.parse();
        }catch(IOException e){
            e.printStackTrace();
        }
        return listagames;
    }

    public  static List<game> getByPlataform(List<game> listaGames, Plataform plataforma){
        List<game> plataformList = new ArrayList<>();
        listaGames.stream().filter((game ->
                        game.getPlatform().equals(plataforma.name()))).
                forEach(game -> plataformList.add(game));
        return plataformList;
    }

    public static List<game> getByPublisher(List<game> listaGames, Publisher publisher){
        List<game> publisherList = new ArrayList<>();
        listaGames.stream().filter((game ->
                        game.getPublisher().equals(publisher.name()))).
                forEach(game ->publisherList.add(game));
        return publisherList;
    }}
