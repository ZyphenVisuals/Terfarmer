package xyz.trinitygames.Terfarmer.animals;

public class Cow extends Animal {
    static final String[] random_names =  {"Betsy", "Moonalisa", "DojaCow", "Mootwo", "Angus", "Whooper", "Milky", "Mushroom"};

    public Cow() {
        this.name = random_names[(int) (Math.random() * random_names.length)];
        // the lifetime of a cow will be between 20 and 50 days
        this.life = (int) (Math.random() * 31) + 20;
        // the value of a cow will be between 700 and 1000
        this.value = (int) (Math.random() * 301) + 700;
        // the cow will return its investment in 30 days
        this.income = this.value / 30;
    }
    
    /**
     * Get the name of the animal.
     * The format is "NAME (TYPE)".
     *
     * @return string representation of the name
     */
    @Override
    public String getName() {
        if(this.life > 0) return this.name + " (Cow)";
        return this.name + " (Cow, Dead)";
    }
}
