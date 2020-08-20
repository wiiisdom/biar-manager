![Java CI with Maven](https://github.com/gbandsmith/biar-manager/workflows/Java%20CI%20with%20Maven/badge.svg) [![javadoc](https://javadoc.io/badge2/com.gbandsmith/biar-manager/javadoc.svg)](https://javadoc.io/doc/com.gbandsmith/biar-manager) 

# biar-manager

**biar-manager** is a java library that can read and manage a BIAR file generated 
from SAP Business Objects platform. The BIAR format (Business Intelligence ARchive) 
is a format used to extract and import BI content from and to SAP Business Objects
system.

The goal of this library is to allow listing, reading, extracting and modifying the
BIAR format.

Actually the library is able to read from the `lcmbiar` format (SAP Business Objects BI4.x)

## How to use it ?

Add it to your maven project:

In `dependencies`:
```
<dependency>
  <groupId>com.gbandsmith</groupId>
  <artifactId>biar-manager</artifactId>
  <version>1.0.2</version>
</dependency>
```

Then use it:

```
String file = './file.lcmbiar'
LCMBiarFile biarFile = new LCMBiarFile(file);

// The index is listing all the content of the BIAR file
InfoObjects obj = biarFile.getIndex();

// To get an InputStream of the first file of an object
InputStream inputStream = biarFile.getFile(infoObject, 1);
```

## Release

The project is setup to be released on [Sonatype OSSRH](https://oss.sonatype.org).

Main steps for the release:

```
# Set the version
mvn versions:set -DnewVersion=1.0.0

# Deploy
mvn clean deploy
```

## Thanks

- https://archive.sap.com/documents/docs/DOC-53904 for the sample audit lcmbiar file
- https://github.com/unistra/budgetweb for the budgetweb lcmbiar file
- https://wiki.scn.sap.com/wiki/display/BOBJ/Java+samples+using+the+SAP+BusinessObjects+RESTful+Web+Service+SDK+for+Web+Intelligence+to+refresh+Webi+documents for the LCM_BIAR_File_With_Refresh_Sample_Webi_Reports.lcmbiar
- https://answers.sap.com/questions/12959140/database-administration-1.html for BIRA lcmbiar files
