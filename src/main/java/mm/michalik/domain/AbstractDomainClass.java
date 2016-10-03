package mm.michalik.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import mm.michalik.util.LocalDateToDateConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by maciej on 24.07.16.
 */
@MappedSuperclass
public class AbstractDomainClass implements DomainObject {

    @Transient
    private DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd:MM:yyyy hh:mm");


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @JsonIgnore
   @Convert(converter = LocalDateToDateConverter.class)
    private LocalDate dateCreated;

    @JsonIgnore
    @Convert(converter = LocalDateToDateConverter.class)
    private LocalDate lastUpdated;


    @Transient
    @JsonProperty("dateCreated")
    private String dateCreatedString;
    @Transient
    @JsonProperty("lastCreated")
    private String lastUpdatedString;



    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public LocalDate getDateCreated() {


        return dateCreated;
    }

    public LocalDate getLastUpdated() {

        return lastUpdated;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = LocalDate.now();
        if (dateCreated == null) {
            dateCreated = LocalDate.now();
        }

    }



    public String getDateCreatedString() {
        setDateCreatedString();
        return dateCreatedString;
    }

    public String getLastUpdatedString() {
        setLastUpdatedString();
        return lastUpdatedString;
    }


    private void setDateCreatedString() {
        this.dateCreatedString = dateCreated.format(formatter).toString();
    }

    private void setLastUpdatedString() {
        this.lastUpdatedString = lastUpdated.format(formatter).toString();
    }

    @Override
    public String toString() {
        return "AbstractDomainClass{" +
                "id=" + id +
                ", version=" + version +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
