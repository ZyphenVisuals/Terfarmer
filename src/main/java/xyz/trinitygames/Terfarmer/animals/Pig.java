package xyz.trinitygames.Terfarmer.animals;

public class Pig extends Animal {
    static final String[] random_names =  {"Otis", "Bart", "Billy", "Fletch", "Fonzie", "Sebastian", "Larry", "Mortimer", "Gus", "Fat Albert"};

    public Pig() {
        this.name = random_names[(int) (Math.random() * random_names.length)];
        // the lifetime of a pig will be between 10 and 30 days
        this.life = (int) (Math.random() * 21) + 10;
        // the value of a pig will be between 300 and 500
        this.value = (int) (Math.random() * 201) + 300;
        // the pig will return its investment in 15 days
        this.income = this.value / 15;
    }
    
    /**
     * Get the name of the animal.
     * The format is "NAME (TYPE)".
     *
     * @return string representation of the name
     */
    @Override
    public String getName() {
        if(this.life > 0) return this.name + " (Pig)";
        return this.name + " (Pig, Dead)";
    }
}
