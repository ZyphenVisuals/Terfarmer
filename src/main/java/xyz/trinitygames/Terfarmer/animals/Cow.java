package xyz.trinitygames.Terfarmer.animals;

public class Cow implements IAnimal {
    static final String[] random_names =  {"Henk", "Luna", "Nugget", "Cluck", "Blueburg"};

    private final String name;
    private int life;
    private int value;
    private int income;

    public Cow() {
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

    /**
     * Get the amount of money generated by the animal daily.
     *
     * @return integer representation of the daily income
     */
    @Override
    public int getIncome() {
        return this.income;
    }

    /**
     * Original market value of the animal. Will decrease by 10% daily.
     *
     * @return integer representation of the animal's value
     */
    @Override
    public int getValue() {
        return this.value;
    }

    /**
     * The amount of days the animal has left to live.
     *
     * @return integer representation of the animal's remaining life spam
     */
    @Override
    public int getLifetime() {
        return this.life;
    }

    /**
     * Ages the animal by one day
     */
    @Override
    public void age() {
        if(this.life > 1){
            this.life--;
            this.value = this.value - (int) (this.value * 0.1);
            return;
        }

        if(this.life == 1){
            this.life = 0;
            this.income = 0;
            this.value = 0;
            return;
        }
    }
}
