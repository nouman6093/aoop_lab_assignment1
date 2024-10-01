class Product {
    String name;
    String location;
    String price;
    String datePurchased;
    String note;

    public Product(String name, String location, String price, String datePurchased, String note) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.datePurchased = datePurchased;
        this.note = note;
    }

    @Override
    public String toString() {
        return name;
    }
}
