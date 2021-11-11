public class Persona {
    String name;
    String city;
    int age;

    public Persona(String linea){
        String[] line = linea.split(":");
        this.name = line[0];



       if(line.length==2){
            this.age=0;

        }
        else {
            this.age = Integer.parseInt(line[2]);
        }
       if (line[1] == ""){
           this.city = "Desconocida";
       }else{
           this.city=line[1];
       }

    }
    public int getAge (){return age;};
}
