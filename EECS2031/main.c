#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

 int number = 1;

void swap(int *firstFlag, int *secondFlag){
    int temp = *firstFlag;
    *firstFlag = *secondFlag;
    *secondFlag = temp;
}

void printArray(int *array_ptr, int *array_size){

    if(*array_size < 0){
        printf("Invalid Index. : %d", *array_size);
    }else{
        printf("[");

        if(*array_size > 0){
            for(int i = 0; i < *array_size; i++){
                printf("%d",array_ptr[i]);
                if(i != *array_size-1){
                    printf(", ");
                }
            }
        }

        printf("]");
    }
}

void bubbleSort(){
    int array_size = 0;
    int *array_size_ptr = &array_size;
    int *array_ptr;

    printf("Type array size: "); scanf("%d",array_size_ptr);
    array_ptr = malloc( *array_size_ptr * sizeof(int));
    //array_ptr = calloc( *array_size_ptr, sizeof(int));
    printf("Done allocating\n\n");

    printf("size : %d\n", *array_size_ptr );

    for(int i = 0 ; i < *array_size_ptr; i++){
        printf("Type %dth number : ", i);
        scanf("%d",array_ptr+i);
    }

    printf("\nFinished filling array. Your array is...\n");
    printArray(array_ptr,array_size_ptr);
    printf("\n");

    int boolean_isSorted = 0;
    int pivot = 0;
    int *ptr_firstFlag;
    int *ptr_secondFlag;

    printf("Set parameters ready.\n");

    while(boolean_isSorted == 0){
        boolean_isSorted = 1;

        if(*array_size_ptr == 2){
            if(*array_ptr > *(array_ptr+1)){
                swap(array_ptr, (array_ptr+1));
            }
        }else if(*array_size_ptr > 2){

            while(pivot != *array_size_ptr-1){
                ptr_firstFlag = array_ptr + pivot;
                ptr_secondFlag = ptr_firstFlag + 1;

                if(*ptr_firstFlag > *ptr_secondFlag){
                    swap(ptr_firstFlag,ptr_secondFlag);
                    boolean_isSorted = 0;
                }

                pivot++;
            }
            pivot = 0;
        }
    }
    printf("Bubble sort complete. The array is...\n");
    printArray(array_ptr,array_size_ptr);

    printf("\n");

    free(array_ptr);
}

void findMaxAndMin(){
    //
    int array_size = 0;
    int *array_size_ptr = &array_size;
    int *array_ptr;

    printf("Type array size: "); scanf("%d",array_size_ptr);
    array_ptr = malloc( *array_size_ptr * sizeof(int));
    //array_ptr = calloc( *array_size_ptr, sizeof(int));
    printf("Done allocating\n\n");

    printf("size : %d\n", *array_size_ptr );

    if(*array_size_ptr > 0){
        for(int i = 0 ; i < *array_size_ptr; i++){
            printf("Type %dth number : ", i);
            scanf("%d",array_ptr+i);
        }
    }
    printf("\nFinished filling array. Your array is...\n");
    printArray(array_ptr,array_size_ptr);
    printf("\n");

    //
    int maxNum = -1;
    int minNum = -1;
    if(*array_size_ptr == 0){
        maxNum = -1;
        minNum = -1;
    }else if(*array_size_ptr == 1){
        maxNum = *array_ptr;
        minNum = maxNum;
    }else if(*array_size_ptr >= 2){
        maxNum = *array_ptr;
        minNum = *array_ptr;
        for(int i = 1 ; i < *array_size_ptr; i++){
            int currentNumber = *(array_ptr+i);
            if(maxNum < currentNumber){
                maxNum = currentNumber;
            }
            if(minNum > currentNumber){
                minNum = currentNumber;
            }
        } // end for
    } // end if

     printf("From the array given \n");
     printArray(array_ptr,array_size_ptr);
     printf("\n");
     printf("Max = %d, Min = %d\n", maxNum, minNum);

    free(array_ptr);
}

