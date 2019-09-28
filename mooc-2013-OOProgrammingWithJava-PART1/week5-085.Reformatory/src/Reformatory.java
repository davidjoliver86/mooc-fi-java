public class Reformatory {
    
    private int totalWeightsMeasured;
    
    public Reformatory() {
        this.totalWeightsMeasured = 0;
    }

    public int weight(Person person) {
        // return the weight of the person
        this.totalWeightsMeasured++;
        return person.getWeight();
    }
    
    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }
    
    public int totalWeightsMeasured() {
        return this.totalWeightsMeasured;
    }

}
