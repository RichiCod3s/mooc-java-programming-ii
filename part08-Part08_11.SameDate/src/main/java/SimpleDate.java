
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }
    
    // **Handy tip!**
    // I used the source > insert code to auto-generate for me. 
    @Override
    public boolean equals(Object obj) {
        // Check if the compared object is the same instance
        if (this == obj) {
            return true;
        }
        // Check if the compared object is null
        if (obj == null) {
            return false;
        }
        // Check if the compared object is of the same class
        if (getClass() != obj.getClass()) {
            return false;
        }
        // Cast the object to compare its fields
        final SimpleDate other = (SimpleDate) obj;

        // Compare day, month, and year fields for equality
        if (this.day != other.day) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        // If all fields are equal, return true
        return true;
    }

}
