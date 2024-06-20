public class Connection {
    private Device sourceDevice;
    private Device targetDevice;
    private int connectionID;
    private static int count = 0;

    public Connection(Device sourceDevice, Device targetDevice) {
        this.sourceDevice = sourceDevice;
        this.targetDevice = targetDevice;
        count++;
        connectionID = count;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "sourceDevice=" + sourceDevice +
                ", targetDevice=" + targetDevice +
                ", connectionID=" + connectionID +
                '}';
    }

    public boolean equals(Connection other) {
        return this.sourceDevice.equals(other.sourceDevice) &&
                this.targetDevice.equals(other.targetDevice) &&
                this.connectionID == other.connectionID;
    }

    public Device getSourceDevice() {
        return sourceDevice;
    }

    public Device getTargetDevice() {
        return targetDevice;
    }
}
