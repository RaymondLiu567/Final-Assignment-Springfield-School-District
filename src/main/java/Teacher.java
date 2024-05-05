import java.text.NumberFormat;
public class Teacher {
    private int id;
      private String fName;
      private String lName;
      private String degree;
      private int addCredits;
      private int currRevScore;
      private int years;
      private double salary;



    public Teacher (int id, String fName, String lName, String degree, int addCredits, int curreRevScore, int years, double salary) {
        this.id= id;
        this.fName=fName;
        this.lName= lName;
        this.degree=degree; 
        this.addCredits=addCredits;
        this.currRevScore=curreRevScore;
        this.years=years;
      }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getfName() {
      return fName;
    }

    public void setfName(String fName) {
      this.fName = fName;
    }

    public String getlName() {
      return lName;
    }

    public void setlName(String lName) {
      this.lName = lName;
    }

    public String getDegree() {
      return degree;
    }
    public String getFullDegree() {
      String fullDegree="";
      if ( degree=="BA")
      {
        fullDegree= "Bachelor's Degree";
      }
      else if ( degree=="MA")
      {
        fullDegree= "Master's Degree";
      }
      return fullDegree;
    }

    public void setDegree(String degree) {
      this.degree = degree;
    }

    public int getAddCredits() {
      return addCredits;
    }

    public void setAddCredits(int addCredits) {
      this.addCredits = addCredits;
    }

    public int getCurrRevScore() {
      return currRevScore;
    }

    public void setCurrRevScore(int currRevScore) {
      this.currRevScore = currRevScore;
    }
     public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getSalary() {
      NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
      String formattedCurrency = currencyFormat.format(salary);
      return formattedCurrency;
    }

    public void setSalary(double salary) {
      this.salary = salary;
    }

    public String toString() {
      return "Teacher #" + this.getId()+". \n"+this.getlName()+", " +
          this.getfName() + " has " +this.getYears()+" years of experience"+
          "\nCurrent degree & Credits: "+ this.getFullDegree()+
          "("+ this.getAddCredits()+")\nCurrent Year Review Score : " + this.getCurrRevScore()+
          "\nCurrent Salary : " + this.getSalary();


    }

}
