# Fixed File Format converter

The goal of this project is to write a generic tool to convert fixed file format files to csv files based on a metadata file.

Feel free to use your favorite language and libraries if needed (but no proprietary libraries, only open source), fork this project and provide your complete code including source and tests as a pull request.

## Use case

Our fixed file format files can have any number of columns
A column can be of 3 formats:
* date (format yyyy-mm-dd)
* numeric (decimal separator '.' no thousands separator can be negative)
* string

The structure of the file is described in a metadata file in csv format with a line for each column defining:
* column name
* column length
* column type

You should transform the file to a csv file (separator ',' row separator CRLF) and format the dates to dd/mm/yyyy

## Example

Data file:
```
1970-01-01John           Smith           81.5
1975-01-31Jane           Doe             61.1
1988-11-28Bob            Big            102.4
```

Metadata file:
```
Birth date,10,date
First name,15,string
Last name,15,string
Weight,5,numeric
```

Output file:
```
Birth date,First name,Last name,Weight
01/01/1970,John,Smith,81.5
31/01/1975,Jane,Doe,61.1
28/11/1988,Bob,Big,102.4
```

## Extra requirements
* files are encoded in UTF-8 and may contain special characters
* strings columns may contain characters to be escaped like ',' CR LF
* in case the format of the file is not correct, the program should fail but state explicitly why
* a fixed format file may be very big (several GB)

