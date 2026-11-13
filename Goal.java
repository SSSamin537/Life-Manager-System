public class Goal implements IDisplayable{
    private String name;
    private String category;
    private boolean achieved;

    //Constructors
    public Goal(){
        name = null;
        category = null;
        achieved = false;
    }

    public Goal(String name, String category, boolean achieved){
        this.name = name;
        this.category = category;
        this.achieved = achieved;
    }

    //Accessors
    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public boolean getAchieved(){
        return achieved;
    }

    //Mutators
    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void markAchieved(boolean achieved){
        this.achieved = achieved;
    }

    //Display Method
    @Override
    public String getDisplayDetails(){
        return "Name: " + name + "\nCategory: " + category + "\nAchieved: " + achieved;
    }
}
