package adminFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminFile {
    
    public static int createFile(String cont, String arch) {
        int res = 0;
        try {
            FileWriter myWriter = new FileWriter(arch);
            myWriter.write(cont);
            myWriter.close();
            res = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static String readFile(String arch, String mensErrL) {
        String data = "";
        try {
            File myObj = new File(arch);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = data.concat(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            data = mensErrL;
            e.printStackTrace();
        }
        return data;
    }
    
    public static String getFileInfo(String arch, String mensErrL) {
        String outText = "";
        File myObj = new File(arch);
        if (myObj.exists()) {
            outText = outText.concat("\n---------------------------------")
                             .concat("\nFile name: " + myObj.getName())
                             .concat("\n---------------------------------")
                             .concat("\nAbsolute path: " + myObj.getAbsolutePath())
                             .concat("\n---------------------------------")
                             .concat("\nWriteable: " + myObj.canWrite())
                             .concat("\nReadable: " + myObj.canRead())
                             .concat("\nFile size in bytes: " + myObj.length())
                             .concat("\n---------------------------------");
        } else {
            outText = mensErrL;
        }
        return outText;
    }
    
	public static void accion(String arch, String cont) {
        String mens = "archivo creado satisfactoriamente.\n";
        String mensErr = "Error al intentar crear el archivo.";
        String mensErrL = "Error al intentar leer el archivo.";
        String outText = "";
        int res = createFile(cont, arch);
        if(res == 1) {
            outText = outText.concat(mens)
                             .concat(readFile(arch, mensErr))
                             .concat(getFileInfo(arch, mensErrL));
            System.out.println(outText);
        }else{
            System.out.println(mensErr);
        }
    }
}
