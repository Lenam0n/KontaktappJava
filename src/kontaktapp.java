import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class kontaktapp {
public static void main(String[] args) {
/* Notes
* -> Regex für Eingabe tests
* -> Try Catch bei falscher eingabe
* -> Ausgabe in json/csv
* */

// Eingabe

  //final String FILENAME = "db.json";

Scanner in = new Scanner(System.in);
ArrayList<HashMap<String, String>> Liste = new ArrayList<>();
//Liste = json_loader();
Liste.add(hashmap_input("name","nachname", "121313131","email"));

// Verarbeitung
while (true){
  menue();
  int menuePunkt = in.nextInt();
  if (menuePunkt == 1) {
    String name = "";
    String nachname = "";
    String telefon = "";
    String email = "";


    while(true){
      System.out.println("Eingabe des Namens");
      name = input_check(in.next(),"name");
      if (name.equals("false")){
        System.out.println("Fehler \n versuche es erneut");
    }else{ break; }
    }

    while(true){
    System.out.println("Eingabe des Nachnamens");
    nachname = input_check(in.next(),"nachname");
    if (nachname.equals("false")){
      System.out.println("Fehler");
    }else{ break; }
    }
    while(true){
    System.out.println("Eingabe der Telefonnummer");
    telefon = input_check(in.next(),"telefon");
    if (telefon.equals("false")){
      System.out.println("Fehler");
    }else{ break; }
    }

    while(true){
    System.out.println("Eingabe der Email");
    email = input_check(in.next(),"email");
    if (email.equals("false")){
      System.out.println("Fehler");
    }else{ break; }
    }

    Liste.add(hashmap_input(name,nachname, telefon,email));
    System.out.println("Wert wurde hinzugefügt \n");

  } else if (menuePunkt == 2) {
  if (Liste.get(0)!= null) {
    int i = 1;
    int j = 1;
    for (HashMap<String, String> map : Liste) {
      System.out.println(i + ": " + map);
      i++;
    }
    System.out.println("Welcher Kontakt soll bearbeitet werden");
    int in_ = in.nextInt();
    for (Map.Entry<String, String> entry : Liste.get(in_ - 1).entrySet()) {
      String key = entry.getKey();
      String value = entry.getValue();
      System.out.println(j + ". " + key + " : " + value);
      j++;
    }
    System.out.println("Welcher Eintrag soll bearbeitet werden");
    int in__ = in.nextInt();

    System.out.println("Was soll der neue Wert sein?");
    String keyToUpdate = "";
    int count = 1;
    for (Map.Entry<String, String> entry : Liste.get(in_ - 1).entrySet()) {
      String key = entry.getKey();
      if (count == in__) {
        keyToUpdate = key;
      }
      count++;
    }

    String in___ = in.next();
    Liste.get(in_ - 1).put(keyToUpdate, in___);
    System.out.println("Wert wurde geupdated \n");

    }
  } else if (menuePunkt == 3) {
    if (Liste.get(0)!= null){
    int i = 1;
    for (HashMap<String, String> map : Liste) {
      System.out.println(i + ": " + map);
      i++;}
    System.out.println("Welcher Kontakt soll gelöscht werden");
    int in_ = in.nextInt();
    Liste.remove(in_);
    }

   }else if (menuePunkt == 4) {
    if (Liste.get(0)!= null){
      for (HashMap<String, String> map : Liste) {
      for (Map.Entry<String, String> entry : map.entrySet()) {
      String key = entry.getKey();
      String value = entry.getValue();
      System.out.println(key.substring(0, 1).toUpperCase() + key.substring(1) + " : " + value);
    }
    System.out.println("----------------------");
  }
  }else { System.out.println("Keine Kontakte eingetragen"); }
  }else if (menuePunkt == 5) {
    System.out.println("BYE BYE");
    break;

  }else { System.out.println("Fehler versuche es erneut \n \n \n \n"); }

  //json_exporter(Liste);
}
}
  
static HashMap<String, String> hashmap_input (String a, String b, String c , String d){
  HashMap<String, String> profil = new HashMap<>();
  profil.put("name",a);
  profil.put("nachname",b);
  profil.put("telefon",c);
  profil.put("E-Mail",d);

  return profil;
}

static void menue (){
  System.out.println("""
          1. Kontakt hinzufügen\s
          2. Kontakt bearbieten\s
          3. Kontakt löschen\s
          4. Alle ausgeben\s
          5. Programm beenden\s""");
}
static String input_check(String a,String b){
  String regex_name = "^[a-zA-Z]+$";
  String regex_nachname = "[a-zA-Z]+$";
  String regex_telefon = "^[0-9]+$";
  String regex_Email = "^[^\\s@]+@[^\\s@]+.[^\\s@]+$";

  switch (b) {
    case "name" -> {
      if (a.matches(regex_name)) {
        return a;
      } else return "false";
    }
    case "nachname" -> {
      if (a.matches(regex_nachname)) {
        return a;
      } else return "false";
    }
    case "telefon" -> {
      if (a.matches(regex_telefon)) {
        return a;
      } else return "false";
    }
    case "email" -> {
      if (a.matches(regex_Email)) {
        return a;
      } else return "false";
    }
    default -> {
      return "false";
    }
  }
}

}

/*
  static ArrayList<HashMap<String, String>> json_loader (){
    Gson gson = new Gson();
    try (FileReader reader = new FileReader("db.json")) {
      ArrayList<HashMap<String,String>> a = gson.fromJson(reader, a.class);
      System.out.println(a);
      return a;
    } catch (Exception e) {
      e.printStackTrace();
      ArrayList<HashMap<String,String>> a = new ArrayList<>();
      return a;
    }

  }*/
/*
static void json_exporter(ArrayList<HashMap<String, String>> a){

  ObjectMapper objectMapper = new ObjectMapper();
  try {
    File file = new File("data.json");
    objectMapper.writeValue(file, a);

  }catch (IOException e) {
      e.printStackTrace();}}


}*/
