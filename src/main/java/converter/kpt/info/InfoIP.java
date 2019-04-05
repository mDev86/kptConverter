package converter.kpt.info;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import static j2html.TagCreator.*;

public class InfoIP implements Serializable {
    private final static long serialVersionUID = 2481126669795654670L;

    @JsonProperty("as")
    private String as;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("isp")
    private String isp;
    @JsonProperty("org")
    private String org;
    @JsonProperty("proxy")
    private Boolean proxy;
    @JsonProperty("query")
    private String query;
    @JsonProperty("region")
    private String region;
    @JsonProperty("regionName")
    private String regionName;
    @JsonProperty("reverse")
    private String reverse;
    @JsonProperty("status")
    private String status;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("zip")
    private String zip;

    @JsonProperty("message")
    private String message;


    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("as")
    public String getAs() {
        return as;
    }

    @JsonProperty("as")
    public void setAs(String as) {
        this.as = as;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("isp")
    public String getIsp() {
        return isp;
    }

    @JsonProperty("isp")
    public void setIsp(String isp) {
        this.isp = isp;
    }

    @JsonProperty("org")
    public String getOrg() {
        return org;
    }

    @JsonProperty("org")
    public void setOrg(String org) {
        this.org = org;
    }

    @JsonProperty("proxy")
    public Boolean getProxy() {
        return proxy;
    }

    @JsonProperty("proxy")
    public void setProxy(Boolean proxy) {
        this.proxy = proxy;
    }

    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("regionName")
    public String getRegionName() {
        return regionName;
    }

    @JsonProperty("regionName")
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @JsonProperty("reverse")
    public String getReverse() {
        return reverse;
    }

    @JsonProperty("reverse")
    public void setReverse(String reverse) {
        this.reverse = reverse;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (query == null){
            builder.append("Информация о клиенте неизвестна");
        }else if(status.equalsIgnoreCase("fail")){
            builder.append("IP клиента: " + query);
            builder.append("\r\nПодробная информация недоступна: " + getMessage());
        }else{
            builder.append("IP клиента: " + query);
            builder.append("\r\nПодробная информация:" );

            if(this.country != null)
                builder.append("\r\nСтрана: " + getCountry() );
            if(this.regionName != null)
                builder.append("\r\nРегион: " + getRegionName() );
            if(this.city != null)
                builder.append("\r\nГород: " + getCity() );
            if(this.zip != null)
                builder.append("\r\nПочтовый индекс: " + getZip() );
            if(this.org != null)
                builder.append("\r\nОрганизация: " + getOrg() );
            if(this.isp != null)
                builder.append("\r\nИнтернет провайдер: " + getIsp() );
            if(this.proxy)
                builder.append("\r\nПрокси: " + getProxy() );
        }
        return builder.toString();
    }

    public String toHtml(){
        String html;

        if (query == null){
            html = div("Информация о клиенте неизвестна").render();
        }else if(status.equalsIgnoreCase("fail")){
            html = div(
                    text("IP клиента: " + getQuery()),
                    br(),
                    text("Подробная информация недоступна: " + getMessage())
                ).render();
        }else {
            html = div(
                    text("IP клиента: " + getQuery()),
                    br(),
                    text("Подробная информация: "),
                    br(),
                    iff(this.country != null, text("Страна: " + getCountry())),
                    br(),
                    iff(this.regionName != null, text("Регион: " + getRegionName())),
                    br(),
                    iff(this.city != null, text("Город: " + getCity())),
                    br(),
                    iff(this.zip != null, text("Почтовый индекс: " + getZip())),
                    br(),
                    iff(this.org != null, text("Организация: " + getOrg())),
                    br(),
                    iff(this.isp != null, text("Интернет провайдер: " + getIsp())),
                    br(),
                    iff(this.proxy, text("Прокси: " + getProxy()))
            ).render();
        }

        return html;
    }

}
