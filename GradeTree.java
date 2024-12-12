class GradeTree {
    private LetterGradeNode root;

    // Insert a new node into the BST
    public void insert(double threshold, String grade) {
        root = insertRec(root, threshold, grade);
    }

    private LetterGradeNode insertRec(LetterGradeNode root, double threshold, String grade) {
        if (root == null) {
            root = new LetterGradeNode(threshold, grade);
            return root;
        }

        if (threshold < root.threshold) {
            root.left = insertRec(root.left, threshold, grade);
        } else if (threshold > root.threshold) {
            root.right = insertRec(root.right, threshold, grade);
        }
        return root;
    }

    // Reverse In-order traversal to visit nodes in descending order
    public String getLetterGrade(double finalNumberGrade) {
        return getLetterGradeRec(root, finalNumberGrade);
    }

    private String getLetterGradeRec(LetterGradeNode root, double finalNumberGrade) {
        if (root == null) {
            return "F"; // Default grade
        }

        // Traverse the right subtree first (higher thresholds)
        if (finalNumberGrade >= root.threshold) {
            return root.grade;
        }

        // Otherwise, check the left subtree
        return getLetterGradeRec(root.left, finalNumberGrade);
    }
}
