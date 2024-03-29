//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.*;


/**
 * Почтовый адрес
 * 
 * <p>Java class for tAddressOut complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tAddressOut"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OKATO" type="{urn://x-artefacts-smev-gov-ru/supplementary/commons/1.0.1}OKATOType" minOccurs="0"/&gt;
 *         &lt;element name="KLADR" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s20" minOccurs="0"/&gt;
 *         &lt;element name="OKTMO" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/2.0.1}OKTMOType" minOccurs="0"/&gt;
 *         &lt;element name="PostalCode" type="{urn://x-artefacts-smev-gov-ru/supplementary/commons/1.0.1}PostalCodeRFType" minOccurs="0"/&gt;
 *         &lt;element name="Region" type="{urn://x-artefacts-rosreestr-ru/commons/directories/regions/1.0.1}dRegionsRF"/&gt;
 *         &lt;element name="District" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tNameAddr" minOccurs="0"/&gt;
 *         &lt;element name="City" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tNameAddr" minOccurs="0"/&gt;
 *         &lt;element name="UrbanDistrict" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tUrbanDistrict" minOccurs="0"/&gt;
 *         &lt;element name="SovietVillage" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tSovietVillage" minOccurs="0"/&gt;
 *         &lt;element name="Locality" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tNameAddr" minOccurs="0"/&gt;
 *         &lt;element name="Street" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tNameAddr" minOccurs="0"/&gt;
 *         &lt;element name="Level1" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tLevel1" minOccurs="0"/&gt;
 *         &lt;element name="Level2" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tLevel2" minOccurs="0"/&gt;
 *         &lt;element name="Level3" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tLevel3" minOccurs="0"/&gt;
 *         &lt;element name="Apartment" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tApartment" minOccurs="0"/&gt;
 *         &lt;element name="Other" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s2500" minOccurs="0"/&gt;
 *         &lt;element name="Note" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s4000" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}AddressOrLocation"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAddressOut", namespace = "urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1", propOrder = {
    "okato",
    "kladr",
    "oktmo",
    "postalCode",
    "region",
    "district",
    "city",
    "urbanDistrict",
    "sovietVillage",
    "locality",
    "street",
    "level1",
    "level2",
    "level3",
    "apartment",
    "other",
    "note"
})
public class TAddressOut {

    @XmlElement(name = "OKATO")
    protected String okato;
    @XmlElement(name = "KLADR")
    protected String kladr;
    @XmlElement(name = "OKTMO")
    protected String oktmo;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "Region", required = true)
    protected String region;
    @XmlElement(name = "District")
    protected TNameAddr district;
    @XmlElement(name = "City")
    protected TNameAddr city;
    @XmlElement(name = "UrbanDistrict")
    protected TUrbanDistrict urbanDistrict;
    @XmlElement(name = "SovietVillage")
    protected TSovietVillage sovietVillage;
    @XmlElement(name = "Locality")
    protected TNameAddr locality;
    @XmlElement(name = "Street")
    protected TNameAddr street;
    @XmlElement(name = "Level1")
    protected TLevel1 level1;
    @XmlElement(name = "Level2")
    protected TLevel2 level2;
    @XmlElement(name = "Level3")
    protected TLevel3 level3;
    @XmlElement(name = "Apartment")
    protected TApartment apartment;
    @XmlElement(name = "Other")
    protected String other;
    @XmlElement(name = "Note")
    protected String note;
    @XmlAttribute(name = "AddressOrLocation", namespace = "urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1")
    protected String addressOrLocation;

    /**
     * Gets the value of the okato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOKATO() {
        return okato;
    }

    /**
     * Sets the value of the okato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOKATO(String value) {
        this.okato = value;
    }

    /**
     * Gets the value of the kladr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKLADR() {
        return kladr;
    }

    /**
     * Sets the value of the kladr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKLADR(String value) {
        this.kladr = value;
    }

    /**
     * Gets the value of the oktmo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOKTMO() {
        return oktmo;
    }

    /**
     * Sets the value of the oktmo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOKTMO(String value) {
        this.oktmo = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link TNameAddr }
     *     
     */
    public TNameAddr getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNameAddr }
     *     
     */
    public void setDistrict(TNameAddr value) {
        this.district = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link TNameAddr }
     *     
     */
    public TNameAddr getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNameAddr }
     *     
     */
    public void setCity(TNameAddr value) {
        this.city = value;
    }

    /**
     * Gets the value of the urbanDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link TUrbanDistrict }
     *     
     */
    public TUrbanDistrict getUrbanDistrict() {
        return urbanDistrict;
    }

    /**
     * Sets the value of the urbanDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUrbanDistrict }
     *     
     */
    public void setUrbanDistrict(TUrbanDistrict value) {
        this.urbanDistrict = value;
    }

    /**
     * Gets the value of the sovietVillage property.
     * 
     * @return
     *     possible object is
     *     {@link TSovietVillage }
     *     
     */
    public TSovietVillage getSovietVillage() {
        return sovietVillage;
    }

    /**
     * Sets the value of the sovietVillage property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSovietVillage }
     *     
     */
    public void setSovietVillage(TSovietVillage value) {
        this.sovietVillage = value;
    }

    /**
     * Gets the value of the locality property.
     * 
     * @return
     *     possible object is
     *     {@link TNameAddr }
     *     
     */
    public TNameAddr getLocality() {
        return locality;
    }

    /**
     * Sets the value of the locality property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNameAddr }
     *     
     */
    public void setLocality(TNameAddr value) {
        this.locality = value;
    }

    /**
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link TNameAddr }
     *     
     */
    public TNameAddr getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNameAddr }
     *     
     */
    public void setStreet(TNameAddr value) {
        this.street = value;
    }

    /**
     * Gets the value of the level1 property.
     * 
     * @return
     *     possible object is
     *     {@link TLevel1 }
     *     
     */
    public TLevel1 getLevel1() {
        return level1;
    }

    /**
     * Sets the value of the level1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLevel1 }
     *     
     */
    public void setLevel1(TLevel1 value) {
        this.level1 = value;
    }

    /**
     * Gets the value of the level2 property.
     * 
     * @return
     *     possible object is
     *     {@link TLevel2 }
     *     
     */
    public TLevel2 getLevel2() {
        return level2;
    }

    /**
     * Sets the value of the level2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLevel2 }
     *     
     */
    public void setLevel2(TLevel2 value) {
        this.level2 = value;
    }

    /**
     * Gets the value of the level3 property.
     * 
     * @return
     *     possible object is
     *     {@link TLevel3 }
     *     
     */
    public TLevel3 getLevel3() {
        return level3;
    }

    /**
     * Sets the value of the level3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLevel3 }
     *     
     */
    public void setLevel3(TLevel3 value) {
        this.level3 = value;
    }

    /**
     * Gets the value of the apartment property.
     * 
     * @return
     *     possible object is
     *     {@link TApartment }
     *     
     */
    public TApartment getApartment() {
        return apartment;
    }

    /**
     * Sets the value of the apartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link TApartment }
     *     
     */
    public void setApartment(TApartment value) {
        this.apartment = value;
    }

    /**
     * Gets the value of the other property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOther(String value) {
        this.other = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Gets the value of the addressOrLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressOrLocation() {
        return addressOrLocation;
    }

    /**
     * Sets the value of the addressOrLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressOrLocation(String value) {
        this.addressOrLocation = value;
    }

}
