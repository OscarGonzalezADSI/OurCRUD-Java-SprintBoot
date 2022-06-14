import modularidad.Modularidad;
import adminFile.AdminFile;
import tablas.Tablas;

public class Main {
	
	private static String cont;
	private static String arch;
	private static String proyectName;

	public static void main(String[] args) {
		Modularidad mod = new Modularidad();
		AdminFile prod = new AdminFile();
		Tablas vista = new Tablas();
		proyectName = "../SprintBoot_crud-main/workspace/CrudSprintBoot";
				
		mod.createProyect(proyectName);
		cont = vista.result();
		arch = proyectName+"/src/main/resources/templates/index.html";
		prod.accion(arch, cont);
	}
	
}
