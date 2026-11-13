public class CommunityEvent extends Activity {
    private String impactType;

    //Constructors
    public CommunityEvent(){
        super();
        impactType = null;
    }

    public CommunityEvent(String title, String date, String impactType){
        super(title, date);
        this.impactType = impactType;
    }

    //Accessor
    public String getImpactType(){
        return impactType;
    }

    //Mutator
    public void setImpactType(String impactType){
        this.impactType = impactType;
    }

    //Display Method
    @Override
    public String getDisplayDetails(){
        return "Title: " + getTitle() + "\nDate: " + getDate() + "\nImpact Type: " + impactType;
    }
}
