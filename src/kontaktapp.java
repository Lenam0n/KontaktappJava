import java.util.*;

public class kontaktapp {
public static void main(String[] args) {
/* Notes
* -> Regex für Eingabe tests
* -> Try Catch bei falscher eingabe
* */



// Eingabe
Scanner in = new Scanner(System.in);
ArrayList<HashMap<String, String>> Liste = new ArrayList<>();

Liste.add(hashmap_input("name","nachname", "121313131","email"));

// Verarbeitung
while (true){
menue();
int menuePunkt = in.nextInt();
if (menuePunkt == 1) {
System.out.println("Eingabe des Namens");
String name = in.next();
System.out.println("Eingabe des Nachnamens");
String nachname = in.next();
System.out.println("Eingabe der Telefonnummer");
String telefon = in.next();
System.out.println("Eingabe der Email");
String email = in.next();

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

//wie bekomme ich den Key von dem Wert den ich ändere raus?

System.out.println("Was soll der neue Wert sein?");
String s = (String) Liste.get(in_ - 1).keySet().toArray()[in__];
String keyToUpdate = "";
int count = 1;
for (Map.Entry<String, String> entry : Liste.get(in_ - 1).entrySet()) {
String key = entry.getKey();
String value = entry.getValue();
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
}else {
System.out.println("Keine Kontakte eingetragen");
}

}else if (menuePunkt == 5) {
System.out.println("BYE BYE");
break;

}else { System.out.println("Fehler versuche es erneut \n \n \n \n"); }
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
System.out.println("1. Kontakt hinzufügen" +
"2. Kontakt bearbieten \n" +
"3. Kontakt löschen \n" +
"4. Alle ausgeben \n" +
"5. Programm beenden ");
}
}