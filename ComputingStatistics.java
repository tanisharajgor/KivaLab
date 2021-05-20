import java.util.ArrayList;
import java.lang.Math;

public class ComputingStatistics {
  /**
   * The ArrayList containing all of the loan data.
   */
  private ArrayList<Loan> data;
  private String country;
  private double variance; 

  /**
   * Creates a new ComputingStatistics object with an empty ArrayList
   */
  public ComputingStatistics() {
    data = new ArrayList<Loan>();
  }

  /**
   * Creates a new ComputingStatistics object with the data passed in
   */
  public ComputingStatistics(ArrayList<Loan> d) {
    data = d;
  }

  /**
   * Calclates the total amount funded from all of the loans in the file.
   * 
   * @return the total loan amount.
   */
  public double totalAmount() {
    double amount = 0.0;
    for (int i = 0; i < data.size(); i++) {
      amount = amount + data.get(i).getLoanAmount();
    }
    return amount;
  }

  public double avgLoan() {
    double amount = 0.0;
    for (int i = 0; i < data.size(); i++) {
      amount = amount + data.get(i).getLoanAmount();
    }
    return amount / data.size();
  }

  public double largestLoan() {
    double max = data.get(0).getLoanAmount();
    for (int i = 1; i < data.size(); i++) {
      if (data.get(i).getLoanAmount() > max) {
        max = data.get(i).getLoanAmount();
      }
    }
    return max;
  }

  public double smallestLoan() {
    double min = data.get(0).getLoanAmount();
    for (int i = 1; i < data.size(); i++) {
      if (data.get(i).getLoanAmount() < min) {
        min = data.get(i).getLoanAmount();
      }
    }
    return min;
  }

  public String largestLoanCountry() {
    double max = data.get(0).getLoanAmount();
    for (int i = 1; i < data.size(); i++) {
      if (data.get(i).getLoanAmount() > max) {
        max = data.get(i).getLoanAmount();
        country = data.get(i).getCountry();

      }
    }
    return country;
  }

  public String smallestLoanCountry() {
    double min = data.get(0).getLoanAmount();
    for (int i = 1; i < data.size(); i++) {
      if (data.get(i).getLoanAmount() < min) {
        min = data.get(i).getLoanAmount();
        country = data.get(i).getCountry();

      }
    }
    return country;
  }

  public double avgDaysToFund() {
    double amount = 0.0;
    for (int i = 0; i < data.size(); i++) {
      amount = amount + data.get(i).getDaysToFund();
    }
    return amount / data.size();
  }

  public double largestLoanKenya() {
    double max = data.get(0).getLoanAmount();
    for (int i = 1; i < data.size(); i++) {
      if (data.get(i).getLoanAmount() > max && data.get(i).getCountry() == "Kenya") {
        max = data.get(i).getLoanAmount();
      }
    }
    return max;
  }

  public double avgLoanPhilippines() {
    double amount = 0.0;
    double count = 0.0;
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i).getCountry().equals("Philippines") == true) {
        count = count + 1.0; 
        amount = amount + data.get(i).getLoanAmount();
      }
    }
    return amount / count;
  }
 
  public String longestToFundCountry() {
    double max = data.get(0).getDaysToFund();
    for (int i = 1; i < data.size(); i++) {
      if (data.get(i).getDaysToFund() > max){
        max = data.get(i).getDaysToFund();
        country = data.get(i).getCountry();
      }
    }
    return country;
  }

  public String mostLoansFunded(){
    double count1 = 0.0; //El Salvador
    double count2 = 0.0; //Kenya

    for (int i = 0; i < data.size(); i++){
      if (data.get(i).getCountry().equals("El Salvador") == true){
        count1++;
      }
      if (data.get(i).getCountry().equals("Kenya") == true){
        count2++;
      }
    }

    if (count1 > count2){
      return "El Salvador";
    }

    if (count1 < count2){
      return "Kenya";
    }

    return "finished";

  }

  public double variance (){
    double avg = avgLoan();
    double total = 0.0;
    for (int i = 0; i < data.size(); i++){
      total = total + Math.pow(data.get(i).getLoanAmount() - avg, 2);
    }
    variance = total/data.size();
    return variance;
  }

  public double standardDeviation(){
    System.out.println(variance);
    return Math.pow(variance, 1/2);
  }

  public boolean empiricalRule(){
    double count = 0.0;
    for (int i = 0; i < data.size(); i++){
      if (data.get(i).getLoanAmount() <= 1037.1110931015464){
        count++;
      }
    }
    return ((count/data.size()) > 0.68);
  }
  
}