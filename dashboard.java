public class Dashboard {
    private String id; 
    private String route; 
    
    public Dashboard(String id){
        this.id = id; 
    }

    public void openDashboard(){ 

        // this method call, opens the dashboard
    }

    public void showDashboard(String route) {
        this.route = route; 

        //this method displays the dashboard for the current route. 
    } 
}