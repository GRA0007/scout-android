package benpai.scoutsaustralia;

public class ProgressTrackerEntry {
    private String name, badgeId, startDate, endDate, notes, remindMe, color;
    private String[] subList;
    private Boolean starred;

    public ProgressTrackerEntry() {}

    public ProgressTrackerEntry(String name, String badgeId, String startDate, String endDate, String notes, String remindMe, String color, String[] subList, Boolean starred) {
        this.name = name;
        this.badgeId = badgeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.subList = subList;
        this.starred = starred;
        this.remindMe = remindMe;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String[] getSubList() {
        return subList;
    }

    public void setSubList(String[] subList) {
        this.subList = subList;
    }

    public Boolean getStarred() {
        return starred;
    }

    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    public String getRemindMe() {
        return remindMe;
    }

    public void setRemindMe(String remindMe) {
        this.remindMe = remindMe;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
