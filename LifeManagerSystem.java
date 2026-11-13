public class LifeManagerSystem {
    private final int MAX_CAPACITY = 20;
    private Goal[] goals;
    private UtilityBill[] utilityBills;
    private Activity[] activities;

    private int goalCount;
    private int billCount;
    private int activityCount;

    public LifeManagerSystem(){
        goals = new Goal[MAX_CAPACITY];
        utilityBills = new UtilityBill[MAX_CAPACITY];
        activities = new Activity[MAX_CAPACITY];

        goalCount = 0;
        billCount = 0;
        activityCount = 0;
    }

    public void addGoal(Goal goal){
        try{
            goals[goalCount] = goal;
            System.out.println("Success! Goal added to the list!");
            goalCount++;
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("The list is full!");
        }
    }

    public void addUtilityBill(UtilityBill utilityBill){
        try{
            utilityBills[billCount] = utilityBill;
            System.out.println("Success! The Utility Bill has been added to the list!");
            billCount++;
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("The list is full!");
        }
    }

    public void addActivity(Activity activity){
        try{
            activities[activityCount] = activity;
            System.out.println("Success! The Activity has been added to the list!");
            activityCount++;
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("The List is full!");
        }
    }

    public void printEverything(){
        int total = goalCount + billCount + activityCount;
        if(total == 0){
            System.out.println("Nothing to print!");
            return;
        }
        else{
            System.out.println("\n----YOUR GOALS----\n");
            for(int i = 0; i<goalCount; i++){
                System.out.println(goals[i].getDisplayDetails() + "\n");
            }

            System.out.println("\n----YOUR UTILITY BILLS----\n");
            for(int i = 0; i<billCount; i++){
                System.out.println(utilityBills[i].getDisplayDetails() + "\n");
            }

            System.out.println("\n----YOUR ACTIVITIES----");
            for(int i = 0; i<activityCount; i++){
                System.out.println(activities[i].getDisplayDetails() + "\n");
            }
        }
    }

    public void generateSmartSuggestions(){
        System.out.println("\nANALYZING LIFE SYNERGIES...");
        int suggestionsFound = 0;

        //Financial Goals & Utility Bills
        for(int i = 0; i<goalCount; i++){
            Goal currentGoal = goals[i];

            if(currentGoal.getCategory().equalsIgnoreCase("Financial") && !currentGoal.getAchieved()){
                for(int j = 0; j<billCount; j++){
                    UtilityBill currentBill = utilityBills[j];

                    if(currentBill.isOverLimit()){
                        System.out.println("\n[!] ALERT: Financial Goal at Risk!");
                        System.out.println("Your goal: '" + currentGoal.getName() + "' is being hurt by a high " + currentBill.getType() + " bill.");
                        System.out.println("-> Suggestion: Try to reduce your usage to stay under limit.");
                        
                        suggestionsFound++;
                    }
                }
            }
        }

        //Health Goals & Community Events
        for(int i = 0; i<goalCount; i++){
            Goal currentGoal = goals[i];

            if(currentGoal.getCategory().equalsIgnoreCase("Health") && !currentGoal.getAchieved()){
                for(int j = 0; j<activityCount; j++){
                    Activity currentActivity = activities[j];
                    if(currentActivity instanceof CommunityEvent){
                        CommunityEvent event = (CommunityEvent) currentActivity;
                        if(event.getImpactType().equalsIgnoreCase("Environment")){
                            System.out.println("\n[!] OPPORTUNITY: Active Volunteering!");
                            System.out.println("Your goal: '" + currentGoal.getName() + "' matches the event: '" + event.getTitle() + "'");
                            System.out.println("-> Suggestion: Get exercise for your goal while helping the planet!");

                            suggestionsFound++;
                        }
                    }
                }
            }
        }

        if(suggestionsFound == 0){
            System.out.println("No suggestions Found!");
        }
    }
}
