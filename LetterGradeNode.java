class LetterGradeNode {
    double threshold;
    String grade;
    LetterGradeNode left, right;

    public LetterGradeNode(double threshold, String grade) {
        this.threshold = threshold;
        this.grade = grade;
        left = right = null;
    }
}
