package xyz.trinitygames.Terfarmer.animals;

public abstract class Animal implements Comparable<Animal> {
    String name;
    int value;
    int life;
    int income;

    /**
     * Get the name of the animal.
     * The format is "NAME (TYPE)".
     * @return string representation of the name
     */
    public abstract String getName();

    /**
     * Get the amount of money generated by the animal daily.
     * @return integer representation of the daily income
     */
    public int getIncome() {
        return this.income;
    }

    /**
     * Original market value of the animal. Will decrease daily.
     * @return integer representation of the animal's value
     */
    public int getValue(){
        return this.value;
    }

    /**
     * The amount of days the animal has left to live.
     * @return integer representation of the animal's remaining life spam
     */
    public int getLifetime() {
        return this.life;
    }

    /**
     * Ages the animal by one day
     */
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
        }
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * The comparison is done by "total value" (lifetime * daily income).
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Animal o) {
        int total_value = this.getValue() * this.getLifetime();
        int total_value_o = o.getValue() * o.getLifetime();

        // TODO: ensure this is correct
        return total_value - total_value_o;
    }
}
