import java.io.*;
import java.util.ArrayList;
import java.util.List;



class ReadText {
    public static void main(String [] arg) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("C:\\Users\\stefano.belfiore\\IdeaProjects\\Exercise 1\\src\\main\\java\\exercise.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea = "";
            Persona person;
            int index = 1;
            while((linea=br.readLine())!=null){

                person = new Persona(linea);
                if(person.getAge() < 25 && person.getAge()!=0 ){
                System.out.println("Linea "+ index +". nombre: "+ person.name + " poblacion: " + person.city + " edad: " + person.age);
                index += 1;
                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
