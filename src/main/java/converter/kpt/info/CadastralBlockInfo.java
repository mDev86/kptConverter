package converter.kpt.info;

public class CadastralBlockInfo extends Info {
    private String cadastralNumber;
    private String exportFolder;
    private Statistics statistics = new Statistics();

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    public String getExportFolder() {
        return exportFolder;
    }

    public void setExportFolder(String exportFolder) {
        this.exportFolder = exportFolder;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
