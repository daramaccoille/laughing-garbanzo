
public class MainSmartHomeDevice {

	public static void main(String[] args) throws Exception {
		
	

		// Create devices
		Device Plug = new Device("Smart Plug","Power plug 2000","Philips Hue","Lounge","ON");
		System.out.println(Plug.To_String());
		Device Fan = new Device("Smart Fan","Fan 4 speed KYHGF","Signify","Lounge","ON");
		System.out.println(Fan.To_String());
		Device Bulb = new Device("Smart Bulb","White Bulb 20w","Bright Lights","Kitchen","OFF");
		System.out.println(Bulb.To_String());
		Device Radiator = new Radiator("Smart Radiator","White double",
				"Victoria Plumbing","Kitchen","OFF",15,19);
		System.out.println(Radiator.To_String());
		
	}

}
