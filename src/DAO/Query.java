package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;
import model.Customer;
import model.User;

import java.sql.*;

public class Query {
    /**
     * Below are Public Accessible variables used to store data from the database into lists
     * which are relevant to the Classes created for this project. These particular lists will
     * be used to view, and manipulate the data needed for the requirements.
     */
    public static  ObservableList<User> userList = FXCollections.observableArrayList();
    public static  ObservableList<Customer> customerList = FXCollections.observableArrayList();
    public static  ObservableList<Appointments> appointmentList = FXCollections.observableArrayList();


    public static ObservableList<User> getUserList() {
        return userList;
    }

    public static void setUserList(ObservableList<User> userList) {
        Query.userList = userList;
    }

    public static ObservableList<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(ObservableList<Customer> customerList) {
        Query.customerList = customerList;
    }

    public static ObservableList<Appointments> getAppointmentList() {
        return appointmentList;
    }

    public static void setAppointmentList(ObservableList<Appointments> appointmentList) {
        Query.appointmentList = appointmentList;
    }



    /**
     * This Function queries the specified database for all User Information then converts
     * into a list form based on the User class attributes.
     * @return userList
     */
    public static ObservableList<User> queryUserSelect(){
        try
            {

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM users";
            System.out.println("jjjjjj");
            // create the java statemen
            Connection conn = DBConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query);

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery();
            System.out.println("hhhhh");

            //Create user instance
            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("User_ID");
                System.out.println(id+"line 69");

                String username = rs.getString("User_Name");
                System.out.println(username+"line 72");

                String password = rs.getString("Password");
                Date dateCreated = rs.getDate("Create_Date");
                Timestamp lastUpdate = rs.getTimestamp("Last_Update");
                String lastUpdatedBy = rs.getString("Last_Updated_By");
                User user = new User(id,username,password,dateCreated,lastUpdate,lastUpdatedBy);
                userList.add(user);
                //setUserList(userList);
                System.out.println(userList);
                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", id, username, password, dateCreated, lastUpdate, lastUpdatedBy);
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return userList;

    }
    /**
     * This Function queries the specified database for all Customer Information then converts
     * into a list form based on the User class attributes.
     * @return customerList
     */
    private ObservableList<Customer> queryCustomerSelect(){
        try
        {
            // create our mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/client_schedule?connectionTimeZone=SERVER";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT Customer_ID,Customer_Name,Address,Postal_Code,Phone FROM customers";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            //Create user instance
            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("Customer_ID");
                String customerName = rs.getString("Customer_name");
                String address = rs.getString("Address");
                String postalCode = rs.getString("Postal_Code");
                String phone = rs.getString("Phone");
                int divisionID = rs.getInt("Division_ID");

                Customer customer = new Customer(id,customerName,address,postalCode,phone,divisionID);
                customerList.add(customer);
                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", id, customerName, address, postalCode, phone);
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return  customerList;
    }
    /**
     * This Function queries the specified database for all Appointments Information then converts
     * into a list form based on the User class attributes.
     * @return appointmentList
     */
    private ObservableList<Appointments> queryAppointmentsSelect(){
        try
        {
            // create our mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/client_schedule?connectionTimeZone=SERVER";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT Appointment_ID,Title,Description,Location,Type,User_ID,Customer_ID,Contact_ID FROM customers";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            //Create user instance
            // iterate through the java resultset
            while (rs.next())
            {
                int appointmentID = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                int userID = rs.getInt("User_ID");
                int customerID = rs.getInt("Customer_ID");
                int contactID = rs.getInt("Contact_ID");


                Appointments appointment = new Appointments(appointmentID,title,description,location,userID,customerID,contactID);
                appointmentList.add(appointment);
                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", appointmentID,title,description,location,userID,customerID,contactID);
            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return  appointmentList;
    }
}
