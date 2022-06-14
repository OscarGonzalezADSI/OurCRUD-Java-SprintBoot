package modularidad;

import java.io.File;

public class Modularidad {
	
    public static void createDirectories(String path){
        File directorios = new File(path);
        if (!directorios.exists()) {
            if (directorios.mkdirs()) {
                System.out.println("Multiples directorios fueron creados");
            } else {
                System.out.println("Error al crear directorios");
            }
        }
    }
	
	public static void createProyect(String proyectName) {
        createDirectories("../workspace/"+proyectName+"/src/main/java/com/oigonzalezp/demo/controller");
        createDirectories("../workspace/"+proyectName+"/src/main/java/com/oigonzalezp/demo/interfaces");
        createDirectories("../workspace/"+proyectName+"/src/main/java/com/oigonzalezp/demo/interfaceService");
        createDirectories("../workspace/"+proyectName+"/src/main/java/com/oigonzalezp/demo/model");
        createDirectories("../workspace/"+proyectName+"/src/main/java/com/oigonzalezp/demo/service");
        createDirectories("../workspace/"+proyectName+"/src/main/resources/static");
        createDirectories("../workspace/"+proyectName+"/src/main/resources/templates");
    }
}
