import java.util.Arrays;
import java.util.Scanner;

/**
 * @author MacCoilleDara40091080
 * @version 28/09/2023
 *
 */
public class DeviceType {
String deviceTypeName;

public DeviceType(String deviceTypeName){
	
}
public void setDeviceTypeName(String deviceTypeName)throws Exception {
	try {
		if(!Arrays.asList(deviceTypeNames).contains(deviceTypeName)) {
			System.out.println("Device Type name "+deviceTypeName+" not recognised."
					+ "Type \"Y\" if you would like to create the device type "
					+ "name \""+deviceTypeName+"\"");
			Scanner scanner = new Scanner(System.in);
			if (scanner.next().equalsIgnoreCase("Y")) {
				AddDeviceTypeName(deviceTypeName);
				scanner.close();
			}
		}
		
		if (deviceTypeName.length()>=3) {
			this.deviceTypeName=deviceTypeName;
	} 
	}catch (Exception e) {
		System.out.println("There was a problem setting the device type."+ e.getMessage());
	}
	
};
String[] deviceTypeNames={"Smart Radiator","Smart Plug", "Smart Bulb","Smart Fan"};

//DeviceType(){} //will eliminate need to call super("FieldName")

public String To_String() throws Exception {return "The device type is "+deviceTypeName;}


public void AddDeviceTypeName(String newDeviceTypeName){
	Arrays.asList(deviceTypeNames).add(deviceTypeName);
}	
}
