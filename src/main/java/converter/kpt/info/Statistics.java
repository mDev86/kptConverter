package converter.kpt.info;

public class Statistics {
    private int cadastralBlocksCnt = 0;
    private int parcelsCnt = 0;
    private int parcelsWGeoCnt = 0;
    private int objectsRealitiesCnt = 0;
    private int objectsRealitiesWGeoCnt = 0;

    public void increment(Statistics st) {
        incCadastralBlocksCnt(st.getCadastralBlocksCnt());
        incParcelsCnt(st.getParcelsCnt());
        incParcelsWGeoCnt(st.parcelsWGeoCnt);
        incObjectsRealityCnt(st.objectsRealitiesCnt);
        incObjectsRealitiesWGeoCnt(st.objectsRealitiesWGeoCnt);
    }

    public int getCadastralBlocksCnt() {
        return cadastralBlocksCnt;
    }

    public void incCadastralBlocksCnt(int cadastralBlocksCnt) {
        this.cadastralBlocksCnt += cadastralBlocksCnt;
    }

    public int getParcelsCnt() {
        return parcelsCnt;
    }

    public void incParcelsCnt(int parcelsCnt) {
        this.parcelsCnt += parcelsCnt;
    }

    public int getParcelsWGeoCnt() {
        return parcelsWGeoCnt;
    }

    public void incParcelsWGeoCnt(int parcelsWGeoCnt) {
        this.parcelsWGeoCnt += parcelsWGeoCnt;
    }

    public int getObjectsRealitiesCnt() {
        return objectsRealitiesCnt;
    }

    public void incObjectsRealityCnt(int objectsRealityCnt) {
        this.objectsRealitiesCnt += objectsRealityCnt;
    }

    public int getObjectsRealitiesWGeoCnt() {
        return objectsRealitiesWGeoCnt;
    }

    public void incObjectsRealitiesWGeoCnt(int objectsRealitiesWGeoCnt) {
        this.objectsRealitiesWGeoCnt += objectsRealitiesWGeoCnt;
    }
}
