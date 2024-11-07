package xyz.trinitygames.Terfarmer.animals;

public class Chicken extends Animal {
    static final String[] random_names =  {"Henk", "Luna", "Nugget", "Cluck", "Blueburg"};
    
    public Chicken() {
        this.name = random_names[(int) (Math.random() * random_names.length)];
        // the lifetime of a chicken will be between 3 and 8 days
        this.life = (int) (Math.random() * 6) + 3;
        // the value of a chicken will be between 70 and 120
        this.value = (int) (Math.random() * 51) + 70;
        // the chicken will return its investment in 4 days
        this.income = this.value / 4;
    }
    
    /**
     * Get the name of the animal.
     * The format is "NAME (TYPE)".
     *
     * @return string representation of the name
     */
    @Override
    public String getName() {
        if(this.life > 0) return this.name + " (Chicken)";
        return this.name + " (Chicken, Dead)";
    }
}
