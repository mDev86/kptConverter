//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sName_Contour.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sName_Contour"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Внешний контур"/&gt;
 *     &lt;enumeration value="Внутренний контур"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "sName_Contour", namespace = "urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0")
@XmlEnum
public enum SNameContour {

    @XmlEnumValue("\u0412\u043d\u0435\u0448\u043d\u0438\u0439 \u043a\u043e\u043d\u0442\u0443\u0440")
    ВНЕШНИЙ_КОНТУР("\u0412\u043d\u0435\u0448\u043d\u0438\u0439 \u043a\u043e\u043d\u0442\u0443\u0440"),
    @XmlEnumValue("\u0412\u043d\u0443\u0442\u0440\u0435\u043d\u043d\u0438\u0439 \u043a\u043e\u043d\u0442\u0443\u0440")
    ВНУТРЕННИЙ_КОНТУР("\u0412\u043d\u0443\u0442\u0440\u0435\u043d\u043d\u0438\u0439 \u043a\u043e\u043d\u0442\u0443\u0440");
    private final String value;

    SNameContour(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SNameContour fromValue(String v) {
        for (SNameContour c: SNameContour.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
