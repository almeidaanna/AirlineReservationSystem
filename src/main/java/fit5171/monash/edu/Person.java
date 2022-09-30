package fit5171.monash.edu;
public class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    public Person(){}

    public Person(String firstName, String secondName, int age, String gender){
        setAge(age);
        setFirstName(firstName);
        setSecondName(secondName);
        setGender(gender);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
        else
            throw new IllegalArgumentException("Invalid age");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null)
            throw new NullPointerException("Gender can not be null");
        if (gender.isBlank()||gender.isEmpty())
            throw new IllegalArgumentException("Gender can not be empty");
        if (!(gender.equalsIgnoreCase("Female")||gender.equalsIgnoreCase("Male")|| gender.equalsIgnoreCase("Other")||gender.equalsIgnoreCase("M")||gender.equalsIgnoreCase("F")||gender.equalsIgnoreCase("O")))
            throw new IllegalArgumentException("Invalid gender");
        else
            this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        String errorMessage = "Invalid details";
        if (firstName == null)
            throw new NullPointerException(errorMessage);
        if (firstName.isBlank()||firstName.isEmpty())
            throw new IllegalArgumentException(errorMessage);
        for (char ch: firstName.toCharArray())
            if(!(Character.isLetter(ch)))
                throw new IllegalArgumentException("Invalid First Name");
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        if (secondName == null)
            throw new NullPointerException("Invalid details");
        if (secondName.isBlank()||secondName.isEmpty())
            throw new IllegalArgumentException("Invalid details");
        for (char ch: secondName.toCharArray())
            if(!(Character.isLetter(ch)))
                throw new IllegalArgumentException("Invalid details");
        this.secondName = secondName;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
