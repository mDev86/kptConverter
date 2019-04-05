package converter.kpt.info;

import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.base;

public class CadastralBlockContent {
    private String Layout;
    private List<String> Parcels;
    private List<String> OKS;

    public CadastralBlockContent() {
        Parcels = new ArrayList<>();
        OKS = new ArrayList<>();
    }

    public CadastralBlockContent(String layout) {
        this();
        Layout = layout;
    }

    public String getLayout() {
        return Layout;
    }

    public void setLayout(String layout) {
        Layout = layout;
    }

    public List<String> getParcels() {
        return Parcels;
    }

    public void setParcels(List<String> parcels) {
        Parcels = parcels;
    }

    public List<String> getOKS() {
        return OKS;
    }

    public void setOKS(List<String> OKS) {
        this.OKS = OKS;
    }
}
