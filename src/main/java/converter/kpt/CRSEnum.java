package converter.kpt;

import mil.nga.sf.geojson.Crs;

import java.util.HashMap;
import java.util.Map;

public enum CRSEnum {

    МСК86_Зона_1 {
        @Override
        public Crs getCRS() {
            return getCRSByPP("+proj=tmerc +lat_0=0 +lon_0=60.05 +k=1 +x_0=1500000 +y_0=-5811057.63 +ellps=krass +towgs84=23.57,-140.95,-79.8,0,0.35,0.79,-0.22 +units=m +no_defs");
        }
    },
    МСК86_Зона_2 {
        @Override
        public Crs getCRS() {
            return getCRSByPP("+proj=tmerc +lat_0=0 +lon_0=66.05 +k=1 +x_0=2500000 +y_0=-5811057.63 +ellps=krass +towgs84=23.57,-140.95,-79.8,0,0.35,0.79,-0.22 +units=m +no_defs");
        }
    },
    МСК86_Зона_3 {
        @Override
        public Crs getCRS() {
            return getCRSByPP("+proj=tmerc +lat_0=0 +lon_0=72.05 +k=1 +x_0=3500000 +y_0=-5811057.63 +ellps=krass +towgs84=23.57,-140.95,-79.8,0,0.35,0.79,-0.22 +units=m +no_defs");
        }
    },
    МСК86_Зона_4 {
        @Override
        public Crs getCRS() {
            return getCRSByPP("+proj=tmerc +lat_0=0 +lon_0=78.05 +k=1 +x_0=4500000 +y_0=-5811057.63 +ellps=krass +towgs84=23.57,-140.95,-79.8,0,0.35,0.79,-0.22 +units=m +no_defs");
        }
    },
    МСК86_Зона_5 {
        @Override
        public Crs getCRS() {
            return getCRSByPP("+proj=tmerc +lat_0=0 +lon_0=84.05 +k=1 +x_0=5500000 +y_0=-5811057.63 +ellps=krass +towgs84=23.57,-140.95,-79.8,0,0.35,0.79,-0.22 +units=m +no_defs");
        }
    };

    public abstract Crs getCRS();

    private static Crs getCRSByPP(String projParam) {
        Crs crs = new Crs();

        crs.setType(Crs.CrsType.name);
        Map<String, Object> crsProp = new HashMap<String, Object>();
        crsProp.put("name", projParam);
        crs.setProperties(crsProp);

        return  crs;
    }

    public static CRSEnum get(String name) {
        try {
            return CRSEnum.valueOf(name);
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
