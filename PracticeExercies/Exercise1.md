# Exercise 1

pg433: 8.1, 8.2, 8.3, 8.4, 8.5

## 8.1

which of the following are valid declarations? shich instantiate an array object? explain your answers:

	int primes = {2, 3, 4, 5, 7, 11};
	float elapsedTimes[] = {11.47, 12.04, 11.72, 13.88};
	int[] scores = new int[30];
	char grades[] = {'a', 'b', 'c', 'd', 'f'};

## 8.2

describe five programs that would be difficult to implement without using arrays.

store student grades for all students in a university

store an arbitrary amount of integers

## 8.3

describe how an element in an array is accessed in memory. for example, where is myArray[25] stored in memory?

	memoryLocationOfMyArray+25

## 8.4

describe what problem occurs in the following code. what modifications should be made to it to eliminate the problem?

	int[] number = {3, 2, 3, 6, 9, 10, 12, 32, 3, 12, 6};
	for (int count=1; count <= numbers.length; count++)
		System.out.println(numbers[count])

the program prints out each number in the array on its own line, but produces an error at the very end, to fix code should read as such:

	int[] number = {3, 2, 3, 6, 9, 10, 12, 32, 3, 12, 6};
	for (int count=1; count < numbers.length; count++)
		System.out.println(numbers[count])	

## 8.5

write an array declaration and any necessary supporting classed to represent the following statements:

a. students' names for a class of 25 students
b. students' test grades for a class of 40 students
c. credit-card transactions that contain a transaction number, a merchant name, and a charge
d. student's names for a class and homework grades for each student
e. for each employee of the L&L International corporation: the employee number, hire date, and the amount of the last five raises

 	class Transaction {
 		int transactionNumber;
 		String merchantName;
 		float charge;
 		public Transaction(int transactionNumber, String merchantName, float charge) {
 			this.transactionNumber = transactionNumber;
 			this.merchantName = merchantName;
 			this.charge = charge;
 		}
 	}

 	class StudentGrade {
 		String name;
 		char grade;

 		public StudentGrade(String name, char grade) {
 			this.name = name;
 			this.grade = grade;
 		}
 	}

 	class Employee {
 		int employeeNumber;
 		int hireDate;
 		int[] raises = new int[5];
 	}

 	String[] names = new String[25];
 	int[] grades = new int[40];
 	Transaction[] trans;
 	StudentGrade[] grades;
 	Employee[] LLCorp;

 