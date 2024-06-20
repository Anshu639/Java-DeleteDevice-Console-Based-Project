public class Device {
    private String name;
    private int deviceID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    private static int count = 0;

    public Device() {
        count++;
        deviceID = count;
    }
    @Override
    public String toString() {
        return "Device{" +
                "deviceID=" + deviceID +
                '}';
    }
    public boolean equals(Device other) {
        return this.deviceID == other.deviceID;
    }
}
