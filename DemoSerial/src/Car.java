public class Car extends Vehicle {
    private boolean autocarro;
    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
    }

    public boolean isAutocarro() {
        return autocarro;
    }

    public void setAutocarro(boolean autocarro) {
        this.autocarro = autocarro;
    }

    public String toString(){
        String s = "Type:"+this.producer+ "number:"+this.number+" autocarro:"+this.autocarro;
        return s;
    }
}
