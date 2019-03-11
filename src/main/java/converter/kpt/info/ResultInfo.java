package converter.kpt.info;

import java.util.ArrayList;
import java.util.List;

public class ResultInfo extends Info {

    private int convertedFilesCnt = 0;
    private int errorFilesCnt = 0;
    private List<FileInfo> filesInfo = new ArrayList<FileInfo>();

    public int getConvertedFilesCnt() {
        return convertedFilesCnt;
    }

    public void incConvertedFilesCnt(int convertedFilesCnt) {
        this.convertedFilesCnt += convertedFilesCnt;
    }

    public int getErrorFilesCnt() {
        return errorFilesCnt;
    }

    public void incErrorFilesCnt(int errorFilesCnt) {
        this.errorFilesCnt += errorFilesCnt;
    }

    //todo перестчет один раз
    public Statistics getStatistics() {
        Statistics st = new Statistics();
        for (FileInfo fi: filesInfo)
            for (CadastralBlockInfo cb: fi.getCadastralBlocks())
                st.increment(cb.getStatistics());

        return st;
    }

    public List<FileInfo> getFilesInfo() {
        return filesInfo;
    }
}
