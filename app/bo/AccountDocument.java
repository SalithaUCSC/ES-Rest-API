package bo;

public final class AccountDocument {
    public int account_number;
    public int balance;
    public String firstname;
    public String lastname;
    public int age;
    public String gender;
    public String address;
    public String email;
    public String city;
    public String state;

    public AccountDocument(int acNo, int balance, String fName, String lName, int age, String gender,
                           String address, String email, String city, String state) {
        this.account_number = acNo;
        this.balance = balance;
        this.firstname = fName;
        this.lastname = lName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.city = city;
        this.state = state;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public AccountDocument() {
    }
}


