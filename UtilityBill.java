public class UtilityBill implements IDisplayable{
    private String type;
    private double usageAmount;
    private double usageLimit;

    //Constructors
    public UtilityBill(){
        type = null;
        usageAmount = 0.0;
        usageLimit = 0.0;
    }

    public UtilityBill(String type, double usageAmount, double usageLimit){
        this.type = type;
        this.usageAmount = usageAmount;
        this.usageLimit = usageLimit;
    }

    //Accessors
    public String getType(){
        return type;
    }

    public double getUsageAmount(){
        return usageAmount;
    }

    public double getUsageLimit(){
        return usageLimit;
    }

    //Mutators
    public void setType(String type){
        this.type = type;
    }

    public void setUsageAmount(double usageAmount){
        this.usageAmount = usageAmount;
    }

    public void setUsageLimit(double usageLimit){
        this.usageLimit = usageLimit;
    }

    //Internal Method
    public boolean isOverLimit(){
        if(usageAmount > usageLimit)
            return true;
        else
            return false;
    }

    //Display Method
    @Override
    public String getDisplayDetails(){
        return "Type: " + type + "\nUsage Amount: " + usageAmount + "\nUsage Limit: " + usageLimit;
    }
}
