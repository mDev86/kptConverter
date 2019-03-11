package converter.kpt.info;

public class Info {
    private String errorMsg = "";

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg += (this.errorMsg.length() > 0)?"\\r\\n":"" + errorMsg;
    }
}
