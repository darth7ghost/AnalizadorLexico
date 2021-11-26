package Analizer;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author oscar
 */
public class Reporte {
    File file;
    Text txtFile;
    ArrayList<String> reporte = new ArrayList();
    ArrayList<String> reporteToken = new ArrayList();
    ArrayList<String> fileLines;
    String[] tokens;
    
    public Reporte(File file, Text txtFile) {
        this.file = file;
        this.txtFile = txtFile;
        this.fileLines = txtFile.getLines();
    }
    
    public Reporte(File file, Text txtFile, String[] tokens) {
        this.file = file;
        this.txtFile = txtFile;
        this.tokens = tokens;
        this.fileLines = txtFile.getLines();
    }
    
    //--------------REPORTE DE TOKENS
    public void setTokens(String[] t) {
        this.tokens = t;
    }
    
    public ArrayList<String> getReporteToken(){
        int cnt = 0;
        for(String line: txtFile.getLines()){
            for(String t: tokens){
                if(line.contains(t)){
                    reporteToken.add("Resultado línea: " + (cnt+1) + "\t'" + t + "'\ten la posición: " + (line.indexOf(t)+1));
                }
            }
            cnt++;
        }
        return reporteToken;
    }
    
    //--------------REPORTE COMPLETO
    public ArrayList<String> getReporte() {
        reporte.clear();
        reporte.add("#____________COMENTARIOS:\n");
        comentariosSimples();
        comentariosMultiples();
        reporte.add("\n#____________CLASES:\n");
        clases();
        reporte.add("\n#____________CONSTRUCTORES:\n");
        constructores();
        reporte.add("\n#____________ATRIBUTOS:\n");
        atributos();
        reporte.add("\n#____________MÉTODOS:\n");
        metodos();
        reporte.add("\n#____________CONDICIONALES 'if':\n");
        condicionIf();
        condicionElIf();
        reporte.add("\n#____________CONDICIONALES 'switch':\n");
        condicionSwitch();
        reporte.add("\n#____________BUCLES:\n");
        bucles();
        return reporte;
    }
    
    //COMENTARIOS DE LINEA UNICA.
    public ArrayList<Object[]> classComentarioSimple(){
        ArrayList<Object[]> comentarios = new ArrayList();
        int indexComentarioS = -1;
        String comentario = "";
        for (int i = 0; i < fileLines.size(); i++) {
            if(fileLines.get(i).matches("(\\s)+\\/\\/(.)*")){
                indexComentarioS = i+1;
                comentario = fileLines.get(i);
                Object[] com = {indexComentarioS, comentario};
                comentarios.add(com);
            }
        }
        return comentarios;
    }
    
    private void comentariosSimples(){
        ArrayList<Object[]> comentarios = classComentarioSimple();
        for (int i = 0; i < comentarios.size(); i++) {
            Object[] comentario = comentarios.get(i);
            reporte.add("-Comentario simple en la línea [" + comentario[0] + "]:");
            reporte.add((String) comentario[1]);
            reporte.add("");
        }
    }
    
