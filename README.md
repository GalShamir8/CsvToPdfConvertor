# CSV to PDF Converter Library - Version 1.0

We are excited to announce the release of version 1.0 of the CSV to PDF Converter Library. 
This library provides a simple and efficient solution for converting CSV files to PDF format in Android applications. 
With this release, developers can seamlessly integrate CSV to PDF conversion functionality into their projects.

## Features in Version 1.0

- Convert CSV files to PDF format effortlessly.
- Support for customizable PDF document settings, including page size and orientation.
- Automatic formatting and layout of CSV data in the resulting PDF document.
- Generate PDF documents compatible with popular PDF viewer applications.

### installation

**STEP 1 -> Add to your settings.gradle file:**
```
pluginManagement {
    repositories {
        ...
        mavenCentral()
        maven { url 'https://jitpack.io' }
        ...
    }
}
```

**STEP 2 -> Add to your build.gradle file (.app):** (replce with specific tag)
```
dependencies {
  ...
	'com.github.GalShamir8:CsvToPdfConvertor:Tag'
  ...
}
```
Click the "Sync Now" button to sync the Gradle project.
Ready to Go!

### Usage

To convert a CSV file to a PDF document, follow these steps:

1. Create an instance of the `CsvConverter` class:

```java
CsvConverter csvConverter = new CsvConverter(getApplicationContext(), FILE_PATH);        
```
2. Call the `convertCsvToPdf()` method and provide the file path of the CSV file:
```java
boolean success = csvConverter.convertCsvToPdf();
```
3. Handle the generated PDF file as needed. You can open it using an external PDF viewer or perform further operations on the file.
Note to handle file IOException using `csvConverter.getErrors()` if needed.
```java
  if (success) {
      File pdfFile = csvConverter.getPdfFile();
      // do something
  } else {
      ArrayList<Exception> errors = csvConverter.getErrors();
      // handle errors
  }
```
## Feedback and Contributions

We appreciate your feedback and contributions to enhance the library. 
If you encounter any issues or have suggestions for improvements, please open an issue on the [GitHub repository](https://github.com/GalShamir8/CsvToPdfConvertor/issues).
We welcome contributions!
If you would like to contribute to the project, please check out the [contribution guidelines](https://github.com/GalShamir8/CsvToPdfConvertor/blob/master/CONTRIBUTING.md).

Thank you for using the CSV to PDF Converter Library. We hope it simplifies your CSV to PDF conversion needs in your Android projects!
