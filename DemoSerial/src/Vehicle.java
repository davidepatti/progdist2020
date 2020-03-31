public abstract class Vehicle {
    String number;
    String producer;
    public abstract  void turnOn();
    public abstract  void turnOff();

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
