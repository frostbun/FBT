#include<stdio.h>
#include<stdlib.h>
#include<string.h>
const double dependant = 1600;
const double yourself = 4000;
const double taxrate1 = 0.05;
const double taxrate2 = 0.1;
const double taxrate3 = 0.15;
const double taxrate4 = 0.2;
const double taxrate5 = 0.25;
const double taxrate6 = 0.3;
const double taxrate7 = 0.35;

struct employee {
    double income, pension_contribution, health_insurance, dependants, charity, tax, taxable_income;
    char name[101];
};

int check(char s[]) {
	int cnt = 0;
	for(int i=0; i<strlen(s); ++i) {
        if(s[i] != '.' && (s[i] > '9' || s[i] < '0')) return 10;
        cnt += s[i] == '.';
    }
	return cnt;	
}

double amount(double taxable_income, double dau, double cuoi) {
   	if(taxable_income < dau) return 0;
  	if(taxable_income > cuoi) return cuoi - dau;
  	return taxable_income - dau;
}

int input_code(int *n, int *list_of_code) {
	begin: while(1) {
        fflush(stdin);
        printf("Enter code (0 to stop): ");
        char s[100];
		scanf("%s", s);
		if(check(s)) {
		    printf("Invalid input, try again.\n");
            continue;
        }
        int code = atoi(s);
        if(code == 0) return 0;
        for(int i=0; i<*n; ++i) {
            if(code == list_of_code[i]) {
                printf("Code existed, try again.\n");
                goto begin;
            }
        }
		list_of_code[*n] = code;
		(*n)++;
		return code;
        // return list_of_code[(*n)++] = code;
    }
}

void input_name(char *name){
	fflush(stdin);
	printf("Enter name: ");
	scanf("%s", name);
}

void input_income(double *income) {
	while(1) {
		fflush(stdin);
		printf("Income for the current month (in thousand VND): ");
		char s[100];
		scanf("%s", s);
		if(*income >= 0 && check(s) < 2) {
		    *income = atof(s);
            return;
        }
		printf("Invalid input, try again.\n");
	}
}

void input_pension_contribution(double *pension_contribution, double *income) {
	while (1) {
		fflush(stdin);
		printf("Pension contribution (5%%) y/n? ");
        char a;
		scanf("%c", &a);
		if(a == 'y' || a == 'Y') {
			*pension_contribution = 0.05 * *income;
			return;
		}
		if(a == 'n' || a == 'N') {
			*pension_contribution = 0;
			return;
		}
		printf("Invalid input, try again.\n");
	}
}

void input_health_insurance(double *health_insurance, double *income){
	while(1) {
		fflush(stdin);
		printf("Health insurance (1%%) y/n? " );
        char a;
		scanf("%c", &a);
		if(a == 'y' || a == 'Y') {
			*health_insurance = 0.01 * *income;
			return;
        }
		if(a == 'n' || a == 'N') {
			*health_insurance = 0;
			return;
        }
		printf("Invalid input, try again.\n");
	}
}

void input_number_of_dependants(double *dependants) {
	while(1) {
        fflush(stdin);
        printf("Number of denpendants < 18 years old: ");
        char s[100];
        scanf("%s", s);
        if(!check(s)) {
            *dependants = atof(s) * dependant;
            return;
        }
        printf("Invalid input, try again.\n");
	}
}

void input_gift_of_charity(double *charity, double *income) {
	while (1) {
		fflush(stdin);
		printf("Gift of charity: ");
		char s[100];
		scanf("%s", s);
        if(*charity >= 0 && *charity <= *income && check(s) < 2) {
		    *charity = atof(s);
            return;
        }
		if(*charity > *income) printf("Gift of charity exceeds the income\n");
		else printf("Invalid input, try again.\n");
	}
}

