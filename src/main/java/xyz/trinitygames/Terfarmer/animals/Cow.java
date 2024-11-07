package xyz.trinitygames.Terfarmer.animals;

public class Cow extends Animal {
    static final String[] random_names =  {"Betsy", "Moonalisa", "DojaCow", "Mootwo", "Angus", "Whooper", "Milky", "Mushroom"};

    public Cow() {
        this.name = random_names[(int) (Math.random() * random_names.length)];
        // the lifetime of a cow will be between 10 and 30 days
        this.life = (int) (Math.random() * 21) + 10;
        // the value of a cow will be between 400 and 600
        this.value = (int) (Math.random() * 201) + 400;
        // the cow will return its investment in 15 days
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
        if(this.life > 0) return this.name + " (Cow)";
        return this.name + " (Cow, Dead)";
    }
}
