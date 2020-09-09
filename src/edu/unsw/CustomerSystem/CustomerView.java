package edu.unsw.CustomerSystem;

public class CustomerView {
    private CustomerList customers = new CustomerList(10);

    public void enterMainMenu(){
        boolean isFlag = true;
        do{
            // show the view
            System.out.println();
            System.out.println("--------------Customer Info--------------");
            System.out.println("\t1. Add customer's info");
            System.out.println("\t2. Modify customer's info");
            System.out.println("\t3. Delete customer's info");
            System.out.println("\t4. Customer list");
            System.out.println("\t5. Exit");
            System.out.print("Please input number (1-5):\t");
            // get the input
            char selection = CMUtility.readMenuSelection();
            // check
            switch(selection){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("Sure to leave? (Y/N)");
                    char confirm = CMUtility.readConfirmSelection();
                    if (confirm == 'Y')
                        System.exit(0);
                    else
                        break;

            }

        } while(isFlag);
    }

    private void addNewCustomer(){
        // init
        System.out.println("--------------Add customer's info--------------");
        System.out.print("Name:");
        String name = CMUtility.readString(10);
        System.out.print("Gender:");
        char gender = CMUtility.readChar();
        System.out.print("Age:");
        int age = CMUtility.readInt();
        System.out.print("Phone:");
        String phone = CMUtility.readString(20);
        System.out.print("Email:");
        String email = CMUtility.readString(20);

        // add
        Customer newCustomer = new Customer(name, gender, age, phone, email);
        boolean status = customers.addCustomer(newCustomer);

        // check
        if (status)
            System.out.println("Adding success.");
        else
            System.out.println("Adding failed.");
    }

    private void modifyCustomer(){
        // init
        System.out.println("--------------Modify customer's info--------------");
        System.out.println("Please input the index of Customer.");
        System.out.println("(Input -1 to exit)");
        int index = CMUtility.readInt();
        if (index != -1){
            index--;
            Customer targrtCustomer = customers.getCustomer(index);
            if (targrtCustomer == null)
                System.out.println("Modify failed.");
            else{
                System.out.print("Name("+targrtCustomer.getName()+"):\t");
                String name = CMUtility.readString(10, targrtCustomer.getName());
                System.out.print("Gender("+targrtCustomer.getGender()+"):\t");
                char gender = CMUtility.readChar(targrtCustomer.getGender());
                System.out.print("Age("+targrtCustomer.getAge()+"):\t");
                int age = CMUtility.readInt(targrtCustomer.getAge());
                System.out.print("Phone("+targrtCustomer.getPhone()+"):\t");
                String phone = CMUtility.readString(20, targrtCustomer.getPhone());
                System.out.print("Email("+targrtCustomer.getEmail()+"):\t");
                String email = CMUtility.readString(20, targrtCustomer.getEmail());
                Customer newCustomer = new Customer(name, gender, age, phone, email);

                // replace
                boolean status = customers.replaceCustomer(index, newCustomer);
                if (status)
                    System.out.println("Modify success.");
                else
                    System.out.println("Modify failed.");
            }
        }
    }

    private void deleteCustomer(){
        System.out.println("--------------Delete customer's info--------------");
        while(true){
            System.out.println("Please input the index of customer.");
            System.out.println("(Input -1 to exit)");
            int index = CMUtility.readInt();
            if (index == -1)
                break;
            else{
                index--;
                boolean status = customers.deleteCustomer(index);
                if (status)
                    System.out.println("Delete success.");
                else
                    System.out.println("Delete failed.");
            }
        }
    }

    private void listAllCustomers(){
        // init
        System.out.println("--------------Customer list--------------");
        System.out.println("No.\tName\tGender\tAge\tPhone\tEmail");
        Customer[] allCustomers = customers.getAllCustomers();
        if (allCustomers.length == 0) {
            System.out.println("Please add info at first.");
        }else{
            for (int index = 0; index < allCustomers.length; index++){
                Customer currentCustomer = allCustomers[index];
                if (currentCustomer != null){
                    System.out.println(index+1+"\t"+currentCustomer.getName()+"\t"+currentCustomer.getGender()+"\t"
                            +currentCustomer.getAge()+"\t"+currentCustomer.getPhone()+"\t"+currentCustomer.getEmail());
                }else
                    break;
            }
        }
    }

    public static void main(String[] args){
        new CustomerView().enterMainMenu();
    }

}
