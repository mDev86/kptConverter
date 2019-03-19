package converter.kpt.info;

import java.io.ByteArrayInputStream;

public class DownloadFile {
    public String DownloadFileName;
    public ByteArrayInputStream DownloadFileBuffer;

    public DownloadFile(String downloadFileName, ByteArrayInputStream downloadFileBuffer) {
        DownloadFileName = downloadFileName;
        DownloadFileBuffer = downloadFileBuffer;
    }

    public String getDownloadFileName() {
        return DownloadFileName;
    }

    public void setDownloadFileName(String downloadFileName) {
        DownloadFileName = downloadFileName;
    }

    public ByteArrayInputStream getDownloadFileBuffer() {
        return DownloadFileBuffer;
    }

    public void setDownloadFileBuffer(ByteArrayInputStream downloadFileBuffer) {
        DownloadFileBuffer = downloadFileBuffer;
    }
}
