public interface ANetwork {
    Device  getSource(Connection con);
    Device getTarget(Connection con);
    void setDeviceList(Device device);
    void setConnectionList(Connection con);
}