void enter(int *n, int *list_of_code, struct employee *e) {
	while(1) {
		printf("\n");
		printf("Enter persional information:\n");
		int code = input_code(n, list_of_code);
		if(code == 0) return;
		input_name(e[code].name);
		input_income(&e[code].income);
		input_pension_contribution(&e[code].pension_contribution, &e[code].income);
		input_health_insurance(&e[code].health_insurance, &e[code].income);
		input_number_of_dependants(&e[code].dependants);
		input_gift_of_charity(&e[code].charity, &e[code].income);
        e[code].taxable_income = e[code].income
							   - yourself
							   - e[code].pension_contribution
							   - e[code].health_insurance
							   - e[code].dependants
							   - e[code].charity;
        e[code].tax = taxrate1 * amount(e[code].taxable_income, 0, 5000) 
				    + taxrate2 * amount(e[code].taxable_income, 5000, 10000)
				    + taxrate3 * amount(e[code].taxable_income, 10000, 20000)
				    + taxrate4 * amount(e[code].taxable_income, 20000, 30000)
				    + taxrate5 * amount(e[code].taxable_income, 30000, 50000)
				    + taxrate6 * amount(e[code].taxable_income, 50000, 80000)
				    + taxrate7 * amount(e[code].taxable_income, 80000, 999999999);
	}
}

void print(int *n, int *list_of_code, struct employee *e) {
	printf("Code\tName\tIncome\tAllow\tPens\tIns\tDepend\tCharity\tTaxable\tTax\tNet\n");
    printf("----------------------------------------------------------------------------------------\n");
    for(int i=0; i<*n; ++i) {
        int code = list_of_code[i];
        printf("%03d\t%s\t%.lf\t%.lf\t%.lf\t%.lf\t%.lf\t%.lf\t%.lf\t%.lf\t%.lf\n", code, e[code].name, e[code].income, yourself, e[code].pension_contribution, e[code].health_insurance, e[code].dependants, e[code].charity, e[code].taxable_income, e[code].tax, e[code].income - e[code].tax);
    }
}

void find(int *n, int *list_of_code, struct employee *e) {
    while(1) {
        fflush(stdin);
        printf("Enter code to be searched: ");
        char s[100];
		scanf("%s", s);
		if(check(s)) {
		    printf("Invalid input, try again.\n");
            continue;
        }
        int code = atoi(s);
        for(int i=0; i<*n; ++i) {
            if(code == list_of_code[i]) {
                printf("Found at position %d:\n", i);
                printf("Code\tName\tIncome\tAllow\tPens\tIns\tDepend\tCharity\tTaxable\tTax\tNet\n");
	            printf("----------------------------------------------------------------------------------------\n");
                printf("%03d\t%s\t%.lf\t%.lf\t%.lf\t%.lf\t%.lf\t%.lf\t%.lf\t%.lf\t%.lf\n", code, e[code].name, e[code].income, yourself, e[code].pension_contribution, e[code].health_insurance, e[code].dependants, e[code].charity, e[code].taxable_income, e[code].tax, e[code].income - e[code].tax);
                return;
            }
        }
        printf("Code not found, try again.\n");
    }
}

int main() {
	int n = 0;
    int list_of_code[1000];
    struct employee e[1000];
	while(1) {
        fflush(stdin);
		printf("\n");
		printf("Choose one of the following options: \n");
		printf("1. Enter a list of employees\n");
		printf("2. Display tax information\n");
		printf("3. Search an employees by code\n");
		printf("0. Exit\n");	
		printf("Your selection 0 -> 3: ");
        char s[100];
		scanf("%s", s);
		if(check(s) || atoi(s) > 3) {
		    printf("Invalid input, try again.\n");
            continue;
        }
        int choice = atoi(s);
        if(choice == 0) return 0;
		else if(choice == 1) enter(&n, list_of_code, e);
		else if(choice == 2) print(&n, list_of_code, e);
        else if(choice == 3) find(&n, list_of_code, e);
 	}
}