
/**
 * imports
 */
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author MacCoilleDara40091080
 * @version 28/09/2023
 *
 */
public class Device extends DeviceType {

	String deviceName;
	String deviceManufacturer;
	String deviceRoom;
	boolean devicePowerState;

	Device(String deviceTypeName, String deviceName, String manufacturer, String room, String powerState)
			throws Exception {
		super(deviceTypeName);
		setDeviceName(deviceName);
		setDeviceManufacturer(manufacturer);
		setDeviceRoom(room);
		setDevicePowerState(powerState);
		super.setDeviceTypeName(deviceTypeName);
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) throws Exception {
		if (deviceName.length() >= 3 && deviceName.length() <= 20) {
			this.deviceName = deviceName;
		} else if (deviceName == null || deviceName.isEmpty()) {
			throw new IllegalArgumentException("Device Name cannot be null or empty");
		}

		else {
			System.out.println("Problem setting the device name. " + deviceName
					+ " Check it's more than 2 and less than 21 characters");
			throw new IllegalArgumentException("Device name must be between 3 and 20 characters long");
		}
	}

	public String getDeviceManufacturer() {
		return deviceManufacturer;
	}

	public void setDeviceManufacturer(String deviceManufacturer) throws IllegalArgumentException {
		if (deviceManufacturer.length() >= 3 && deviceManufacturer.length() <= 20) {
			this.deviceManufacturer = deviceManufacturer;
		} else {
			System.out.println(
					"Problem setting the device manufacturer. " + "Check it's more than 2 and less than 21 characters");
			throw new IllegalArgumentException();
		}

	}

	public String getDeviceRoom() {
		return deviceRoom;
	}

	String[] rooms = { "Kitchen", "Bedroom", "Bathroom", "Lounge" };

	public void setDeviceRoom(String deviceRoom) throws Exception {
		try {
			if (Arrays.asList(rooms).contains(deviceRoom)) {
				this.deviceRoom = deviceRoom;
				
			} else {
				Scanner scanner = new Scanner(System.in);
				// Ensure the room entered is in the rooms array
				while(!Arrays.asList(rooms).contains(deviceRoom)){
				System.out.println("Problem setting the device room. "
						+ "Check it's \"Kitchen\", \"Bedroom\",\"Bathroom\",\"Lounge\"");
				
				deviceRoom = scanner.next();
				
				}
				scanner.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Problem setting the device room");
		}
	}

	public String getDevicePowerState() throws Exception {
		if (devicePowerState) {
			return "ON";
		} else if (!devicePowerState)
			return "OFF";
		else {
			throw new Exception();
		}
	}

	public void setDevicePowerState(String devicePowerState) {

		try {
			if (devicePowerState == "ON") {
				this.devicePowerState = true;
			} else if (devicePowerState == "OFF") {
				this.devicePowerState = false;
			} else {
				System.out.println("Power State is an illegal value. Pick \"ON\" or \"OFF\"");
			}
		} catch (Exception e) {
			System.out.println("Problem setting the device power state");
			;
		}
	}

	public String To_String() throws Exception {
		return "The " + deviceTypeName + " is called " + deviceName + " \nThe manufacturer is " + deviceManufacturer
				+ "\nThe room is " + deviceRoom + "\nThe power state is " + getDevicePowerState() + "\n********";
	}

}
