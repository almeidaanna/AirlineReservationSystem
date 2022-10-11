package assignment.monash.edu;
public class Passenger extends Person
{
    private String email;
    private String phoneNumber;
    private String cardNumber;
    private int securityCode;
    private String passport;

    public Passenger(){}

    public Passenger(String firstName, String secondName, int age, String gender,String email, String phoneNumber, String passport, String cardNumber,int securityCode)
    {
        super(firstName, secondName, age, gender);
        setSecurityCode(securityCode);
        setCardNumber(cardNumber);
        setPassport(passport);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null)
            throw new NullPointerException("Email can not be null");
        if (email.isBlank()||email.isEmpty())
            throw new IllegalArgumentException("Email can not be empty");
        if (!(email.endsWith(".com")&&email.matches("^[a-zA-Z0-9._%+]+@[a-zA-Z0-9.]+")))
            throw new IllegalArgumentException("Invalid email address");
        this.email = email;
    }

    public String getPassport() {return passport;}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber == null)
            throw new NullPointerException("Card Number can not be null");
        if (cardNumber.isBlank()||cardNumber.isEmpty())
            throw new IllegalArgumentException("Card Number can not be empty");
        if (cardNumber.length() != 16)
            throw new IllegalArgumentException("Invalid Card Number");
        for (char ch: cardNumber.toCharArray())
            if(!(Character.isDigit(ch)))
                throw new IllegalArgumentException("Invalid Card Number");
        this.cardNumber = cardNumber;
    }

    public void setSecurityCode(int securityCode) {
        if (securityCode>99 && securityCode<1000)
            this.securityCode = securityCode;
        else
            throw new IllegalArgumentException("Invalid Security Code");
    }

    public void setPassport(String passport) {
        if (passport==null)
            throw new NullPointerException("Passport can not be null");
        if (passport.isEmpty()||passport.isBlank())
            throw new IllegalArgumentException("Passport can not be empty");
        if (passport.length() > 9)
            throw new IllegalArgumentException("Invalid passport number");
        this.passport = passport;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber== null)
            throw new NullPointerException("Phone Number can not be null");
        if(phoneNumber.isEmpty()||phoneNumber.isBlank())
            throw new IllegalArgumentException("Phone Number can not be empty");
        if(!(phoneNumber.matches("^(\\+61|0)[4|5]\\d{8}$")))
            throw new IllegalArgumentException("Invalid phone number");
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString()
    {
        return "Passenger{" + " Fullname= "+ super.getFirstName()+" "+super.getSecondName()+
                " ,email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport +
                '}';
    }

}
