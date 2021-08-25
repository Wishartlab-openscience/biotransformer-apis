package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import org.apache.commons.lang3.StringUtils;

public class Validator {

    public enum ioFormats{
        SDFILE, IATOMCONTAINERSET
    }
    LinkedHashMap<String, ArrayList<String>> validParams = new LinkedHashMap<String, ArrayList<String>>();

    public Validator() {
        ArrayList<String> required = new ArrayList<String>();
        ArrayList<String> optional = new ArrayList<String>();
        required.add("input");
        required.add("inputFormat");
        required.add("outputFormat");
        optional.add("output");
        this.validParams.put("required", required);
        this.validParams.put("optional", required);
    }

    public Boolean validateParameters(LinkedHashMap<String, Object> parameters) throws Exception {
        Boolean isValid = true;

        for(String requiredParam : validParams.get("required")) {
            if(!parameters.containsKey(requiredParam)) {
                throw new IOException("The required parameter \'" + requiredParam + "\' is missing. Please provide an adequate value.");
            }
        }


        ioFormats inputFormat           = ioFormats.valueOf( StringUtils.upperCase( (String) parameters.get("inputFormat") ))  ;
        ioFormats outputFormat              = ioFormats.valueOf( StringUtils.upperCase( (String) parameters.get("outputFormat") ))  ;


        if(!Arrays.asList(ioFormats.values()).contains(inputFormat)) {
            isValid = false;
            throw new IOException("The provided input \'" + inputFormat + "\' format is not support by PhaseIIFilter");
        }
        if(!Arrays.asList(ioFormats.values()).contains(outputFormat)) {
            isValid = false;
            throw new IOException("The provided output \'" + inputFormat + "\' format is not support by PhaseIIFilter");
        }

        if(inputFormat == ioFormats.SDFILE) {
            File inputFile = new File((String) parameters.get("input"));
            if((!inputFile.exists()) || inputFile.isDirectory()) {
                isValid = false;
                throw new IOException("A pathname to the input file is missing. Please provide a pathname to the input file");

            }
        }

        if(outputFormat == ioFormats.SDFILE && !parameters.containsKey("output")) {
            isValid = false;
            throw new IOException("A pathname to the output file is missing. Please provide a pathname to the output file");
        }

        return  isValid;
    }
}
