package converter.kpt.info;

import java.util.ArrayList;
import java.util.List;

public class FileInfo extends Info {
    private String fileName;
    private boolean converted = true;
    List<CadastralBlockInfo> cadastralBlocks = new ArrayList<CadastralBlockInfo>();

    public FileInfo(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isConverted() {
        return converted;
    }

    public void setConverted(boolean converted) {
        this.converted = converted;
    }

    public List<CadastralBlockInfo> getCadastralBlocks() {
        return cadastralBlocks;
    }
}
