package org.example.bankapp.models;

public class Bank {

    private long id;
    private String name;
    private String type;
    private String city;
    private String state;
    private int zip;

    private Bank() {
    }

    public static class Builder {
        private final long id;
        private final String name;
        private final String type;
        private String city;
        private String state;
        private int zip;

        public Builder(long id, String name, String type) {
            this.id = id;
            this.name = name;
            this.type = type;
        }

        public Builder withAddress(String city, String state, int zip) {
            this.city = city;
            this.state = state;
            this.zip = zip;
            return this;
        }

        public Bank build() {
            Bank bank = new Bank();
            bank.id = this.id;
            bank.name = this.name;
            bank.type = this.type;
            bank.city = this.city;
            bank.state = this.state;
            bank.zip = this.zip;

            return bank;
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}
