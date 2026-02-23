import java.util.Optional;

public class CGRThresholdRule implements EligibilityRule {
    private final double minCgr;

    public CGRThresholdRule(double minCgr) {
        this.minCgr = minCgr;
    }

    @Override
    public Optional<String> validate(StudentProfile s) {
        if (s.cgr < minCgr) {
            return Optional.of("CGR below " + String.format("%.1f", minCgr));
        }
        return Optional.empty();
    }
}
