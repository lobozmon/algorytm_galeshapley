import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Malzenstwo {

    public void Dopasowanie(int[][] men, int[][] women) {
        HashMap<Integer, Integer> pary = findCouples(men, women);
        Set<Integer> set = pary.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            System.out.println(key + " + " + pary.get(key));
        }
    }

    public HashMap<Integer, Integer> findCouples(int men[][], int women[][]) {

        Set<Integer> kawalerzy = new HashSet<>();
        for (int i = 0; i < men.length; i++) {
            kawalerzy.add(i);
        }

        int iloscKawalerow = kawalerzy.size();

        HashMap<Integer, Integer> pary = new HashMap<Integer, Integer>();
        for (int i = 0; i < women.length; i++) {
            pary.put(i, null);
        }


        while (iloscKawalerow > 0) {

            int kawaler = kawalerzy.iterator().next();

            for (int kobiety = 0; kobiety < men[kawaler].length; kobiety++) {
                if (pary.get(kobiety) == null) {
                    pary.put(kobiety, kawaler);
                    kawalerzy.remove(kawaler);
                    break;
                } else {
                    int aktualnyMezczyzna = pary.get(kobiety);

                    if (zmianaPartnera(kawaler, aktualnyMezczyzna, kobiety, women)){
                        pary.put(kobiety, kawaler);
                        kawalerzy.add(aktualnyMezczyzna);
                        kawalerzy.remove(kawaler);
                        break;
                    }

                }

            }
            iloscKawalerow = kawalerzy.size();

        }


        return pary;
    }

    private boolean zmianaPartnera(int kawaler, int aktualnyMezczyzna, int kobiety, int[][] women) {
        int pref_kawaler = -1;
        int pref_aktualnyMezczyzna = -1;

        for (int i = 0; i <women[kobiety].length ; i++) {

            if(women[kobiety][i]==kawaler)
                pref_kawaler = i;

            if(women[kobiety][i]==aktualnyMezczyzna)
                pref_aktualnyMezczyzna = i;
        }
        if(pref_kawaler<pref_aktualnyMezczyzna)
            return true;

        return false;
    }



}
