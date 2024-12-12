public class Assignment{
    private String name;
    private String type;
    private double earned_points;
    private double total_points;

    public Assignment(String name, String type, double earned_points, double total_points){
        this.name = name;
        this.type = type;
        this.earned_points = earned_points;
        this.total_points = total_points;
    }

    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public double getEarned_points(){
        return earned_points;
    }

    public double getTotal_points(){
        return total_points;
    }
}