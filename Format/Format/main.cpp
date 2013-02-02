//
//  main.cpp
//  Format
//
//  Created by Manuel Reich on 30.01.13.
//  Copyright (c) 2013 Manuel Reich / Kay Shoppe. All rights reserved.
//

#include <iostream>
#include <iomanip>
#include <sstream>
using namespace std;

class Format{
protected:
    int length, decimal;
    
public:
    Format(){
    }
    
    Format(int l, int d){
        length = l;
        decimal = d;
    }
    
    string toString(double number){
        //convert number to String
        ostringstream sstream;
        //fixed does the trick we need fixed notaion get the right formating when converting to a string
        sstream << fixed << setprecision(decimal) << number;
        string sNumber = sstream.str();
        string output;
        
        //get the length of the String
        long strLength = sNumber.length();
        //do we need indentation
        if(strLength<=length){
            //how many blanks do we need
            int indent = (int)(length - strLength);
            
            //generate a char array and fill it with blanks
            char blanks[indent];
            for (int i=0; i<indent; i++) {
                blanks[i] = ' ';
            }
            //make a String out of the char array
            blanks[indent] = '\0';
            output = blanks;
            //append the number to the leading blanks
            output.append(sNumber);
        }else{
            //if number is larger than wide print it anyway but with a warning
            output = sNumber + "    !number is to long";
        }
        return output;
    }
    
};

class Currancy : public Format{
public:
    Currancy(int l, int d):Format(l,d){
        //just call the Constructor of the super Class
    }
    
    string toString(double number,string curr){
        bool leadingSymbol = false;
        string niceString = Format::toString(number);
        if(curr.compare("$")){
                leadingSymbol = true;
        }
        else if(curr =="€"){
                leadingSymbol = false;
        }
        else if(curr =="£"){
                leadingSymbol = true;
        }
        if (leadingSymbol) {
            return curr.append(niceString);
        }else{
            return niceString.append(curr);
        }
        
    }
    
};

int main(int argc, const char * argv[]){

    Format f = Format(20,6);
    //numbers smaller than one or negative numbers are not a problem
    cout << f.toString(0.4798) << endl;
    cout << f.toString(-47777789.4798) << endl;
    cout << f.toString(-45477789.4798) << endl;
    Currancy c = Currancy(15,2);
    cout << c.toString(23402.5,"$") << endl;
    return 0;
    
    
}