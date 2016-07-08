package channel.message.colibriMessage;

import service.TimeDurationConverter;

import java.util.Date;
import java.util.UUID;

public class ColibriMessageHeader {

    private String id;
    private ContentType contentType;
    private Date date;
    private String refenceId;
    private Date expires;
    private String headerAsString;
    private static final String newLine = "<br>";

    protected ColibriMessageHeader(String headerAsString) {
        this.headerAsString = headerAsString;
    }

    protected ColibriMessageHeader(ContentType contentType) {
        this.id = UUID.randomUUID().toString();
        this.id = id.replace("-", "");
        this.contentType = contentType;
        this.date = new Date();
    }

    protected ColibriMessageHeader(ContentType contentType, String refenceId) {
        this.id = UUID.randomUUID().toString();
        this.id = id.replace("-", "");
        this.contentType = contentType;
        this.date = new Date();
        this.refenceId = refenceId;
    }

    public ColibriMessageHeader(String id, ContentType contentType, Date date, Date expires) {
        this.id = id;
        this.contentType = contentType;
        this.date = date;
        this.expires = expires;
    }

    public ColibriMessageHeader(String id, ContentType contentType, Date date, String refenceId, Date expires) {
        this.id = id;
        this.contentType = contentType;
        this.date = date;
        this.refenceId = refenceId;
        this.expires = expires;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessageHeaderAsString() {
        headerAsString = "";
        if (this.hasDate()) {
            headerAsString += "Date: " + TimeDurationConverter.date2Ical(this.getDate()) + newLine;
        }
        headerAsString += "Content-Type: " + this.getContentType().getType() + newLine
                + "Message-Id: " + this.getId() + newLine;
        if (this.hasExpires()) {
            headerAsString += "Expires: " + TimeDurationConverter.date2Ical(this.getExpires()) + newLine;
        }
        if (this.hasReferenceId()) {
            headerAsString += "Reference-Id: " + this.getRefenceId();
        }
        return headerAsString;
    }

    public String getRefenceId() {
        return refenceId;
    }

    public void setRefenceId(String refenceId) {
        this.refenceId = refenceId;
    }

    public Boolean hasReferenceId() {
        return refenceId != null;
    }

    public Boolean hasDate() {
        return date != null;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public Boolean hasExpires() {
        return expires != null;
    }
}
