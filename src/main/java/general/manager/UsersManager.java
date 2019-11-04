package general.manager;

import java.util.HashMap;


public class UsersManager {

    public String username;
    public String password;
    public static UsersManager user1;
    public static UsersManager user2;
    public static UsersManager user3;
    public static UsersManager userinvalid;

    public UsersManager() {
        // user1 = new UsersManager();
    }

    public static void loadUsers() {
      
//User1
        user1 = new UsersManager();
        user1.username = "amal.k@shepherd365.com";
        user1.password = "abc@123";

      //User2      

        user2 = new UsersManager();
        user2.username = "Maria.Rosa@pexelz.com";
        user2.password = "abc@123";
        
      //userinvalid    
        userinvalid = new UsersManager();
        userinvalid.username = "Maria.Rosa@pexelz.com";
        
        
      //User3     
        user3 =new  UsersManager();
        user3.username="henry.norman@pexelz.com";
        user3.password="P@ssw0rd";
    

    }

   public static UsersManager getUserObject(String user){
        UsersManager userObj  = new UsersManager();
        switch (user.toLowerCase()){
            case "user1":
                userObj=UsersManager.user1;
                break;
            case "user2":
            	userObj=UsersManager.user2;
                break;
            case "userinvalid":
            	userObj=UsersManager.userinvalid;
                break;
            case "user3":
            	userObj=UsersManager.user3;
                break;
        }
		return userObj;

    }
    
    

}