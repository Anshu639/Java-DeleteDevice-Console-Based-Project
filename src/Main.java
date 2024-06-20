import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CNetwork cNetwork = new CNetwork();

        while (true) {
            System.out.println("------ Network Management System ------");
            System.out.println("1. Add Device");
            System.out.println("2. Create Connection");
            System.out.println("3. Transfer Data");
            System.out.println("4. Delete Device");
            System.out.println("5. View Network");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Device device = new Device();
                    cNetwork.setDeviceList(device);
                    System.out.println("Device added: " + device);
                    break;
                case 2:
                    System.out.println("Enter source device ID:");
                    int sourceID = scanner.nextInt();
                    System.out.println("Enter target device ID:");
                    int targetID = scanner.nextInt();
                    Device source = new Device();
                    source.setDeviceID(sourceID);
                    Device target = new Device();
                    target.setDeviceID(targetID);
                    Connection connection = new Connection(source, target);
                    cNetwork.setConnectionList(connection);
                    System.out.println("Connection created: " + connection);
                    break;
                case 3:
                    System.out.println("Enter source device ID:");
                    int sourceDeviceID = scanner.nextInt();
                    Device sourceDevice = new Device();
                    sourceDevice.setDeviceID(sourceDeviceID);
                    System.out.println("Enter target device ID:");
                    int targetDeviceID = scanner.nextInt();
                    Device targetDevice = new Device();
                    targetDevice.setDeviceID(targetDeviceID);
                    cNetwork.dataTransfer(sourceDevice, targetDevice);
                    break;
                case 4:
                    System.out.println("Enter device ID to delete:");
                    int deleteID = scanner.nextInt();
                    Device deviceToDelete = new Device();
                    deviceToDelete.setDeviceID(deleteID);
                    cNetwork.deleteDevice(deviceToDelete);
                    System.out.println("Device deleted: " + deviceToDelete);
                    break;
                case 5:
                    System.out.println("Current Network Status:");
                    System.out.println(cNetwork);                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
            System.out.println();
        }
    }
}
