//
//  main.cpp
//  HistrgrammDejavu
//
//  Created by Manuel Reich on 29.01.13.
//  Copyright (c) 2013 Manuel Reich / Kay Shoppe. All rights reserved.
//

#include <iostream>
#include <fstream>
#include <string>
using namespace std;
struct Histogram{
    int size;
    int *chars;
};


Histogram anylyseFile(string filename){
    //the histogram
    Histogram h;
    h.size = 26;
    h.chars = new int[26];
    
    //fill histogramm with zeros
    for(int i=0;i<h.size;i++) {
        h.chars[i] = 0;
    }
    
    
    //open file
    ifstream myfile(filename);
    
    if (myfile.is_open())
    {
        char letter;
        while (myfile >> letter) {
            //save letters as number so that a -> 0 and z -> 26;
            if(letter >= 'a' && letter <= 'z'){
                letter -= 'a';
                //save letters as number so that A -> 0 and Z -> 26;
            }else if(letter >= 'A' && letter <= 'Z'){
                letter -= 'A';
            }
            //increase the position of the letter in the histogram
            h.chars[letter] ++;
        }
        myfile.close();
    }
    else {
        cout << "Unable to open file";
    }
    return h;
}

void writeFile(Histogram h,char format){
    string filename = "frequency";
    string filetype = ".txt";
    string file = filename + format +filetype;
    ofstream out(file);
    int numberOfLetters;
    if (format == 'h') {
        //for every int in the histogramm array
        for(int i=0;i<h.size;i++){
            out << (char) (i+'A') << ": ";//cast i to letter in alphabet
            numberOfLetters = h.chars[i];//add as many stars as high the saved number is
            for(int t=0;t<numberOfLetters;t++){
                out << "*";
            }
            out << endl;
        }
    }else if (format== 'v'){
        //print out the alphabet in one line
        for (int i=0; i<h.size; i++) {
            out << (char) (i+'A') << "\t";
        }
        out <<endl;
        
        bool lastLine = false;
        //print a new line until an empty one was printed
        for(int t=0;!lastLine;t++){
            lastLine = true;//expext every line to be the last one
            for (int i=0; i<h.size; i++) {
                if(t < h.chars[i]){
                    out << "*\t";
                    lastLine = false;//this isa not an empty line
                }else{
                    out << "\t";
                }
            }
            out << endl;
        }
    }
    out.close();
}

int main(int argc, const char * argv[])
{
    Histogram frequency = anylyseFile("text.txt");
    writeFile(frequency,'v');
    writeFile(frequency,'h');
    
    return 0;
}

