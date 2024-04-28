
public class List<Type> {

    private Type[] values;
    private int firstFreeIndex; //keeps track of the first empty index in the array

    public List() {
        //The array is created as type object, and changed to type generic with (Type[]) new Object[10]; — this is done because Java does not support the call new Type[10]; for now.
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(Type value) {
        // if array is out of space, make new array with more space
        if (this.firstFreeIndex == this.values.length) {
            grow();
        }

        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    //The size of the List increases if user tries to add a value to a full list.
    //The size of the array is determined in Java with the formula oldSize + oldSize / 2. 
    //The implementation creates a new array whose size is 1.5 times the size of the old array
    private void grow() {
        int newSize = this.values.length + this.values.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];

        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }

        this.values = newValues;
    }

    /*We will make use of the fact that each Java object — no matter its type — inherits the Object class (or is type Object). 
    Due to this, each object has the method public boolean equals(Object object), which we can use to check equality.*/
    public boolean contains(Type value) {

        /* for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return true;
            }
        }

        return false;*/
        return indexOfValue(value) >= 0;
    }

    //removes one value type value.
    public void remove(Type value) {

        int indexOfValue = indexOfValue(value);
        if (indexOfValue < 0) {
            return; // not found
        }

        moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;
    }

    //searches for the index of the value given to it as a parameter,
    public int indexOfValue(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    //moves values from the given index one place to the left.
    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }
    
    // returns the value in the given index of the List. 
    public Type value(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeIndex + "]");
        }

        return this.values[index];
    }
    
    //returns the size of the List
    public int size() {
    return this.firstFreeIndex;
}

}
