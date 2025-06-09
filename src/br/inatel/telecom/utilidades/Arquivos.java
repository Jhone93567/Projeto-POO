package br.inatel.telecom.utilidades;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public abstract class Arquivos {
    // recebe o caminho, cria uma pasta nesse caminho
    public static void criarPasta (String nomePasta){
        Path caminhoDaPasta = Paths.get(nomePasta);
        try {
            // cria a pasta se ela não existir
            if (!Files.exists(caminhoDaPasta)) {
                Files.createDirectories(caminhoDaPasta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // recebe nome da pasta, do arquivo, e das linhas
    // escreve uma lista de strings no arquivo
    public static void Escrever(String pasta, String nomeArq, List<String> linhas){
        Path caminho = Paths.get(pasta + "/" + nomeArq);
        try {
            // Cria o arquivo se não existir
            if (!Files.exists(caminho)) {
                Files.createFile(caminho);
            }
            Files.write(
                    caminho,
                    linhas,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}