import java.util.ArrayList;
import java.util.List;

public class CNetwork implements ANetwork {
    List<Device> deviceList;
    List<Connection> connectionList;
    List<Device> connectedDeviceList = new ArrayList<>();

    public CNetwork() {
        deviceList = new ArrayList<>();
        connectionList = new ArrayList<>();
    }

    public void setDeviceList(Device device) {
        deviceList.add(device);
    }

    public void setConnectionList(Connection connection) {
        connectionList.add(connection);
    }

    @Override
    public String toString() {
        return "CNetwork{" +
                "connectionList=" + connectionList +
                '}';
    }

    @Override
    public Device getSource(Connection con) {
        return con.getSourceDevice();
    }

    @Override
    public Device getTarget(Connection con) {
        return con.getTargetDevice();
    }

    public void connectedDevice(Connection con) {
        Device s = getSource(con);
        Device t = getTarget(con);
        connectedDeviceList.add(s);
        connectedDeviceList.add(t);
    }

    public boolean checkDevice(Device device) {
        for (Device div : deviceList) {
            if (div.equals(device)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDeviceInNetwork(Device device) {
        for (Device d : deviceList) {
            if (d.equals(device)) {
                return true;
            }
        }
        return false;
    }

    public Connection searchConnection(Device device) {
        for (Connection con : connectionList) {
            if (getSource(con).equals(device) || getTarget(con).equals(device)) {
                return con;
            }
        }
        return null;
    }

    public void deleteDevice(Device device) {
        if (checkDevice(device)) {
            if (checkDeviceInNetwork(device)) {
                Connection con = searchConnection(device);
                if (con != null) {
                    connectionList.remove(con);
                }
                deviceList.remove(device);
            }
        } else {
            System.out.println("The device does not exist in the network");
        }
    }

    public void dataTransfer(Device source, Device target) {
        if (checkDeviceInNetwork(source) && checkDeviceInNetwork(target)) {
            System.out.println("Data transferred from " + source + " to " + target);
        } else {
            System.out.println("Cannot transfer data because device(s) do not exist in the network");
        }
    }
}
