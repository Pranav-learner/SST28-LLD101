import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        
        RuleInput config = new RuleInput();
        EligibilityEngine engine = new EligibilityEngine(
            new FakeEligibilityStore(),
            Arrays.asList(
                new DisciplinaryRule(),
                new DisciplinaryWarningRule(), // Added new rule without touching engine
                new CGRThresholdRule(config.minCgr),
                new AttendanceRule(config.minAttendance),
                new CreditsRule(config.minCredits)
            )
        );
        
        engine.runAndPrint(s);
    }
}
