package DAO;

import javafx.collections.ObservableList;
import model.User;


import java.io.*;
import java.util.ArrayList;

import static DAO.Query.getUserList;

public class UserDateImpl extends Object{


    private static final long serialVersionUID = 1L;
    //File file = new File("LinkedInUser.dat");


    public static ObservableList<User> userList = getUserList();
    //private String filePath = file.getAbsolutePath();
    //private List <LinkedInUser> userList ;
    private String filePath, fileName;

    public static ObservableList<User> listFromFile() throws IOException {

        File file = new File("textFile");
        ObservableList<User> usersFromFile = (ObservableList<User>) new ArrayList<User>();

        if (file.exists()) {
            FileInputStream fins = new FileInputStream(file);
            ObjectInputStream oinput = new ObjectInputStream(fins);
            {
                // As suggested, casting warning is suppressed
                try {

                    usersFromFile = (ObservableList<User>) oinput.readObject();
                    //userList.add((User) usersFromFile);

                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
        for(User user:usersFromFile){
            System.out.println(user);

        }
        System.out.println();
        return usersFromFile;

        // Passes the user's from the file to the initSkillSetUsages method to find each users skillset.
        //ApplicationHelper.initSkillsetUsages(usersFromFile);
    }

}

