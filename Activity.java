public abstract class Activity implements IDisplayable{
    protected String title;
    protected String date;

    //Constructor
    public Activity(){
        title = null;
        date = null;
    }

    public Activity(String title, String date){
        this.title = title;
        this.date = date;
    }

    //Accessors
    public String getTitle(){
        return title;
    }

    public String getDate(){
        return date;
    }

    //Mutators
    public void setTitle(String title){
        this.title = title;
    }

    public void setDate(String date){
        this.date = date;
    }

    //Abstract Display Method
    public abstract String getDisplayDetails();
}
