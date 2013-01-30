//
//  main.cpp
//  PointersAndClasses
//
//  Created by Manuel Reich on 30.01.13.
//  Copyright (c) 2013 Manuel Reich / Kay Shoppe. All rights reserved.
//

#include <iostream>
#include <string>

using namespace std;

//Write a method in C++ void removeSpaces (char* s) that removes all blanks in a char array s. For example, "a bb ccc d" will be changed "to abbcccd". Use pointers! Is there a difference in calling this with a string or a character array? Now overload removeSpaces and make it take an array of char arrays, and remove the spaces out of all elements of the array, using pointers.


void removeSpaces(char *c);
void removeSpaces(char *s[]);

int main(int argc, const char * argv[])
{
    char c[] = {"bla bla\0"};       // generate a char array
    char test1[] = {"hal lo\0"};
    char test2[] = {"zu uu\0"};
    char *s[] = {test1,test2,0};
    
    cout << c << endl;              // output the char array
    removeSpaces(&c[0]);            // pass the adress of the first element of the char array removeSpaces(c); would do the same
    cout << c << endl;              // this prints out the array witout blanks since it was overwritten
    
    removeSpaces(s);
    cout << s[0] << s[1];
    return 0;
}

// takes a pointer to an array and overwrites the array with itself witout blanks
void removeSpaces(char *c){
    char *p;                        //a pointer
    //start by let p point to the adress of (the first element in the array) # increase the adress of s until it points to 0 which is the end a string
    for(p=c;*c!='\0';c++){
        if(*c != ' '){              // if the value of s is not the whitespace
            *p = *c;                // write the value of s to the adress of p
            p++;                    // increse the adress of p
        }
    }
    *p = '\0';                      // add the endofString character to the adress of p;
}

// call removeSpaces for every element in a given array 
void removeSpaces(char *s[]){
    while(*s != 0){                 // !=0 is redundant but i need it to follow the code
        removeSpaces(*s);           // the value of s is a pointer to the first element in a char array
        s++;
    }
}