    //COMENTARIOS MULTILINEA.
    public ArrayList<Object[]> classComentarioMultiple(){
        ArrayList<Object[]> comentarios = new ArrayList();
        int indexComentarioM = -1;
        int indexComentarioMF = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).matches("(\\s)*(\\/\\*)(.)*")){
                ArrayList<String> lineasComentadas = new ArrayList();
                indexComentarioM = i+1;
                indexComentarioMF = indexUltimaLinea(indexComentarioM -1, "*/");
                for (int j = indexComentarioM -1; j <= indexComentarioMF; j++) {
                    lineasComentadas.add(fileLines.get(j));
                }
                Object[] comentario = {indexComentarioM, indexComentarioMF, lineasComentadas};
                comentarios.add(comentario);
            }
        }
        return comentarios;
    }
    
    public int indexUltimaLinea(int index, String cadena) {
        int res = -1;
        for (int i = index; i < fileLines.size(); i++) {
            if (fileLines.get(i).contains(cadena)) {
                res = i;
                break;
            }
        }
        return res;
    }
    
    private void comentariosMultiples(){
        ArrayList<Object[]> comentarios = classComentarioMultiple();
        for (int i = 0; i < comentarios.size(); i++) {
            Object[] comentario = comentarios.get(i);
            reporte.add("-Comentario multilínea desde línea [" + comentario[0] + "] hasta línea [" + ((Integer) comentario[1] + 1) + "]:");
            for (Object s : (ArrayList) comentario[2]) {
                reporte.add(s.toString());
            }
            reporte.add("");
            for (int j = ((Integer) comentario[0] - 1); j <= ((Integer) comentario[1]); j++) {
                fileLines.set(j, "");
            }
        }
    }
    
    //CLASES.
    public ArrayList<Object> infoClases(){
        int indexClase = -1;
        String clase = "";
        String tipo = "public";
        ArrayList<Object> data = new ArrayList();
        for (int i = 0; i < fileLines.size(); i++) {
            if(fileLines.get(i).contains("class")){
                indexClase = i+1;
                String[] ignore = {"public", "class", "{"};
                clase = ignoreChar(fileLines.get(i), ignore);
            }
        }
        data.add(indexClase);
        data.add(tipo);
        data.add(clase);
        
        return data;
    }
    
    public String ignoreChar(String w, String[] ignore) {
        String word = "";
        for (String wordToReplace : ignore) {
            w = w.replace(wordToReplace, " ");
        }
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) != ' ') {
                word += w.charAt(i);
            }
        }
        return word;
    }
    
    private void clases() {
        reporte.add("-Clase [" + infoClases().get(2).toString() + "] declarada en línea [" + infoClases().get(0).toString()  + "], de tipo ["
                + infoClases().get(1).toString() + "]\n");
    }
    
    //CONSTRUCTORES.
    private void constructores() {
        ArrayList<Object[]> constructores = infoConstructores();
        for (int i = 0; i < constructores.size(); i++) {
            Object[] constructor = constructores.get(i);
            reporte.add("-Constructor de clase: [" + constructor[2] + "] en linea [" + constructor[0] + "]:");
            if (constructor[1].toString().length() > 2) {
                reporte.add("Parámetros recibidos: " + constructor[1]);
            }
            reporte.add("Finaliza en línea [" + constructor[3] + "]");
            reporte.add("");
        }
    }
    
    public ArrayList<Object[]> infoConstructores() {
        ArrayList<Object[]> constructores = new ArrayList();
        String clase = infoClases().get(2).toString();
        int indexConstructor = -1;
        String parametros = "";
        int limite = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).matches("(\\s)*public(\\s)+" + clase + "(\\s)*(\\()(\\s)*((\\w)*(\\s)+(\\w)*(\\s)*(,)?(\\s)*)*(\\s)*(\\))(\\s)*(\\{)?(\\s)*(.)*(\\s)*(\\})?(\\s)*")) {
                indexConstructor = i + 1;
                int initP = fileLines.get(i).indexOf("(");
                int initF = fileLines.get(i).indexOf(")");
                parametros = "";
                for (int j = initP; j <= initF; j++) {
                    parametros += fileLines.get(i).charAt(j);
                }
                int ind = 0;
                if (fileLines.get(i).indexOf("{") != -1) {
                    ind = fileLines.get(i).indexOf("{");
                }
                limite = llaveUltima(i, ind) + 1;
                Object[] constructor = {indexConstructor, parametros, clase, limite};
                constructores.add(constructor);
            }
        }

        return constructores;
    }
    
    public int llaveUltima(int init, int cInit) {
        int res = -1;
        int keysOpened = 0;
        int keysClosed = 0;
        boolean band = true;
        for (int i = init; i < fileLines.size(); i++) {
            char[] chars = fileLines.get(i).toCharArray();
            if (band) {
                for (int j = cInit; j < chars.length; j++) {
                    if (chars[j] == '{') {
                        keysOpened++;
                    } else if (chars[j] == '}') {
                        keysClosed++;
                    }
                }
            } else {
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == '{') {
                        keysOpened++;
                    } else if (chars[j] == '}') {
                        keysClosed++;
                    }
                }
            }
            band = false;
            if (keysOpened == keysClosed && keysOpened != 0) {
                res = i;
                break;
            }
        }
        return res;
    }
    
    //ATRIBUTOS
    private void atributos() {
        ArrayList<Object[]> propiedades = infoAtributos();
        for (int i = 0; i < propiedades.size(); i++) {
            Object[] atributo = propiedades.get(i);
            reporte.add("-Atributo de tipo: [" + atributo[2] + "] en la linea [" + atributo[0] + "]");
            reporte.add("Modificador de acceso: [" + atributo[1] + "]");

            if (atributo[3].toString().matches("^[A-Za-z]\\w*")) {
                // Es un nombre de variable valida
                reporte.add("Atributo: [" + atributo[3] + "]");
            } else {
                reporte.add("El nombre del atributo en linea [" + atributo[0] + "] no es vlido.");
            }

            if (!atributo[4].equals("Sin valor asignado.")) {

                if (atributo[4].toString().contains("(") && !atributo[4].toString().contains("new")) {
                    reporte.add("Método asignado: [" + atributo[4] + "]");
                } else if (atributo[4].toString().contains("new")) {

                    reporte.add("Nuevo objeto instanciado de tipo: [" + atributo[4].toString().replace("new", "") + "]");

                } else {
                    reporte.add("Valor de asignación: [" + atributo[4] + "]");
                }

            }
            reporte.add("");
        }
    }
    
        public ArrayList<Object[]> infoAtributos() {
        ArrayList<Object[]> propiedades = new ArrayList();
        int indexVariable = -1;
        String modificador = "";
        String tipo = "";
        String nombreV = "";
        String valor = "";
        for (String tipoData : Constant.DATATYPES) {
            for (int i = 0; i < fileLines.size(); i++) {
                if (fileLines.get(i).contains(tipoData) && fileLines.get(i).contains(";")) {
                    //Tenemos que validar que la nomenclatura de la declaración del objeto sea correcta
                    if (fileLines.get(i).matches("(\\s)*[a-z]{0,9}(\\s)+" + tipoData + "(\\s)*.*;")) {
                        if (fileLines.get(i).contains("=")) {
                            //Variable con asignación
                            String[] divideEquals = fileLines.get(i).split("=");
                            indexVariable = i + 1;
                            modificador = tipoDato(fileLines.get(i));
                            if (modificador.length() == 0) {
                                modificador = "public";
                            }
                            tipo = tipoData;
                            String[] ignore1 = {modificador, tipo, "="};
                            nombreV = ignoreChar(divideEquals[0], ignore1);
                            String[] ignore2 = {divideEquals[0], ";", "="};
                            valor = ignoreChar(fileLines.get(i), ignore2);
                            Object[] atributo = {indexVariable, modificador, tipo, nombreV, valor};
                            propiedades.add(atributo);
                        } else {
                            //Variable sin asignación
                            indexVariable = i + 1;
                            modificador = tipoDato(fileLines.get(i));
                            if (modificador.length() == 0) {
                                modificador = "public";
                            }
                            tipo = tipoData;
                            String[] ignore1 = {modificador, tipo, ";"};
                            nombreV = ignoreChar(fileLines.get(i), ignore1);
                            valor = "Sin valor asignado";
                            Object[] atributo = {indexVariable, modificador, tipo, nombreV, valor};
                            propiedades.add(atributo);
                        }
                    }
                }
            }
        }
        return propiedades;
    }
        
    public String tipoDato(String line) {
        String res = "";
        for (String modifier : Constant.DATATYPES) {
            if (line.contains(modifier)) {
                res = modifier;
                break;
            }
        }
        return res;
    }
    
    //MÉTODOS.
    private void metodos() {
        ArrayList<Object[]> metodos = infoMetodos();
        for (int i = 0; i < metodos.size(); i++) {
            Object[] ob = metodos.get(i);
            reporte.add("-Metodo de nombre: [" + ob[3] + "] en linea [" + ob[0] + "]");
            reporte.add("Tipo de retorno: [" + ob[2]  + "]");
            reporte.add("Modificador de acceso: [" + ob[1]  + "]");
            if (ob[4].toString().length() > 2) {
                reporte.add("Parámetros recibidos: " + ob[4]);
            }
            reporte.add("Finaliza en línea: [" + ob[5] + "]");
            reporte.add("");
        }
    }
    
        public ArrayList<Object[]> infoMetodos() {
        ArrayList<Object[]> metodos = new ArrayList();
        int idexMetodo = -1;
        String modificador = "";
        String tipoRetorno = "";
        String nombre = "";
        String parametros = "";
        int limite = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).matches("(\\s)*[a-z]{6,9}(\\s)+[A-za-z]+(\\s)+\\w+(\\s)*(\\()(\\s)*((\\w)*(\\s)+(\\w)*(\\s)*(,)?(\\s)*)*(\\s)*(\\))(\\s)*(\\{)?(\\s)*(.)*(\\s)*(\\})?(\\s)*")) {
                //metodo validado en cuanto sintaxis
                idexMetodo = i + 1;
                modificador = tipoDato(fileLines.get(i));
                int initP = fileLines.get(i).indexOf("(");
                int initF = fileLines.get(i).indexOf(")");
                parametros = "";
                String rest = "";
                for (int j = initP; j <= initF; j++) {
                    parametros += fileLines.get(i).charAt(j);
                }
                for (int j = initF + 1; j < fileLines.get(i).length(); j++) {
                    rest += fileLines.get(i).charAt(j);
                }
                if (parametros.length() > 2) {
                    String[] divide = fileLines.get(i).split(parametros);
                    tipoRetorno = tipoDato(divide[0]);
                } else {
                    tipoRetorno = tipoDato(fileLines.get(i));
                }
                int ind = 0;
                if (fileLines.get(i).indexOf("{") != -1) {
                    ind = fileLines.get(i).indexOf("{");
                }
                limite = llaveUltima(i, ind) + 1;
                String[] ignore = {modificador, tipoRetorno, parametros, rest, "{", "}"};
                nombre = ignoreChar(fileLines.get(i), ignore);
                Object[] method = {idexMetodo, modificador, tipoRetorno, nombre, parametros, limite};
                metodos.add(method);
            }
        }
        return metodos;
    }
        
    //IF.
    private void condicionIf() {
        ArrayList<Object[]> sentencia = infoIf();
        for (int i = 0; i < sentencia.size(); i++) {
            Object[] sentence = sentencia.get(i);
            reporte.add("-Condición if en línea: [" + sentence[0] + "]");
            reporte.add("Validación: " + sentence[2]);
            reporte.add("Finaliza en linea: [" + sentence[1]  + "]");
            reporte.add("");
        }
    }
    
    public ArrayList<Object[]> infoIf() {
        ArrayList<Object[]> sentencias = new ArrayList();
        int indexIf = -1;
        int finIf = -1;
        String sentencia = "";
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).matches("(\\s)*if(\\s)*(\\()(\\s)*(.)+(\\s)*(\\))(\\{?.*)")) {
                //Cumple la expresión regular de un if
                int par1 = fileLines.get(i).indexOf("(");
                int par2 = fileLines.get(i).length();
                if (fileLines.get(i).contains("{")) {
                    int limite = fileLines.get(i).indexOf("{");
                    for (int j = par1; j < limite; j++) {
                        if (fileLines.get(i).charAt(j) == ')') {
                            par2 = j;
                        }
                    }
                } else {
                    for (int j = par1; j < fileLines.get(i).length(); j++) {
                        if (fileLines.get(i).charAt(j) == ')') {
                            par2 = j;
                        }
                    }
                }
                indexIf = i + 1;
                sentencia = "";
                for (int j = par1; j <= par2; j++) {
                    sentencia += fileLines.get(i).charAt(j);
                }
                int ind = 0;
                if (fileLines.get(i).indexOf("{") != -1) {
                    ind = fileLines.get(i).indexOf("{");
                }
                finIf = llaveUltima(i, ind) + 1;
                Object[] sen = {indexIf, finIf, sentencia};
                sentencias.add(sen);
            }
        }
        return sentencias;
    }
    
    //ELIF.
    private void condicionElIf() {
        ArrayList<Object[]> sentencias = infoElIf();
        for (int i = 0; i < sentencias.size(); i++) {
            Object[] sentence = sentencias.get(i);
            reporte.add("-Condición Else-if en línea: [" + sentence[0] + "]");
            reporte.add("Validación: " + sentence[2]);
            reporte.add("Finaliza en linea: [" + sentence[1] + "]");
            reporte.add("");
        }
    }
    
        public ArrayList<Object[]> infoElIf() {
        ArrayList<Object[]> sentencias = new ArrayList();
        int indexElIf = -1;
        int finElIf = -1;
        String sentencia = "";
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).matches("(\\s)*(\\})?(\\s)*else(\\s)+if(\\s)*(\\()(\\s)*(.)+(\\s)*(\\))(\\{?.*)")) {
                //Cumple la expresión regular de un else if
                int par1 = fileLines.get(i).indexOf("(");
                int par2 = fileLines.get(i).length() - 1;
                if (fileLines.get(i).contains("{")) {
                    int limite = fileLines.get(i).indexOf("{");
                    for (int j = par1; j < limite; j++) {
                        if (fileLines.get(i).charAt(j) == ')') {
                            par2 = j;
                        }
                    }
                } else {
                    for (int j = par1; j < fileLines.get(i).length(); j++) {
                        if (fileLines.get(i).charAt(j) == ')') {
                            par2 = j;
                        }
                    }
                }
                indexElIf = i + 1;
                sentencia = "";
                for (int j = par1; j <= par2; j++) {
                    sentencia += fileLines.get(i).charAt(j);
                }
                int ind = 0;
                if (fileLines.get(i).indexOf("{") != -1) {
                    ind = fileLines.get(i).indexOf("{");
                }
                finElIf = llaveUltima(i, ind) + 1;
                Object[] sen = {indexElIf, finElIf, sentencia};
                sentencias.add(sen);
            }
        }
        return sentencias;
    }
    
    //SWITCH.
    private void condicionSwitch() {
        ArrayList<Object[]> sentencia = infoSwitch();
        for (int i = 0; i < sentencia.size(); i++) {
            Object[] sentence = sentencia.get(i);
            reporte.add("-Condición switch en línea: [" + sentence[0] + "]");
            reporte.add("Validación: " + sentence[2]);
            reporte.add("El switch tiene [" + sentence[3] + "] casos.");
            reporte.add("Finaliza en linea: [" + sentence[1] + "]");
            reporte.add("");
        }
    }
    
        public ArrayList<Object[]> infoSwitch() {
        ArrayList<Object[]> sentencias = new ArrayList();
        int indexSwitch = -1;
        int finSwitch = -1;
        String sentencia = "";
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).matches("(\\s)*switch(\\s)*(\\()(\\s)*(.)+(\\s)*(\\))(\\s)*((\\{)(.)*)?")) {
                //Cumple con la expresión regular de un switch
                indexSwitch = i + 1;
                int par1 = fileLines.get(i).indexOf("(");
                int par2 = fileLines.get(i).length() - 1;
                if (fileLines.get(i).contains("{")) {
                    int limite = fileLines.get(i).indexOf("{");
                    for (int j = par1; j < limite; j++) {
                        if (fileLines.get(i).charAt(j) == ')') {
                            par2 = j;
                        }
                    }
                } else {
                    for (int j = par1; j < fileLines.get(i).length(); j++) {
                        if (fileLines.get(i).charAt(j) == ')') {
                            par2 = j;
                        }
                    }
                }
                sentencia = "";
                for (int j = par1; j <= par2; j++) {
                    sentencia += fileLines.get(i).charAt(j);
                }
                int ind = 0;
                if (fileLines.get(i).indexOf("{") != -1) {
                    ind = fileLines.get(i).indexOf("{");
                }
                finSwitch = llaveUltima(i, ind) + 1;
                int casos = 0;
                for (int j = indexSwitch; j < finSwitch; j++) {
                    if (fileLines.get(j).contains("case")) {
                        casos++;
                    }
                }
                Object[] sen = {indexSwitch, finSwitch, sentencia, casos};
                sentencias.add(sen);

            }
        }
        return sentencias;
    }
        
    //BUCLES.
    private void bucles() {
        ArrayList<Object[]> sentencias = infoBucles();
        for (int i = 0; i < sentencias.size(); i++) {
            Object[] sentence = sentencias.get(i);
            reporte.add("Bucle tipo [" + sentence[3] + "] en la linea: [" + sentence[0] + "]");
            reporte.add("Iteración: " + sentence[2]);
            reporte.add("Finaliza en linea: [" + sentence[1] + "]");
            reporte.add("");
        }
    }
    
    public ArrayList<Object[]> infoBucles() {
        ArrayList<Object[]> sentencias = new ArrayList();
        int indexBucle = -1;
        int finBucle = -1;
        String tipo = "";
        String sentencia = "";
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).matches("(\\s)*(for|while|foreach)(\\s)*(\\()(\\s)*(.)+(\\s)*(\\))(\\{?.*)")) {
                //Cumple la expresión regular de un bucle
                int par1 = fileLines.get(i).indexOf("(");
                int par2 = fileLines.get(i).length();
                if (fileLines.get(i).contains("{")) {
                    int limite = fileLines.get(i).indexOf("{");
                    for (int j = par1; j < limite; j++) {
                        if (fileLines.get(i).charAt(j) == ')') {
                            par2 = j;
                        }
                    }
                } else {
                    for (int j = par1; j < fileLines.get(i).length(); j++) {
                        if (fileLines.get(i).charAt(j) == ')') {
                            par2 = j;
                        }
                    }
                }
                indexBucle = i + 1;
                sentencia = "";
                for (int j = par1; j <= par2; j++) {
                    sentencia += fileLines.get(i).charAt(j);
                }
                int ind = 0;
                if (fileLines.get(i).indexOf("{") != -1) {
                    ind = fileLines.get(i).indexOf("{");
                }
                finBucle = llaveUltima(i, ind) + 1;
                if (fileLines.get(i).contains("for")) {
                    tipo = "for";
                } else if (fileLines.get(i).contains("foreach")) {
                    tipo = "foreach";
                } else if (fileLines.get(i).contains("while")) {
                    tipo = "while";
                }
                Object[] sen = {indexBucle, finBucle, sentencia, tipo};
                sentencias.add(sen);
            }
        }
        return sentencias;
    }
}
