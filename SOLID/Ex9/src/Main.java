public class Main {
    public static void main(String[] args) {
        System.out.println("=== Evaluation Pipeline ===");

        Checker checker = new PlagiarismChecker();
        Grader grader = new CodeGrader();
        Writer writer = new ReportWriter();

        Submission sub = new Submission("23BCS1007", "public class A{}", "A.java");
        new EvaluationPipeline(checker, grader, writer).evaluate(sub);
    }
}
