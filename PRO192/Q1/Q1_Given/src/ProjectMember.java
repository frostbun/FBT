public class ProjectMember {
    
    private int projectid;
    private String employee;
    private boolean isFullTime;
    private int hours;
    
    public ProjectMember(int projectid, String employee, boolean isFullTime, int hours) {
        this.projectid = projectid;
        this.employee = employee;
        this.isFullTime = isFullTime;
        this.hours = hours;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setIsFullTime(boolean isFullTime) {
        this.isFullTime = isFullTime;
    }
    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }
    public void setEmployee(String employee) {
        this.employee = employee;
    }
    public String getEmployee() {
        return employee;
    }
    public int getProjectid() {
        return projectid;
    }
    public boolean isIsFullTime() {
        return isFullTime;
    }
    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return String.format("%d%s%s%d", projectid, employee, isFullTime, hours);
    }
}
