public abstract class Samsung {
    private String manufacter;
    private String model;
    private final int batteryLife;

    public Samsung(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public String getManufacter() {
        return manufacter;
    }

    public void setManufacter(String manufacter) {
        this.manufacter = manufacter;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public int getBatteryLife() {
        return batteryLife;
    }
}
