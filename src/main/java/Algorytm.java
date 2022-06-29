public class Algorytm {

    public static void main(String[] args) {

        int men[][] = {
                {0, 1, 2, 3},
                {1, 2, 3, 0},
                {2, 3, 0, 1},
                {3, 0, 1, 2}
        };

        int women[][] = {
                {2, 0, 1, 3},
                {0, 1, 3, 2},
                {1, 2, 3, 0},
                {0, 1, 2, 3}
        };

        Malzenstwo malzenstwo = new Malzenstwo();
        malzenstwo.Dopasowanie(men, women);
    }

}
