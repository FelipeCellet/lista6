import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivo {

    public List<game> mapeamento(){
        Path arquivo = Paths.get("vendas-games.csv");
        List<game> listagames = new ArrayList<>();

        try{
            Reader reader = Files.newBufferedReader(arquivo);
            CsvToBean<game> csvToBean = new CsvToBeanBuilder(reader).withType(game.class).withIgnoreLeadingWhiteSpace(true).build();
            listagames = csvToBean.parse();
        }catch(IOException e){
            e.printStackTrace();
        }
        return listagames;
    }

    public List<game> filtraPlataforma(List<game> listaGames, String plataforma){
        List<game> listaFiltrada = new ArrayList<>();
        listaGames.stream().filter(str -> plataforma.equals(str.getPlatform())).forEach(str -> listaFiltrada.add(str));
        return listaFiltrada;
    }

    public List<game> filtraEmpresa(List<game> listaGames, String empresa){
        List<game> listaFiltrada = new ArrayList<>();
        listaGames.stream().filter(str -> empresa.equals(str.getPublisher())).forEach(str -> listaFiltrada.add(str));
        return listaFiltrada;
    }}
