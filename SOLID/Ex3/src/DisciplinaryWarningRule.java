import java.util.Optional;

public class DisciplinaryWarningRule implements EligibilityRule {
    @Override
    public Optional<String> validate(StudentProfile s) {
        if (s.disciplinaryFlag == LegacyFlags.WARNING) {
            return Optional.of("disciplinary warning present");
        }
        return Optional.empty();
    }
}
