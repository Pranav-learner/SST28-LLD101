public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        PowerControllable projectorPower = reg.getFirstByCapability(PowerControllable.class);
        projectorPower.powerOn();

        InputConnectable projectorInput = reg.getFirstByCapability(InputConnectable.class);
        projectorInput.connectInput("HDMI-1");

        BrightnessControllable lights = reg.getFirstByCapability(BrightnessControllable.class);
        lights.setBrightness(60);

        TemperatureControllable ac = reg.getFirstByCapability(TemperatureControllable.class);
        ac.setTemperatureC(24);

        Scannable scanner = reg.getFirstByCapability(Scannable.class);
        System.out.println("Attendance scanned: present=" + scanner.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        for (PowerControllable device : reg.getAllByCapability(PowerControllable.class)) {
            device.powerOff();
        }
    }
}
