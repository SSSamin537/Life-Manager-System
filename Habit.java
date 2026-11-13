public class Habit extends Activity{
    private boolean isCompleted;

    //Constructors
    public Habit(){
        super();
        isCompleted = false;
    }

    public Habit(String title, String date, boolean isCompleted){
        super(title, date);
        this.isCompleted = isCompleted;
    }

    //Accessor
    public boolean getIsCompleted(){
        return isCompleted;
    }

    //Internal Methods
    public void markComplete(){
        this.isCompleted = true; //Acting as the Mutator 
    }

    //Display Method
    @Override
    public String getDisplayDetails(){
        return "Title: " + getTitle() + "\nDate: " + getDate() + "\nCompleted: " + isCompleted;
    }
}
