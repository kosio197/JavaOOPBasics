package bg.softuni.staticmembers.beercounter;

public class BeerCounter {

    private static int beerInStock;
    private static int beersDrankCount;

    static {
        beerInStock = 0;
        beersDrankCount = 0;
    }

    public static void BuyBeer(int bottlesCount) {
        beerInStock += bottlesCount;
    }

    public static void DrinkBeer(int bottlesCount) {
        beersDrankCount += bottlesCount;
        beerInStock -= bottlesCount;
    }

    public static int getBeerInStock() {
        return beerInStock;
    }

    public static int getBeersDrankCount() {
        return beersDrankCount;
    }
}
