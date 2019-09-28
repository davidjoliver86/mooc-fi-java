
public class Apartment {

    private int rooms;
    private int squareMeters;
    private int pricePerSquareMeter;

    public Apartment(int rooms, int squareMeters, int pricePerSquareMeter) {
        this.rooms = rooms;
        this.squareMeters = squareMeters;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }
    
    public int getRooms() {
        return this.rooms;
    }
    
    public int getSquareMeters() {
        return this.squareMeters;
    }
    
    public int getPrice() {
        return this.squareMeters * this.pricePerSquareMeter;
    }
    
    public boolean larger(Apartment otherApartment) {
        return this.getSquareMeters() > otherApartment.getSquareMeters();   
    }
    
    public int priceDifference(Apartment otherApartment) {
        return Math.abs(this.getPrice() - otherApartment.getPrice());
    }
    
    public boolean moreExpensiveThan(Apartment otherApartment) {
        return this.getPrice() > otherApartment.getPrice();
    }
    
}