void transposeMatrix(){
    int **matrix;
    int row, column;

    printf("Input the rows and columns of the matrix : ");
    scanf("%d %d",&row, &column);
    printf("row and column : %d %d\n", row, column);

    matrix = (int **)malloc(row * sizeof(int *));

    for(int i = 0 ; i < row ; i++){
        matrix[i] = (int *)malloc(column * sizeof(int));
    }

    printf("Allocation finished.\n\n");

    printf("Input elements in the first matrix : \n");

    for(int i = 0 ; i < row ; i++){
        for(int j = 0 ; j < column ; j++){
            printf("element - [%d],[%d] : ", i,j);
            scanf("%d", &matrix[i][j]);
        }
    }

    printf("\nThe matrix is : \n");

    for(int i = 0; i < row; i++){
        for(int j = 0 ; j < column ; j++){
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }

    printf("\nThe transpose of a matrix is : \n");

    for(int j = 0 ; j < column ; j++){
        for(int i = 0; i < row; i++){
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }


    return;
}

void reverseArrays(){
    char array_char[1000];
    printf("Type string to reverse : "); gets(array_char);
    printf("Your string : %s", array_char);
    printf("\nReversed string : ");

    int length = 0;
    while((array_char[length++]) != '\0');

    for(int i = length-2; i >= 0 ; i--){
        printf("%c", array_char[i]);
    }
}

void reversePointer(){
    char array_char[1000];
    printf("Type string to reverse : "); gets(array_char);
    printf("Your string : %s", array_char);
    printf("\nReversed string : ");

    char *ptr_string = array_char;

    int length = 0;
    while(ptr_string[length++] != '\0');
    length-= 2;

    char *ptr_char = malloc(length * sizeof(char));
    for(int i = length; i >= 0; i--){
        ptr_char[length-i] = ptr_string[i];
        printf("%c",ptr_char[length-i]);
    }
    printf("\n");
}

void reverse(char *str_original, int first, int last){

    // base case
    if(first >= last){
        return;
    }


   char temp = *(str_original+first);
   *(str_original+first) = *(str_original+last);
   *(str_original+last) = temp;

    reverse(str_original, ++first, --last);

    return;
}

void reverseRecursive(){
    char array_char[1000];
    printf("Type string to reverse : "); gets(array_char);
    printf("Your string : %s", array_char);
    printf("\nReversed string : ");
    int length = strlen(array_char);

    reverse(array_char, 0, length-1);

    printf("%s\n", array_char);
    return;
}

void concatenateArray(){
    char first[1000];
    char second[1000];

    printf("Type first string to concatanate : ");
    gets(first);

    printf("Type second string to concatanate : ");
    gets(second);

    int firstLength = 0;
    while((first[firstLength++]) != '\0');
    firstLength--;

    int secondLength = 0;
    while((second[secondLength] != '\0')){
        first[firstLength] = second[secondLength];
        firstLength++;
        secondLength++;
    }

    printf("The string is : %s", first);

}

void concatenatePointer(){
    char first[1000];
    char second[1000];

    printf("Type first string to concatanate : ");
    gets(first);

    printf("Type second string to concatanate : ");
    gets(second);

    char *ptr_first = first;
    char *ptr_second = second;

    while(*ptr_first){
        ptr_first++;
    }
    while(*ptr_second){
        *ptr_first = *ptr_second;
        ptr_first++;
        ptr_second++;
    }
    *ptr_first = '\0';

    printf("finished : %s", first);

}

void sortStringAlphabet(){
    char first[1000];

    printf("Type first string to sort : ");
    gets(first);

    char *copyFirst = first;
    int length = strlen(first);
    char *result = malloc(length * sizeof(char));
    int resultLength = 0;

    for(char i = 'a'; i <= 'z'; i++){
        for(int j = 0; j < length ; j++){
            if(first[j] == i){
                result[resultLength] = copyFirst[j];
                resultLength++;
            }
        }
        copyFirst = first;
    }
    result[resultLength] = '\0';
    printf("result : %s", result);

    free(result);

}

typedef struct Complex{
    float real;
    float imaginary;
}Complex;

void complexAddition(){
    Complex first, second, result;

    printf("Type first complex number(real imaginary) : ");
    scanf("%f %f", &first.real, &first.imaginary);

    printf("Type second complex number(real imaginary) : ");
    scanf("%f %f", &second.real, &second.imaginary);

    result.real = first.real + second.real;
    result.imaginary = first.imaginary + second.imaginary;

    printf("Result is : %.3f %f", result.real, result.imaginary);

}

int factorial(int n){

    if(n == 1){
        return 1;
    }else{

        return n * factorial(--n);
    }
}

void factorialRecursion(){
    int n = 0;
    printf("type number n to factorial : "); scanf("%d",&n);
    int result = factorial(n);
    printf("The result is : %d", result);

}

void commandLineInputCalculator(int argc, char *argv[]){
    int first;
    char operation;
    int second;
    int result;

    if(argc != 4){
        printf("Invalid arguments");
        exit(EXIT_FAILURE);
    }
    first = atoi(argv[1]);
    operation = *argv[2];
    second = atoi(argv[3]);

    printf("Input is : %d %c %d\n", first, operation, second);

    switch(operation){
        case '+':
            result = first + second;
        break;
        case '-':
            result = first - second;
        break;
        case '*':
            result = first * second;
        break;
        case '/':
            result = first / second;
        break;
        default:
            result = 0;
        break;
    }

    printf("result is : %d", result);
}

void fileWrite(){
    FILE *ptr_file;

    typedef struct Employee{
        int employee_number;
        char name[10];
        int age;
    }Employee;

    Employee faculty[10];

    ptr_file = fopen("employee_data.data", "w");
    printf("\nType the employee data (id name age)\n");

    for(int i = 0; i<10 ; i++){
        scanf("%d %s %d", &faculty[i].employee_number, &faculty[i].name, &faculty[i].age);
        fprintf(ptr_file, "%d %s %d\n", faculty[i].employee_number, faculty[i].name, faculty[i].age);
    }
    fclose(ptr_file);

    ptr_file = fopen("employee_data.data", "r");
    printf("\nThe file re-read is :\n");

    Employee console_out_faculty[10];
    int i = 0;

    while(!feof(ptr_file)){
        fscanf(ptr_file, "%d %s %d\n", &console_out_faculty[i].employee_number, &console_out_faculty[i].name, &console_out_faculty[i].age);
        printf("%d %s %d\n", console_out_faculty[i].employee_number, console_out_faculty[i].name, console_out_faculty[i].age);
        i++;
    }
    fclose(ptr_file);
}

void fileConvert(){
    const char *fileName = "sample.txt";

    FILE *ptr_inFile, *ptr_outFile;

    ptr_inFile = fopen(fileName, "r");

    if(ptr_inFile == NULL){
        printf("File open error");
        return EXIT_FAILURE;
    }

    ptr_outFile = fopen("temp.txt", "w");

    if(ptr_outFile == NULL){
        printf("File create error");
    }
    char character;
    while((character = fgetc(ptr_inFile)) != EOF){
        if(islower(character)){
            character = character-32;
        }
        putc(character, ptr_outFile);
    }
    fclose(ptr_inFile);
    fclose(ptr_outFile);

    rename("temp.txt",fileName);
    //remove("temp.txt");

    ptr_inFile = fopen(fileName, "r");
    if(ptr_inFile == NULL){
        printf("Error Opening file.\n");
    }

    printf("Inside of the file");
    while((character = fgetc(ptr_inFile)) != EOF){
        printf("%c", character);
    }
    printf("\n");
    fclose(ptr_inFile);

}



int main(int argc, char *argv[] ){

    //bubbleSort();
    //findMaxAndMin();
    //transposeMatrix();
    //reverseArrays();
    //reversePointer();
    //reverseRecursive();
    //concatenateArray();
    //concatenatePointer();
    //sortStringAlphabet();
    //complexAddition();
    //factorialRecursion();
    //commandLineInputCalculator(argc, argv);
    //fileWrite();
    fileConvert();
    return 0;
}
