package pl.akai;

import java.util.*;

public class Main {

    private static String[] sentences = {
            "Taki mamy klimat",
            "Wszędzie dobrze ale w domu najlepiej",
            "Wyskoczył jak Filip z konopii",
            "Gdzie kucharek sześć tam nie ma co jeść",
            "Nie ma to jak w domu",
            "Konduktorze łaskawy zabierz nas do Warszawy",
            "Jeżeli nie zjesz obiadu to nie dostaniesz deseru",
            "Bez pracy nie ma kołaczy",
            "Kto sieje wiatr ten zbiera burzę",
            "Być szybkim jak wiatr",
            "Kopać pod kimś dołki",
            "Gdzie raki zimują",
            "Gdzie pieprz rośnie",
            "Swoją drogą to gdzie rośnie pieprz?",
            "Mam nadzieję, że poradzisz sobie z tym zadaniem bez problemu",
            "Nie powinno sprawić żadnego problemu, bo Google jest dozwolony"
    };

    public static void main(String[] args) {
        /* TODO Twoim zadaniem jest wypisanie na konsoli trzech najczęściej występujących słów
                w tablicy 'sentences' wraz z ilością ich wystąpień..

                Przykładowy wynik:
                1. "mam" - 12
                2. "tak" - 5
                3. "z" - 2
        */
        Map<String,Integer> map=creatMap();
        findThreeMaxValue(map);


    }

    public static Map<String, Integer> creatMap(){
        Map<String, Integer> map = new TreeMap<>();
        for (String text : sentences) {
            text = text.toLowerCase(Locale.ROOT);
            text = text.replaceAll(",", "").replaceAll("\\?", "");
            for (String word : text.split(" ")) {
                if (map.containsKey(word)) {
                    int x = map.get(word);
                    map.put(word, x + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }
        return map;
    }
    public static void findThreeMaxValue(Map<String,Integer> map){
        String text=findMaxValue(map);
        System.out.println("\""+text+"\" - "+map.get(text));
        map.remove(text);
        text=findMaxValue(map);
        System.out.println("\""+text+"\" - "+map.get(text));
        map.remove(text);
        text=findMaxValue(map);
        int max=map.get(text);
        while (max==map.get(text)){
            System.out.println("\""+text+"\" - "+map.get(text));
            map.remove(text);
            text=findMaxValue(map);
        }



    }
    public static String findMaxValue(Map<String,Integer> map){
        int max=0;
        String text="";
        Set<String> keys = map.keySet();
        for (String key : keys) {
            if (map.get(key)>max){
                max=map.get(key);
                text=key;
            }
        }
        return text;

    }
}