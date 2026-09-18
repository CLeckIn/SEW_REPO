package account_item;

public record Item(String name, int cost) {

    public Item {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Der Name des Items darf nicht null oder leer sein.");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Die Kosten des Items dürfen nicht negativ sein.");
        }
    }

    public Item(String name) {
        this(name, 0);
    }

    @Override
    public String toString() {
        return this.name + " (" + this.cost + " Gold)";
    }

    public int betragInteger() {
        return Math.round(this.cost);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Item other = (Item) obj;

        if (this.cost != other.cost) {
            return false;
        }

        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 17;

        result = result * prime + (this.name == null ? 0 : this.name.hashCode());

        result = result * prime + this.cost;

        return result;
    }
}
