package biotransformerapis.predictors;

import java.util.LinkedHashMap;

public interface BioTransformerAPIs {

    public Object predict (LinkedHashMap<String, Object> inputParameters) throws Exception;
}
