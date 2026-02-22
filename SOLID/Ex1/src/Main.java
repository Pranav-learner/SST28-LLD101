public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        FakeDb db = new FakeDb();
        InputParser parser = new InputParser();
        InputValidator validator = new InputValidator();
        OnbardingConfirmationPrinter printer = new OnbardingConfirmationPrinter();
        
        OnboardingService svc = new OnboardingService(db, parser, validator, printer);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
