package file;

import model.Partie;
import facade.ResultatService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class FileResultatService implements ResultatService {
    @Override
    public void saveResultat(Partie partie) {
        Date date = new Date();
        try {
			File file = new File("./carbonit-"+date.getTime()+".txt");
            System.out.println("Ecriture du resultat dans le fichier "+file.getName()+"\n");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(partie.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
