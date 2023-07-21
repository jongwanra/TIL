package chapter30;

public class JDK7Switch {
    public static void main(String[] args) {
        JDK7Switch switchSample = new JDK7Switch();
        System.out.println(switchSample.salaryIncreaseAmount(1));
        System.out.println(switchSample.salaryIncreaseAmount("CEO"));
    }

    private double salaryIncreaseAmount(int employeeLevel) {
        switch (employeeLevel) {
            case 1: //CEO
                return 10.0;
            case 2: // Manager
                return 15.0;
            case 3: // Engineer, Developer
                return 100.0;
            case 4: // Designer, planner
                return 20.0;
            default:
                return 0.0;
        }
    }

    private double salaryIncreaseAmount(String employeeLevel) {
        if(employeeLevel == null) {
            return 0.0;
        }

        switch (employeeLevel) {
            case "CEO":
                return 10.0;
            case "Manager":
                return 15.0;
            case "Engineer":
            case "Developer":
                return 100.0;
            case "Designer":
            case "Planner":
                return 20.0;
            default:
                return 0.0;
        }
    }
}
