package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}

//  Want to test a signup flow for selenium blog

/** 1. Open your chrome broswer
    2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com/)
    3. Maximize the browser
    4. Click on signup button to open the signup page
    5. Input your username on the username field
    6. Input an email address on the email field
    7. Input your password on the password field
    8. Click on the signup button
    9. Click on User1 item on the listpage
    10. Search for an item and confirm it is present
    11. Click on logout

     Write tests on the following scenarios
    1. Verify the user input the right url and his on the right webpage
    2. Verify that when user clicks on the signup button, the user is directed to the signup page
    3. Verify that user cannot signup with username less than 3 characters
    4. Verify user cannot signup with invalid email address
    5. Verify user cannot signup with password less than 4 character
    6. Verify user cannot signup with either/all of the fields blank
    7. Verify that user is successfully signed up when valid details are inputted.
    8. Verify that User1 item is present on the item list page.
    9. Verify that the item searched for on the User1 page is present.
    10. Verify that when the user logout, he/she is directed back to the home page
 */