package fit5171.monash.edu;

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
        super();
        this.securityCode=securityCode;
        this.cardNumber=cardNumber;
        this.passport=passport;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null)
            throw new NullPointerException("Email can not be null");
        if (email.isBlank()||email.isEmpty())
            throw new IllegalArgumentException("Email can not be empty");
        if (!(email.endsWith(".com")&&email.matches("^(.*)@(.+)$")))
            throw new IllegalArgumentException("Please enter a valid email address");
        this.email = email;
}

    public String getFirstName() {
        return super.getFirstName();
    }

    public String getSecondName() {
        return super.getSecondName();
    }

    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public String getPassport() {return passport;}

    public void setGender(String gender) {
        super.setGender(gender);
    }

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
        this.cardNumber = cardNumber;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    public void setPassport(String passport) {
        if (passport==null)
            throw new NullPointerException("Passport can not be null");
        if (passport.isEmpty()||passport.isBlank())
            throw new IllegalArgumentException("Passport can not be empty");
        if (passport.length() > 9)
            throw new IllegalArgumentException("Please enter a valid passport number");
        this.passport = passport;
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    public void setPhoneNumber(String phoneNumber) {
//        if(phoneNumber== null)
//            throw new NullPointerException("Phone number can not be null");
//        if(phoneNumber.isEmpty()||phoneNumber.isBlank())
//            throw new IllegalArgumentException("Phone number can not be null");
//        if (!(phoneNumber.length()==12 ||phoneNumber.length()==10))
//        if (!(phoneNumber.startsWith("+614")||(phoneNumber.startsWith("+615")||(phoneNumber.startsWith("04")||(phoneNumber.startsWith("05"))
//                for(char ch: phoneNumber.toCharArray())
//                    if(!(Character.isDigit(ch))&&phoneNumber.length()==9)

//
//        this.phoneNumber = phoneNumber;
   }

    @Override
    public int getAge() {
        return super.getAge();
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
