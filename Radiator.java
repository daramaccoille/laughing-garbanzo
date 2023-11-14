
/**
 * Class for the radiator with common behaviour to Device
 */

/**
 * @author Dara Mac Coille
 * @version 29/09/2023
 */
public class Radiator extends Device {
	// Declare variable for radiator temperatures
	int tempNow;
	int tempTarget;

	// Constructor declares all input variables needed, calls super on those properties
	// declared in the super, Device, class. It also calls super on the DeviceType class 2 levels up
	Radiator(String deviceTypeName,String deviceName, String deviceManufacturer, 
			String deviceRoom, String powerState, int tempNow,int tempTarget) throws Exception {
		super(deviceTypeName, deviceName, deviceManufacturer, deviceRoom, powerState);
		super.setDeviceName(deviceName);
		super.setDeviceTypeName(deviceTypeName);
		super.setDeviceManufacturer(deviceManufacturer);
		super.setDeviceRoom(deviceRoom);
		setTempTarget(tempTarget);
		setTempNow(tempNow);
	}

	public int getTempNow() {
		return tempNow;
	}

	public int getTempTarget() {
		return tempTarget;
	}

	public void setTempNow(int _tempNow) {
		if (_tempNow >= -10 && _tempNow <= 30) {
			tempNow = _tempNow;}
		}
		public void setTempTarget(int _tempTarget) {
			if (_tempTarget >= 5 && _tempTarget <= 26) {
				tempTarget = _tempTarget;
			}
	}
		public  String To_String() {
			return "and the current temp is " +getTempNow()+"\u00B0C"
		+ "\n The target temperature is "+ getTempTarget()+"\u00B0C";
		}

}
