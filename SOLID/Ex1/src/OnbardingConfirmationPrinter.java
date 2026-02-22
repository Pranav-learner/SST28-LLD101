
import java.util.List;

public class OnbardingConfirmationPrinter {
    public void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }

    public void printConfirmation(StudentRecord rec, int totalStudents){
        System.out.println("OK: created student " + rec.getId());
        System.out.println("Saved. Total students: " + totalStudents);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }

    public void printError(List<String> errors){
        System.out.println("ERROR: cannot register");
        for(String error : errors){
            System.out.println("- " + error);    
        }
    }
}
