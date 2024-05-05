import java.util.Scanner;

public class SpringfieldTeacherTrack {
    private static final double[][] SALARY_SCHEDULE = {
        {52699, 56967, 66031, 66980, 67929, 68376, 68614}, // Step 1
        {54807, 58249, 67517, 68487, 69457, 69915, 70329}, // Step 2
        {56862, 59560, 69036, 70028, 71020, 71488, 72087}, // Step 3
        {58994, 60900, 70590, 71604, 72618, 73097, 73889}, // Step 4
        {60322, 62270, 72178, 73215, 74252, 74741, 75737}  // Step 5
    };

    public static void main(String[] args) {
      Teacher [] teachers=new Teacher[10];

      teachers[0]=new Teacher (1,"Joe", "Smith", "BA",0,2, 1, 0.00);
      teachers[1]=new Teacher (2,"Susan", "Jones", "MA",10,3, 1, 0.00);
      teachers[2]=new Teacher (4,"Marcia", "Brady", "MA",6,5, 3, 0.00);
      teachers[3]=new Teacher (5,"Brendan", "Farve", "BA",20,1, 4, 0.00);
      teachers[4]=new Teacher (6,"Stan", "Lee", "BA",40,3, 2, 0.00);
      teachers[5]=new Teacher (8,"Barbara", "Walters", "BA",10,4, 2, 0.00);
      teachers[6]=new Teacher (10,"Mary", "Shelley", "MA",16,5, 1, 0.00);
      teachers[7]=new Teacher (11,"Emma", "Watson", "BA",30,3, 4, 0.00);
      teachers[8]=new Teacher (13,"Isaac", "Newton", "MA",20,4, 3, 0.00);
      teachers[9]=new Teacher (14,"Martha", "Stewart", "BA",50,4, 5, 0.00);

        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please choose your task and enter the number of your choice:\n");
            System.out.println("1. Print this year's teacher roster");
            System.out.println("2. Update review score");
            System.out.println("3. Update additional credits");
            System.out.println("4. Update degree");
            System.out.println("5. Add Teacher without review score");
            System.out.println("6. Add Teacher with review score");
            System.out.println("7. Remove Teacher");
            System.out.println("8. Update salaries");
            System.out.println("9. Exit");

            choice = input.nextInt();
            switch(choice) {
                case 1:
                    printRoster(teachers);
                    break;
                case 2:
                    updateReviewScore(teachers, input);
                    break;
                case 3:
                    updateAdditionalCredits(teachers, input);
                    break;
                case 4:
                    updateDegree(teachers, input);
                    break;
                case 5:
                    addTeacher(teachers, input, false);
                    break;
                case 6:
                    addTeacher(teachers, input, true);
                    break;
                case 7:
                    removeTeacher(teachers, input);
                    break;
                case 8:
                    updateSalaries(teachers);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (choice != 9);

        input.close();
    }

    public static void printRoster(Teacher[] teachers) {
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    public static void updateReviewScore(Teacher[] teachers, Scanner input) {
        System.out.println("Enter teacher ID:");
        int id = input.nextInt();
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getId() == id) {
                System.out.println("Current review score: " + teacher.getCurrRevScore());
                System.out.println("Enter new review score (0-5):");
                int score = input.nextInt();
                if (score >= 0 && score <= 5) {
                    teacher.setCurrRevScore(score);
                    System.out.println("Review score updated.");
                } else {
                    System.out.println("Invalid score, must be between 0 and 5.");
                }
                return;
            }
        }
        System.out.println("Teacher not found.");
    }

    public static void updateAdditionalCredits(Teacher[] teachers, Scanner input) {
        System.out.println("Enter teacher ID:");
        int id = input.nextInt();
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getId() == id) {
                System.out.println("Current additional credits: " + teacher.getAddCredits());
                System.out.println("Enter new additional credits (0-60):");
                int credits = input.nextInt();
                if (credits >= 0 && credits <= 60) {
                    teacher.setAddCredits(credits);
                    System.out.println("Credits updated.");
                } else {
                    System.out.println("Invalid number of credits, must be between 0 and 60.");
                }
                return;
            }
        }
        System.out.println("Teacher not found.");
    }

    public static void updateDegree(Teacher[] teachers, Scanner input) {
        System.out.println("Enter teacher ID:");
        int id = input.nextInt();
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getId() == id) {
                System.out.println("Current degree: " + teacher.getDegree());
                System.out.println("Enter new degree (BA or MA):");
                String degree = input.next();
                if (degree.equals("BA") || degree.equals("MA")) {
                    teacher.setDegree(degree);
                    System.out.println("Degree updated.");
                } else {
                    System.out.println("Invalid degree, must be BA or MA.");
                }
                return;
            }
        }
        System.out.println("Teacher not found.");
    }

    public static void addTeacher(Teacher[] teachers, Scanner input, boolean includeReviewScore) {
        System.out.println("Enter teacher ID:");
        int id = input.nextInt();
        System.out.println("Enter first name:");
        String firstName = input.next();
        System.out.println("Enter last name:");
        String lastName = input.next();
        System.out.println("Enter degree (BA or MA):");
        String degree = input.next();
        System.out.println("Enter additional credits (0-60):");
        int credits = input.nextInt();
        System.out.println("Enter salary:");
        double salary = input.nextDouble();
        int reviewScore = 0;
        if (includeReviewScore) {
            System.out.println("Enter review score (0-5):");
            reviewScore = input.nextInt();
        }
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
              teachers[i] = new Teacher(id, firstName, lastName, degree, credits, reviewScore, 0, salary);
                System.out.println("Teacher added.");
                return;
            }
        }
        System.out.println("No space to add more teachers.");
    }

    public static void removeTeacher(Teacher[] teachers, Scanner input) {
        System.out.println("Enter teacher ID:");
        int id = input.nextInt();
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null && teachers[i].getId() == id) {
                teachers[i] = null;
                System.out.println("Teacher removed.");
                return;
            }
        }
        System.out.println("Teacher not found.");
    }

    public static void updateSalaries(Teacher[] teachers) {
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                int step = Math.min(teacher.getYears(), 5);
                int column = getColumnIndex(teacher.getDegree(), teacher.getAddCredits());
                double baseSalary = SALARY_SCHEDULE[step - 1][column];
                double finalSalary = baseSalary;
                // Apply 2.5% increase for every year beyond 5 years
                if (teacher.getYears() > 5) {
                    int extraYears = teacher.getYears() - 5;
                    for (int i = 0; i < extraYears; i++) {
                        finalSalary *= 1.025;
                    }
                }
                teacher.setSalary(Math.round(finalSalary * 100) / 100.0);  // rounding to 2 decimal places
                System.out.println("Updated salary for " + teacher.getfName() + " " + teacher.getlName() + " to " + teacher.getSalary());
            }
        }
    }

    private static int getColumnIndex(String degree, int credits) {
        if (degree.equals("MA")) {
            if (credits >= 45) return 6;
            else if (credits >= 30) return 5;
            else if (credits >= 15) return 4;
            else return 2;
        } else {
            if (credits >= 15) return 1;
            else return 0;
        }
    }
}
