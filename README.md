# biotransformer-apis
A library that provides APIs to facilitate the integration of various libraries into BioTransformer.
This repository contains the Predictor Model Interface which every Java Loadable prediction application should implement.

<br>

To add this to your project -
1. Build the project.
2. Create a lib/ folder outside of src/ in your application.
3. Put the biotransformer-api.jar in the the lib/ folder.
4. Run Maven Goal -
   mvn org.apache.maven.plugins:maven-install-plugin:3.0.0-M1:install-file -Dfile=lib/biotransformer-api.jar -DgroupId=biotransformer -DartifactId=biotransformer-api -Dversion=1.0.0 -Dpackaging=jar
5. This would install the jar in your local .m2 directory.
6. Implement the interface now. 