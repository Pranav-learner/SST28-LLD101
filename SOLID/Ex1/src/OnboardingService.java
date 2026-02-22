import java.util.*;

public class OnboardingService {
    private final StudentRepository db;
    private final InputParser parser;
    private final InputValidator validator;
    private final OnbardingConfirmationPrinter printer;

    public OnboardingService(StudentRepository db, InputParser parser, InputValidator validator, OnbardingConfirmationPrinter printer) { 
        this.db = db; 
        this.parser = parser; 
        this.validator = validator; 
        this.printer = printer; 
    }

    public void registerFromRawInput(String raw) {
        
        printer.printInput(raw);

        Map<String, String> data = parser.parse(raw);

        List<String> errors = validator.validate(data);

        if (!errors.isEmpty()) {
            printer.printError(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, data.get("name"), data.get("email"), data.get("phone"), data.get("program"));

        db.save(rec);

        printer.printConfirmation(rec, db.count());
    }
}