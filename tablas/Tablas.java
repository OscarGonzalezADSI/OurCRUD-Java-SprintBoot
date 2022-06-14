package tablas;

import java.util.ArrayList;
import java.util.List;

public class Tablas {
    
    private static List<String> myList = new ArrayList<String>();
    private static List<String> cols = new ArrayList<String>();
    private static List<String> spaces = new ArrayList<String>();
    private static String moduleSing;
	private static String modulePlur;
	private static String primary;
		
    public static void moduleName() {
		moduleSing = "persona";
		modulePlur = "personas";
		primary = "id";
    }
   
    public static void colsTitles() {           
        cols.add(primary);
        cols.add("nombre");
        cols.add("telefono");
    }
      
    public static void datosSalida(String salida) {
        System.out.println(salida);
    }
	
    public static void spacesFormat() {
		String space;
		for(int i=0; i<25; i++){
			space = "";
			for(int ii=0; ii<i; ii++){
				space = space.concat(" ");
			}
			spaces.add(space);
		}
    }
	
    public static String celda(String dato) {
        String outText = spaces.get(9);
        outText =  outText.concat("<td>"+dato+"</td>\n");
        return outText;
    }
    
    public static String bodyCell(String dato) {
        String outText = spaces.get(9);
        outText = outText.concat("<td ")
		                 .concat("th:text=\"${")
		                 .concat(moduleSing)
		                 .concat(".")
		                 .concat(dato)
		                 .concat("}\">")
		                 .concat("</td>\n");
        return outText;
    }
    
    public static String row() {
        String miFila = "";
        String res = "";
        for (String s :cols) {
            miFila = miFila.concat(bodyCell(s));
        }
        res = "      <tbody>\n        ";
        res = res.concat("<tr th:each=\"")
                 .concat(moduleSing)
                 .concat(":${")
                 .concat(modulePlur)
                 .concat("}\">\n")
		         .concat(miFila)
		         .concat(btn())
		         .concat(spaces.get(7))
		         .concat("</tr>\n")
		         .concat(spaces.get(5))
		         .concat("</tbody>");
		return res;
    }
    
	public static String btn() {
        String myBtns =  spaces.get(9);
	    myBtns = myBtns.concat("<td>\n")
	    .concat(spaces.get(11))
	    .concat("<a th:href=\"@{/editar/}+${")
	    .concat(moduleSing)
	    .concat(".")
	    .concat(primary)
	    .concat("}\" ")
	    .concat("class=\"btn btn-warning\">\n")
	    .concat(spaces.get(15))
	    .concat("Editar")
	    .concat("\n")
	    .concat(spaces.get(11))
	    .concat("</a>\n")
	    .concat(spaces.get(9))
	    .concat("</td>\n")
	    .concat(spaces.get(9))
	    .concat("<td>\n")
	    .concat(spaces.get(11))
		.concat("<a th:onclick=\"eliminar([[${")
		.concat(moduleSing)
		.concat(".")
		.concat(primary)
		.concat("}]])\" ")
		.concat("class=\"btn btn-danger\">")
		.concat("\n")
		.concat(spaces.get(15))
		.concat("Eliminar")
	    .concat("\n")
	    .concat(spaces.get(11))
	    .concat("</a>\n")
	    .concat(spaces.get(9))
		.concat("</td>\n");
        return myBtns;
    }
	
    public static String rowTitles() {
        String miFila = "";
        String res = "";
        for (String s :cols) {
            miFila = miFila.concat(celda(s));
        }
		res = res.concat(spaces.get(5))
		        .concat("<thead>\n")
		        .concat(spaces.get(7))
		        .concat("<tr>\n")
		        .concat(miFila)
				.concat(spaces.get(9))
			    .concat("<td></td>\n")
				.concat(spaces.get(9))
			    .concat("<td></td>\n")
		        .concat(spaces.get(7))
		        .concat("</tr>\n")
		        .concat(spaces.get(5))
		        .concat("</thead>");
        return res;
    }
    
    public static String tabla(String dato) {
        String outText = "\n    <table class=\"table\">\n"+dato+"\n    </table>";
        return outText;
    }
    
    public static String html(String dato) {
        String outText = "\n<!DOCTYPE html>";
        outText = outText.concat("\n<html xmlns:th=\"http://www.thymeleaf.org\">")
        .concat("\n<head>")
        .concat("\n  <meta charset=\"ISO-8859-1\">")
        .concat("\n  <title>titulo</title>")
        .concat("\n  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">")
        .concat("\n</head>")
        .concat("\n<body>")
        .concat("\n  <div class=\"container mt-4\">")
        .concat("\n    <a th:href=\"@{/nuevo}\" class=\"btn btn-primary\">Nuevo</a>")
        .concat(dato)
        .concat("\n  </div>")
        .concat("\n</body>")
        .concat("\n<script src=\"https://code.jquery.com/jquery-3.6.0.js\" integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\" crossorigin=\"anonymous\"></script>")
        .concat("\n<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>")
        .concat("\n<script src=\"funciones.js\"></script>")
        .concat("\n</html>");
        
        return outText;
    }
 
    public static String result() {
        String salida;
		spacesFormat();
		moduleName();
        colsTitles();
        salida = rowTitles()
                 .concat("\n")
                 .concat(row());
        datosSalida(html(tabla(salida)));
		return html(tabla(salida));
    }
}
